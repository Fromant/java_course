package iostreams.byte_symbol_iostreams;

import java.io.Closeable;
import java.io.IOException;

// Интерфейс AutoCloseable (появился в Java 7) позволяет автоматически
// закрывать ресурсы, реализующие этот интерфейс, с помощью конструкции try-with-resources.

// Все потоки ввода-вывода (InputStream, OutputStream, Reader, Writer и др.)
// реализуют AutoCloseable (через Closeable, который наследует AutoCloseable).

class CustomResource implements AutoCloseable {
    public void doWork() {
        System.out.println("Выполнение работы...");
    }

    @Override
    public void close() throws IOException {
        System.out.println("Ресурс автоматически закрыт.");
        // Здесь можно освободить файловые дескрипторы, сетевые соединения и т.д.
    }
}

public class Practice4_AutoCloseable {
    public static void main(String[] args) {
        // Использование try-with-resources - close() вызывается автоматически
        try (CustomResource resource = new CustomResource()) {
            resource.doWork();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Без try-with-resources пришлось бы писать finally и вручную вызывать close()

        // Вывод: AutoCloseable гарантирует корректное освобождение ресурсов,
        // даже если в блоке try произошло исключение.
    }
}