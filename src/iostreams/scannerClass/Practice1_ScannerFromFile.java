package iostreams.scannerClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Practice1_ScannerFromFile {
    public static void main(String[] args) {
        // Имя файла для чтения (должен находиться в корне проекта или указан полный путь)
        final String fileName = "input.txt";

        // Создаём объект Scanner, связанный с файлом
        // Scanner принимает File, InputStream, Reader и другие источники
        try (Scanner scanner = new Scanner(new File(fileName))) {
            // Проверяем, есть ли ещё данные в файле
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine(); // читаем целую строку
                System.out.println("Прочитано: " + line);
            }

            // Альтернативные методы для чтения по токенам (разделённым пробелами/переносами):
            /*
            while (scanner.hasNext()) {
                String token = scanner.next();      // читает следующее слово
                int number = scanner.nextInt();     // читает целое число
                double value = scanner.nextDouble(); // читает дробное число
            }
            */

        } catch (FileNotFoundException e) {
            // Если файл не найден, выводим сообщение
            System.err.println("Файл не найден: " + fileName);
        }

        // Примечание: Scanner автоматически закрывается благодаря try-with-resources,
        // так как он реализует интерфейс AutoCloseable.
    }
}
