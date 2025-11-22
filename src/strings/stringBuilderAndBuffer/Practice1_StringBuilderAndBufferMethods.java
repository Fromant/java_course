package strings.stringBuilderAndBuffer;

public class Practice1_StringBuilderAndBufferMethods {
    public static void main(String[] args) {
        // Работа с StringBuilder (непотокобезопасный, быстрее)
        StringBuilder sb = new StringBuilder("Hello");

        // 1. append() - добавляет данные в конец
        sb.append(" World");
        System.out.println("После append: " + sb);

        // 2. insert(int offset, String str) - вставляет строку по указанному индексу
        sb.insert(5, ",");
        System.out.println("После insert: " + sb);

        // 3. delete(int start, int end) - удаляет подстроку по индексам [start, end)
        sb.delete(5, 6);
        System.out.println("После delete: " + sb);

        // 4. replace(int start, int end, String str) - заменяет подстроку
        sb.replace(0, 5, "Hi");
        System.out.println("После replace: " + sb);

        // 5. reverse() - разворачивает строку
        sb.reverse();
        System.out.println("После reverse: " + sb);

        // 6. length() - возвращает текущую длину последовательности
        System.out.println("Длина: " + sb.length());

        // 7. capacity() - возвращает текущий размер внутреннего буфера
        System.out.println("Ёмкость буфера: " + sb.capacity());

        // 8. charAt(int index) - возвращает символ по индексу
        System.out.println("Символ [0]: " + sb.charAt(0));

        // 9. setCharAt(int index, char ch) - заменяет символ по индексу
        sb.setCharAt(0, 'x');
        System.out.println("После setCharAt: " + sb);

        // 10. toString() - преобразует в неизменяемую строку типа String
        String result = sb.toString();
        System.out.println("Результат как String: " + result);

        System.out.println("\n--- Пример с StringBuffer (аналогичные методы, но потокобезопасный) ---");

        // StringBuffer - те же методы, но синхронизированные (медленнее, но безопасны в многопотоке)
        StringBuffer buffer = new StringBuffer("Java");
        buffer.append(" Programming");
        buffer.reverse();
        System.out.println("StringBuffer после reverse: " + buffer);
    }
}
