package strings.stringBuilderAndBuffer;

public class Practice2_ConversionsBetweenStringTypes {
    public static void main(String[] args) {
        // Исходные объекты
        String str = "Пример";
        StringBuilder sb = new StringBuilder("Строка");
        StringBuffer buffer = new StringBuffer("Буфер");

        // === Преобразование в String ===

        // 1. StringBuilder -> String
        String fromSb = sb.toString();
        System.out.println("StringBuilder → String: " + fromSb);

        // 2. StringBuffer -> String
        String fromBuffer = buffer.toString();
        System.out.println("StringBuffer → String: " + fromBuffer);

        // String уже является String — преобразование не нужно

        // === Преобразование из String ===

        // 3. String -> StringBuilder
        StringBuilder sbFromStr = new StringBuilder(str);
        System.out.println("String → StringBuilder: " + sbFromStr);

        // 4. String -> StringBuffer
        StringBuffer bufferFromStr = new StringBuffer(str);
        System.out.println("String → StringBuffer: " + bufferFromStr);

        // === Преобразование между StringBuilder и StringBuffer ===

        // 5. StringBuilder -> StringBuffer
        StringBuffer bufferFromSb = new StringBuffer(sb.toString());
        System.out.println("StringBuilder → StringBuffer: " + bufferFromSb);

        // 6. StringBuffer -> StringBuilder
        StringBuilder sbFromBuffer = new StringBuilder(buffer.toString());
        System.out.println("StringBuffer → StringBuilder: " + sbFromBuffer);

        // Важно: прямого конструктора вида new StringBuilder(StringBuffer) нет.
        // Поэтому всегда используется промежуточное преобразование через String.
    }
}
