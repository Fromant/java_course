import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.util.*;

public class Huffman {

    static class Node implements Comparable<Node> {
        byte symbol;
        int frequency;
        Node left, right;

        Node(byte symbol, int frequency) {
            this.symbol = symbol;
            this.frequency = frequency;
        }

        Node(int frequency, Node left, Node right) {
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.frequency, other.frequency);
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Использование:");
            System.err.println("  java Huffman -c <входной_файл> <архив>");
            System.err.println("  java Huffman -d <архив> <выходной_файл>");
            return;
        }

        String mode = args[0];
        String inputFile = args[1];
        String outputFile = args[2];

        try {
            if ("-c".equals(mode)) {
                compress(inputFile, outputFile);
            } else if ("-d".equals(mode)) {
                decompress(inputFile, outputFile);
            } else {
                System.err.println("Неизвестный режим: " + mode);
            }
        } catch (IOException e) {
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace();
        }
    }

    static void compress(String inputFile, String outputFile) throws IOException {
        byte[] data = Files.readAllBytes(new File(inputFile).toPath());
        if (data.length == 0) {
            Files.write(new File(outputFile).toPath(), new byte[0]);
            return;
        }

        Map<Byte, Integer> freqMap = new HashMap<>();
        for (byte b : data) {
            freqMap.put(b, freqMap.getOrDefault(b, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Map.Entry<Byte, Integer> entry : freqMap.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }

        Node root;
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.add(new Node(left.frequency + right.frequency, left, right));
        }
        root = pq.poll();

        Map<Byte, String> codes = new HashMap<>();
        buildCodes(root, "", codes);

        long totalBits = 0;
        for (byte b : data) {
            totalBits += codes.get(b).length();
        }

        long totalBytes = (totalBits + 7) / 8;

        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.write(intToBytes(freqMap.size()));
            fos.write(longToBytes(totalBits));

            for (Map.Entry<Byte, Integer> entry : freqMap.entrySet()) {
                fos.write(entry.getKey());
                fos.write(intToBytes(entry.getValue()));
            }

            BitOutputStream bos = new BitOutputStream(fos);
            for (byte b : data) {
                String code = codes.get(b);
                for (char c : code.toCharArray()) {
                    bos.writeBit(c == '1');
                }
            }
            bos.flush();
        }
    }

    static void decompress(String inputFile, String outputFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(inputFile)) {
            byte[] nBytes = fis.readNBytes(4);
            if (nBytes.length != 4) throw new IOException("Повреждённый заголовок");
            int n = bytesToInt(nBytes);

            if (n == 0) {
                Files.write(new File(outputFile).toPath(), new byte[0]);
                return;
            }

            byte[] totalBitsBytes = fis.readNBytes(8);
            if (totalBitsBytes.length != 8) throw new IOException("Повреждённый заголовок");
            long totalBits = bytesToLong(totalBitsBytes);

            Map<Byte, Integer> freqMap = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int b = fis.read();
                if (b == -1) throw new IOException("Недостаточно данных");
                byte symbol = (byte) b;
                byte[] freqBytes = fis.readNBytes(4);
                if (freqBytes.length != 4) throw new IOException("Недостаточно данных");
                int freq = bytesToInt(freqBytes);
                freqMap.put(symbol, freq);
            }

            if (freqMap.size() == 1) {
                byte symbol = freqMap.keySet().iterator().next();
                int symbolCount = (int) totalBits; // каждый символ = 1 бит "0"
                byte[] result = new byte[symbolCount];
                Arrays.fill(result, symbol);
                Files.write(new File(outputFile).toPath(), result);
                return;
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            for (Map.Entry<Byte, Integer> entry : freqMap.entrySet()) {
                pq.add(new Node(entry.getKey(), entry.getValue()));
            }

            while (pq.size() > 1) {
                Node left = pq.poll();
                Node right = pq.poll();
                pq.add(new Node(left.frequency + right.frequency, left, right));
            }

            Node root = pq.poll();
            List<Byte> output = new ArrayList<>();
            Node current = root;

            BitInputStream bis = new BitInputStream(fis);
            for (long i = 0; i < totalBits; i++) {
                boolean bit = bis.readBit();
                current = bit ? current.right : current.left;
                if (current.isLeaf()) {
                    output.add(current.symbol);
                    current = root;
                }
            }

            byte[] result = new byte[output.size()];
            for (int i = 0; i < output.size(); i++) {
                result[i] = output.get(i);
            }
            Files.write(new File(outputFile).toPath(), result);
        }
    }

    static void buildCodes(Node node, String code, Map<Byte, String> codes) {
        if (node == null) return;
        if (node.isLeaf()) {
            codes.put(node.symbol, code.isEmpty() ? "0" : code);
        } else {
            buildCodes(node.left, code + "0", codes);
            buildCodes(node.right, code + "1", codes);
        }
    }

    static byte[] intToBytes(int value) {
        return ByteBuffer.allocate(4).putInt(value).array();
    }

    static int bytesToInt(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }

    static byte[] longToBytes(long value) {
        return ByteBuffer.allocate(8).putLong(value).array();
    }

    static long bytesToLong(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getLong();
    }
}

class BitOutputStream {
    private final OutputStream out;
    private int buffer = 0;
    private int count = 0;

    BitOutputStream(OutputStream out) {
        this.out = out;
    }

    void writeBit(boolean bit) throws IOException {
        buffer = (buffer << 1) | (bit ? 1 : 0);
        count++;
        if (count == 8) {
            out.write(buffer);
            buffer = 0;
            count = 0;
        }
    }

        void flush() throws IOException {
            if (count > 0) {
                buffer <<= (8 - count);
                out.write(buffer);
            }
            out.flush();
        }
}

class BitInputStream {
    private final InputStream in;
    private int buffer = 0;
    private int count = 0;

    BitInputStream(InputStream in) {
        this.in = in;
    }

    boolean readBit() throws IOException {
        if (count == 0) {
            int b = in.read();
            if (b == -1) {
                throw new IOException("Неожиданный конец входных данных");
            }
            buffer = b;
            count = 8;
        }
        count--;
        return ((buffer >> count) & 1) == 1;
    }
}