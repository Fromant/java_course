package iostreams.byte_symbol_iostreams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Демонстрация работы метода write(int) у подкласса OutputStream
public class Practice2_OutputStreamWrite {
    public static void main(String[] args) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Метод write(int b) записывает младший байт аргумента (b & 0xFF)
        outputStream.write(65); // 'A'
        outputStream.write(66); // 'B'
        outputStream.write(67); // 'C'

        // Получаем записанные данные как массив байтов
        byte[] result = outputStream.toByteArray();
        System.out.println("Записано байтов: " + result.length);
        System.out.println("Результат как строка: " + new String(result));

        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
