package classes_methods;

public class VarArgsExample {

    // Основной метод с переменным числом целых чисел
    public void display(int... numbers) {
        System.out.print("Целые числа: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Перегрузка: переменное число строк
    public void display(String... texts) {
        System.out.print("Строки: ");
        for (String s : texts) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    // Перегрузка: переменное число объектов типа double
    public void display(double... values) {
        System.out.print("Дробные числа: ");
        for (double d : values) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    // Перегрузка: один обязательный параметр + переменное число целых чисел
    // Такая сигнатура считается другой, поэтому перегрузка допустима
    public void display(String prefix, int... numbers) {
        System.out.print(prefix + ": ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    // Перегрузка: фиксированное количество параметров (не varargs)
    // Имеет приоритет над varargs при точном совпадении
    public void display(int a, int b) {
        System.out.println("Два целых числа (фиксированный метод): " + a + ", " + b);
    }

    // Основной метод для демонстрации
    public static void main(String[] args) {
        VarArgsExample example = new VarArgsExample();

        // Вызов метода с int...
        example.display(1, 2, 3);

        // Вызов метода с String...
        example.display("Привет", "мир");

        // Вызов метода с double...
        example.display(1.5, 2.7, 3.14);

        // Вызов перегруженного метода с префиксом
        example.display("Результат", 10, 20, 30);

        // Вызов фиксированного метода (имеет приоритет над int...)
        example.display(5, 10); // вызовет display(int a, int b), а не display(int...)
    }
}