package strings.stringClass;

import java.util.StringJoiner;

public class Practice2_StringJoiner {
    public static void main(String[] args) {
        // StringJoiner — утилита для построения строки с разделителями, префиксом и суффиксом

        // Пример 1: простой StringJoiner с разделителем
        StringJoiner joiner1 = new StringJoiner(", ");
        joiner1.add("яблоки");
        joiner1.add("бананы");
        joiner1.add("апельсины");
        System.out.println("Список: " + joiner1.toString()); // яблоки, бананы, апельсины

        // Пример 2: StringJoiner с префиксом и суффиксом (например, для формирования списка в скобках)
        StringJoiner joiner2 = new StringJoiner(", ", "[", "]");
        joiner2.add("красный");
        joiner2.add("зелёный");
        joiner2.add("синий");
        System.out.println("Цвета: " + joiner2.toString()); // [красный, зелёный, синий]

        // Пример 3: пустой StringJoiner — возвращает пустую строку или значение по умолчанию
        StringJoiner empty = new StringJoiner(", ", "(", ")");
        System.out.println("Пустой: " + empty.toString()); // ()

        // Пример 4: установка значения по умолчанию для пустого StringJoiner
        StringJoiner withDefault = new StringJoiner(", ", "{", "}");
        withDefault.setEmptyValue("пусто");
        System.out.println("С дефолтом: " + withDefault.toString()); // пусто
    }
}
