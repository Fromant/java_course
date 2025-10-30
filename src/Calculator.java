/**
 * Класс представляет собой простой учебный калькулятор,
 * поддерживающий основные арифметические операции: сложение, вычитание,
 * умножение и деление.
 *
 * @author Крутянский Роман
 * @version 1.0
 */
public class Calculator {

    /**
     * Складывает два числа.
     *
     * @param a первое слагаемое
     * @param b второе слагаемое
     * @return сумма чисел {@code a} и {@code b}
     */
    public double add(double a, double b) {
        // Возвращаем сумму двух чисел
        return a + b;
    }

    /**
     * Вычитает второе число из первого.
     *
     * @param a уменьшаемое
     * @param b вычитаемое
     * @return разность чисел {@code a} и {@code b}
     */
    public double subtract(double a, double b) {
        // Возвращаем разность a - b
        return a - b;
    }

    /**
     * Умножает два числа.
     *
     * @param a первый множитель
     * @param b второй множитель
     * @return произведение чисел {@code a} и {@code b}
     */
    public double multiply(double a, double b) {
        // Возвращаем произведение a * b
        return a * b;
    }

    /**
     * Делит первое число на второе.
     *
     * @param a делимое
     * @param b делитель
     * @return частное от деления {@code a} на {@code b}
     * @throws ArithmeticException если {@code b} равно нулю
     */
    public double divide(double a, double b) {
        // Проверяем деление на ноль
        if (b == 0) {
            // Генерируем исключение при попытке деления на ноль
            throw new ArithmeticException("Деление на ноль невозможно.");
        }
        // Возвращаем частное a / b
        return a / b;
    }

    /**
     * Основной метод для запуска программы.
     * Демонстрирует работу калькулятора с примерами.
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args) {
        // Создаём экземпляр калькулятора
        Calculator calc = new Calculator();

        // Пример сложения
        double result = calc.add(10.5, 4.3);
        System.out.println("10.5 + 4.3 = " + result);

        // Пример вычитания
        result = calc.subtract(10.5, 4.3);
        System.out.println("10.5 - 4.3 = " + result);

        // Пример умножения
        result = calc.multiply(10.5, 4.3);
        System.out.println("10.5 * 4.3 = " + result);

        // Пример деления
        result = calc.divide(10.5, 4.3);
        System.out.println("10.5 / 4.3 = " + result);

        // Пример деления на ноль (закомментированный)
        /*
        try {
            calc.divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        */
    }
}