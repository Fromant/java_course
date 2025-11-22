package strings.stringClass;

public class Practice1_StringMethods {
    public static void main(String[] args) {
        String text = "  Hello, World!  ";

        // 1. length() — возвращает длину строки (количество символов)
        System.out.println("Длина строки: " + text.length());

        // 2. trim() — удаляет начальные и конечные пробелы
        String trimmed = text.trim();
        System.out.println("После trim(): '" + trimmed + "'");

        // 3. toLowerCase() — преобразует строку в нижний регистр
        System.out.println("В нижнем регистре: " + trimmed.toLowerCase());

        // 4. toUpperCase() — преобразует строку в верхний регистр
        System.out.println("В верхнем регистре: " + trimmed.toUpperCase());

        // 5. substring(int beginIndex, int endIndex) — возвращает подстроку
        System.out.println("Подстрока [0, 5): '" + trimmed.substring(0, 5) + "'");

        // 6. indexOf(String str) — возвращает индекс первого вхождения подстроки
        System.out.println("Индекс 'World': " + trimmed.indexOf("World"));

        // 7. equals(Object obj) — сравнивает содержимое строк (не ссылки!)
        String another = "Hello, World!";
        System.out.println("Сравнение с 'Hello, World!': " + trimmed.equals(another));

        // 8. startsWith(String prefix) — проверяет, начинается ли строка с префикса
        System.out.println("Начинается с 'Hello': " + trimmed.startsWith("Hello"));

        // 9. replace(char oldChar, char newChar) — заменяет все вхождения символа
        System.out.println("Замена 'o' на '0': " + trimmed.replace('o', '0'));

        // 10. split(String regex) — разбивает строку на массив по регулярному выражению
        String[] parts = trimmed.split(", ");
        System.out.println("Части после split: [" + parts[0] + ", " + parts[1] + "]");
    }
}
