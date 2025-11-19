package inheritance_polymorphism.object_class;

// Класс Point представляет точку на плоскости с целочисленными координатами
class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Соглашения, которым должен следовать метод equals():
    //
    // 1. Рефлексивность: для любого ненулевого x, x.equals(x) == true.
    // 2. Симметричность: для любых ненулевых x и y,
    //    если x.equals(y) == true, то y.equals(x) == true.
    // 3. Транзитивность: для любых ненулевых x, y, z,
    //    если x.equals(y) == true и y.equals(z) == true, то x.equals(z) == true.
    // 4. Непротиворечивость: повторные вызовы должны возвращать один и тот же результат,
    //    если данные объектов не менялись.
    // 5. Для любого ненулевого x: x.equals(null) == false.
    //
    // Нарушение этих правил может привести к непредсказуемому поведению
    // в коллекциях, таких как HashMap, HashSet и др.
    @Override
    public boolean equals(Object obj) {
        // 1. Проверка на идентичность
        if (this == obj) {
            return true;
        }

        // 2. Проверка на null
        if (obj == null) {
            return false;
        }

        // 3. Проверка типа: объект должен быть того же класса
        // Используем getClass() для строгой проверки типа
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        // 4. Приведение типа
        Point other = (Point) obj;

        // 5. Сравнение значений полей
        return this.x == other.x && this.y == other.y;
    }
}


public class Practice1_EqualsOverride {
    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        Point p2 = new Point(1, 2);
        Point p3 = new Point(3, 4);
        Point p4 = null;

        System.out.println(p1.equals(p2)); // true — одинаковые координаты
        System.out.println(p1.equals(p3)); // false — разные координаты
        System.out.println(p1.equals(p4)); // false — сравнение с null
        System.out.println(p1.equals("строка")); // false — разные типы

        // Проверка рефлексивности
        System.out.println(p1.equals(p1)); // true
    }
}