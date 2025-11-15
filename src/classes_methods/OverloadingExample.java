package classes_methods;

class ClassWithOverloads {
    public void printNum(Integer i) {
        System.out.printf("Integer = %d%n", i);
    }

    public void printNum(int i) {
        System.out.printf("int = %d%n", i);
    }

    public void printNum(Float f) {
        System.out.printf("Float = %.4f%n", f);
    }

    public void printNum(Number n) {
        System.out.println("Number=" + n);
    }
}

public class OverloadingExample {
    public static void main(String[] args) {
        ClassWithOverloads a = new ClassWithOverloads();

        // Массив объявлен как Number[], поэтому каждый элемент имеет статический тип Number
        Number[] num = {
                new Integer(1),   // фактически Integer, но в массиве — Number
                11,               // int -> Integer -> приведён к Number
                1.11f,            // float -> Float -> приведён к Number
                11.11             // double -> Double -> приведён к Number
        };

        // (1) Цикл: все аргументы имеют статический тип Number
        // Компилятор выбирает printNum(Number n) для ВСЕХ элементов,
        // потому что переменная n объявлена как Number.
        System.out.println("Результаты в цикле (1):");
        for (Number n : num) {
            a.printNum(n); // вызывается ТОЛЬКО printNum(Number n)
        }

        System.out.println(); // пустая строка для разделения

        // (2) Прямые вызовы: компилятор видит точные типы аргументов
        System.out.println("Результаты прямых вызовов (2):");

        // Аргумент - объект типа Integer -> вызывается printNum(Integer i)
        a.printNum(new Integer(1));

        // Аргумент - примитив int -> вызывается printNum(int i)
        a.printNum(11);

        // Аргумент - примитив float -> упаковывается в Float -> вызывается printNum(Float f)
        a.printNum(1.11f);

        // Аргумент - примитив double -> упаковывается в Double
        // Среди перегруженных методов нет printNum(Double) или printNum(double),
        // но Double является подклассом Number -> вызывается printNum(Number n)
        a.printNum(11.11);
    }
}
