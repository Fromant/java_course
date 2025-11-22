package strings.formatting;

import java.util.Formatter;

public class Practice1_FormatterBasic {
    public static void main(String[] args) {
        // Создаём объект Formatter, связанный с System.out
        Formatter fmt = new Formatter(System.out);

        boolean flag = true;
        char letter = 'A';
        int number = 42;
        double value = 3.14159;
        String text = "Привет";

        // Использование пяти спецификаторов формата

        // %b - логическое значение
        fmt.format("Логическое значение: %b%n", flag);

        // %c - символ
        fmt.format("Символ: %c%n", letter);

        // %d - десятичное целое
        fmt.format("Целое число: %d%n", number);

        // %f - число с плавающей точкой
        fmt.format("Дробное число: %.2f%n", value); // .2 ограничивает до 2 знаков после запятой

        // %s - строковое представление
        fmt.format("Строка: %s%n", text);

        // %n - перенос строки (эквивалентно System.lineSeparator())

        // Закрываем formatter (освобождаем ресурсы)
        fmt.close();
    }
}
