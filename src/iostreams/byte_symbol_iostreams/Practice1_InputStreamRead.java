package iostreams.byte_symbol_iostreams;

import java.io.ByteArrayInputStream;
import java.io.IOException;

// Демонстрация работы метода read() у подкласса InputStream
public class Practice1_InputStreamRead {
    public static void main(String[] args) {
        // Исходные данные: массив байтов, представляющий строку "ABC"
        byte[] data = {65, 66, 67}; // ASCII-коды A, B, C
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);

        int byteRead;
        // Метод read() возвращает:
        // - следующий байт как int (0..255), если данные есть
        // - -1, если достигнут конец потока
        while ((byteRead = inputStream.read()) != -1) {
            System.out.println("Прочитан байт: " + byteRead + " (символ: " + (char) byteRead + ")");
        }

        try {
            inputStream.close(); // освобождение ресурсов
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
