package classes_methods.methods;

public class OverloadingExample {
    // Перегрузка: разное количество аргументов
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Перегрузка: разные типы аргументов
    public double add(double a, double b) {
        return a + b;
    }

    // Перегрузка: разный порядок типов
    public String concatenate(String s, int n) {
        return s + n;
    }

    public String concatenate(int n, String s) {
        return n + s;
    }
}
