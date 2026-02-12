public class Main {
    public static void main(String[] args) {
        // Практика #1: Примеры использования метода decode()
        System.out.println("=== Практика #1: decode() ===");
        Integer dec1 = Integer.decode("123");       // десятичное
        Integer dec2 = Integer.decode("+123");      // положительное десятичное
        Integer dec3 = Integer.decode("-123");      // отрицательное десятичное
        Integer hex1 = Integer.decode("0x1A");      // шестнадцатеричное (0x)
        Integer hex2 = Integer.decode("#1A");       // шестнадцатеричное (#)
        Integer oct1 = Integer.decode("017");       // восьмеричное (начинается с 0)

        System.out.println("dec1 = " + dec1); // 123
        System.out.println("dec2 = " + dec2); // 123
        System.out.println("dec3 = " + dec3); // -123
        System.out.println("hex1 = " + hex1); // 26
        System.out.println("hex2 = " + hex2); // 26
        System.out.println("oct1 = " + oct1); // 15

        // Практика #2: Все способы создания экземпляра Boolean
        System.out.println("\n=== Практика #2: Создание Boolean ===");
        Boolean b1 = Boolean.valueOf(true);
        Boolean b2 = Boolean.valueOf(false);
        Boolean b3 = Boolean.valueOf("true");
        Boolean b4 = Boolean.valueOf("TRUE");
        Boolean b5 = Boolean.valueOf("false");
        Boolean b6 = Boolean.valueOf("anyOtherString"); // false
        // Boolean b7 = new Boolean(true); // deprecated, не рекомендуется

        System.out.println("b1 = " + b1); // true
        System.out.println("b2 = " + b2); // false
        System.out.println("b3 = " + b3); // true
        System.out.println("b4 = " + b4); // true
        System.out.println("b5 = " + b5); // false
        System.out.println("b6 = " + b6); // false

        // Практика #3: NullPointerException при автоупаковке/автораспаковке
        System.out.println("\n=== Практика #3: NullPointerException ===");
        Integer nullInt = null;
        try {
            int unboxed = nullInt; // NullPointerException при автораспаковке
        } catch (NullPointerException e) {
            System.out.println("Поймано исключение: " + e.getClass().getSimpleName());
        }

        // Практика #4: Сравнение Integer и int
        System.out.println("\n=== Практика #4: Сравнение Integer ===");

        int i1 = 128;
        Integer a1 = i1;
        Integer b1_obj = i1;
        System.out.println("a1==i1 " + (a1 == i1));                     // true (unboxing)
        System.out.println("b1==i1 " + (b1_obj == i1));                 // true (unboxing)
        System.out.println("a1==b1 " + (a1 == b1_obj));                 // false (разные объекты)
        System.out.println("a1.equals(i1) -> " + a1.equals(i1));        // true
        System.out.println("b1.equals(i1) -> " + b1_obj.equals(i1));    // true
        System.out.println("a1.equals(b1) -> " + a1.equals(b1_obj));    // true

        int i2 = 127;
        Integer a2 = i2;
        Integer b2_obj = i2;
        System.out.println("a2==i2 " + (a2 == i2));                     // true (unboxing)
        System.out.println("b2==i2 " + (b2_obj == i2));                 // true (unboxing)
        System.out.println("a2==b2 " + (a2 == b2_obj));                 // true (кэшированные объекты)
        System.out.println("a2.equals(i2) -> " + a2.equals(i2));        // true
        System.out.println("b2.equals(i2) -> " + b2_obj.equals(i2));    // true
        System.out.println("a2.equals(b2) -> " + a2.equals(b2_obj));    // true

        // Объяснение:
        // IntegerCache кэширует значения от -128 до 127.
        // При автоупаковке значений в этом диапазоне возвращаются одни и те же объекты.
        // Поэтому a2 == b2 даёт true, а a1 == b1 — false (128 вне кэша).
    }
}