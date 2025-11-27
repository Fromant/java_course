public class Main {

    public static void main(String[] args) {
        // =============== Практика #1 ===============
        // Операторы с базовыми типами и String

        // Присваивание и арифметические операторы
        int a = 10;
        int b = 3;
        double x = 5.5;
        boolean flag = true;

        // Операторы присваивания
        int c = a;                // =
        c += b;                   // +=
        c -= 2;                   // -=
        c *= 2;                   // *=
        c /= 3;                   // /=
        c %= 4;                   // %=

        // Тернарный оператор ?:
        int max = (a > b) ? a : b;

        // Логические операторы короткого замыкания
        boolean result1 = (a > 0) || (b < 0);  // ||
        boolean result2 = (a > 0) && (b > 0);  // &&

        // Побитовые операторы
        int bitwiseOr = a | b;     // |
        int bitwiseXor = a ^ b;    // ^
        int bitwiseAnd = a & b;    // &

        // Операторы сравнения
        boolean eq = (a == b);     // ==
        boolean neq = (a != b);    // !=
        boolean gt = (a > b);      // >
        boolean ge = (a >= b);     // >=
        boolean lt = (a < b);      // <
        boolean le = (a <= b);     // <=

        // Операторы сдвига
        int shiftRight = a >> 1;   // >>
        int shiftRightUnsigned = a >>> 1; // >>>
        int shiftLeft = a << 1;    // <<

        // Арифметические операторы + и -
        int sum = a + b;           // +
        int diff = a - b;          // -

        // Арифметические операторы * / %
        int product = a * b;       // *
        double quotient = x / b;   // /
        int remainder = a % b;     // %

        // Инкремент и декремент: префиксная и постфиксная формы
        int i = 5;
        int postfixInc = i++;      // сначала значение i присваивается, потом инкремент
        int prefixInc = ++i;       // сначала инкремент, потом присваивание

        int j = 5;
        int postfixDec = j--;      // сначала значение j присваивается, потом декремент
        int prefixDec = --j;       // сначала декремент, потом присваивание

        // Унарные операторы ~ и !
        int bitwiseNot = ~a;       // ~
        boolean logicalNot = !flag; // !

        // Операторы ( ) и [ ]
        int grouped = (a + b) * 2; // ()
        int[] arr = {1, 2, 3};
        int element = arr[0];      // []

        // Конкатенация строк с помощью + и +=
        String str1 = "Hello";
        String str2 = "World";
        String str3 = str1 + " " + str2; // +
        str1 += "!";                     // +=

        // Логические операторы ==, != и = с объектами и литералами
        Integer obj1 = 100;
        Integer obj2 = 100;
        Integer obj3 = new Integer(100);
        String s1 = "test";
        String s2 = "test";
        String s3 = new String("test");

        System.out.println("obj1 == obj2: " + (obj1 == obj2)); // true (кэш Integer)
        System.out.println("obj1 == obj3: " + (obj1 == obj3)); // false (разные объекты)
        System.out.println("s1 == s2: " + (s1 == s2));         // true (строковый пул)
        System.out.println("s1 == s3: " + (s1 == s3));         // false (новый объект)
        System.out.println("s1.equals(s3): " + s1.equals(s3)); // true (сравнение содержимого)

        // =============== Практика #2 ===============
        // Оператор instanceof

        Object obj = "I am a String";
        System.out.println("obj instanceof String: " + (obj instanceof String)); // true
        System.out.println("obj instanceof Object: " + (obj instanceof Object)); // true

        Object num = 42;
        System.out.println("num instanceof Integer: " + (num instanceof Integer)); // true

        // Наследование
        Animal animal = new Dog();
        System.out.println("animal instanceof Dog: " + (animal instanceof Dog));     // true
        System.out.println("animal instanceof Animal: " + (animal instanceof Animal)); // true

        // null и instanceof
        Object nullObj = null;
        System.out.println("nullObj instanceof String: " + (nullObj instanceof String)); // false
        System.out.println("nullObj instanceof Object: " + (nullObj instanceof Object)); // false

    }
}

// Вспомогательные классы для демонстрации instanceof
class Animal {}

class Dog extends Animal {}