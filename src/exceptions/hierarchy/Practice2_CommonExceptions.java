package exceptions.hierarchy;

public class Practice2_CommonExceptions {

    public static void main(String[] args) {
        // 1. ArithmeticException - возникает при арифметических ошибках, например делении на ноль
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }

        // 2. ArrayIndexOutOfBoundsException - выход за пределы массива
        try {
            int[] arr = {1, 2, 3};
            int value = arr[5]; // индекс 5 не существует
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException: " + e.getMessage());
        }

        // 3. IllegalArgumentException - передан недопустимый аргумент в метод
        try {
            validateAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException: " + e.getMessage());
        }

        // 4. ClassCastException - попытка привести объект к несовместимому типу
        try {
            Object obj = "Строка";
            Integer num = (Integer) obj; // нельзя привести String к Integer
        } catch (ClassCastException e) {
            System.out.println("ClassCastException: " + e.getMessage());
        }

        // 5. NullPointerException - попытка использовать ссылку, равную null
        try {
            String text = null;
            int len = text.length(); // вызов метода у null
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e.getMessage());
        }
    }

    // Вспомогательный метод для генерации IllegalArgumentException
    public static void validateAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным: " + age);
        }
    }
}
