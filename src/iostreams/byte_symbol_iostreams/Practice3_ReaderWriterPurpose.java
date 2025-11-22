package iostreams.byte_symbol_iostreams;

// Reader и Writer - это символьные потоки, в отличие от байтовых InputStream/OutputStream.
// Основные причины их существования:

// 1. Работа с символами, а не байтами.
//    - InputStream/OutputStream оперируют байтами (8 бит).
//    - Reader/Writer оперируют символами (char - 16 бит в Java), что важно для текста в Unicode.

// 2. Поддержка кодировок (charset).
//    - При создании FileReader можно указать кодировку (например, UTF-8).
//    - Без этого при чтении текста в другой кодировке возникнут кракозябры.

// 3. Удобство для текстовых данных.
//    - Reader имеет метод read(char[]), Writer - write(String).
//    - Нет необходимости вручную преобразовывать байты в строки и обратно.

// Пример:
//   - FileInputStream + InputStreamReader -> FileReader
//   - FileOutputStream + OutputStreamWriter -> FileWriter

public class Practice3_ReaderWriterPurpose {
    public static void main(String[] args) {
        System.out.println("Reader/Writer нужны для корректной работы с текстом в различных кодировках.");
        System.out.println("InputStream/OutputStream - для байтов (изображения, аудио, сериализация и т.д.).");
    }
}