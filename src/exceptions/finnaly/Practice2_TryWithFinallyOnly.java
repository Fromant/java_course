package exceptions.finnaly;

public class Practice2_TryWithFinallyOnly {
    public static void main(String[] args) {
        // Блок try с finally (без catch) — РАЗРЕШЁН
        try {
            System.out.println("Выполнение кода в try");
            int result = 10 / 0; // вызовет ArithmeticException
        } finally {
            // Этот блок выполнится ВСЕГДА — даже если произошло исключение
            System.out.println("Блок finally выполнен");
        }

        // Примечание: так как исключение не перехватывается (нет catch),
        // оно распространяется вверх по стеку вызовов после выполнения finally.
        // В данном случае программа аварийно завершится после вывода "Блок finally выполнен".
    }
}
