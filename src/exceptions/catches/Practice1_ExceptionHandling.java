package exceptions.catches;

public class Practice1_ExceptionHandling {

    public static void main(String[] args) {
        System.out.println("Начало программы");

        try {
            // Генерация первого исключения — будет перехвачено
            int result = 10 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Перехвачено исключение: " + e.getMessage());
        }

        System.out.println("Продолжение выполнения после обработанного исключения");

        // Генерация второго исключения — НЕ будет перехвачено
        // Это вызовет аварийное завершение программы
        int[] arr = {1, 2, 3};
        int value = arr[10]; // ArrayIndexOutOfBoundsException

        // Эта строка никогда не выполнится
        System.out.println("Это сообщение не будет напечатано");
    }
}
