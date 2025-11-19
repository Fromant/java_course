package inheritance_polymorphism.overrides;

// Пример перегрузки методов (overloading)
// Методы имеют одинаковое имя, но разные параметры.
// Тип возвращаемого значения может быть одинаковым или разным — он не участвует в перегрузке.
public class Practice1_Overloading {

    // Метод с одним целочисленным параметром
    public void print(int value) {
        System.out.println("Целое число: " + value);
    }

    // Метод с двумя целочисленными параметрами
    public void print(int value1, int value2) {
        System.out.println("Два целых числа: " + value1 + ", " + value2);
    }

    // Метод с параметром типа String
    public void print(String text) {
        System.out.println("Строка: " + text);
    }

    // Метод с параметром double — другая сигнатура
    public int print(double value) {
        System.out.println("Дробное число: " + value);
        return (int) value;
    }

    public static void main(String[] args) {
        Practice1_Overloading obj = new Practice1_Overloading();

        obj.print(42);              // вызов print(int)
        obj.print(10, 20);          // вызов print(int, int)
        obj.print("Привет");        // вызов print(String)
        obj.print(3.14);            // вызов print(double)
    }
}
