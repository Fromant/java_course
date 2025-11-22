package strings.formatting;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

public class Practice2_FlushMethod {
    public static void main(String[] args) {
        try {
            // Создаём Formatter, записывающий в файл
            Formatter fmt = new Formatter(new FileWriter("output.txt"));

            fmt.format("Строка 1%n");
            fmt.format("Строка 2%n");

            // Данные могут быть временно сохранены в буфере и ещё не записаны на диск.
            // Метод flush() принудительно сбрасывает буфер и гарантирует,
            // что все данные записаны немедленно.
            fmt.flush();

            // Имитация задержки или аварийного завершения...
            // Без flush() данные могли бы быть потеряны.

            fmt.format("Строка 3%n");
            fmt.close(); // close() автоматически вызывает flush()

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Вывод: flush() гарантирует, что все данные из буфера немедленно отправлены
        // в целевой поток (файл, консоль и т.д.), даже если буфер ещё не заполнен.
    }
}