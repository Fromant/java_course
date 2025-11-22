package exceptions.multiple_catch;

public class Practice2_FinalInCatch {

    public static void main(String[] args) {
        try {
            // Искусственное исключение
            throw new IllegalArgumentException("Ошибка!");
        } catch (final IllegalArgumentException e) {
            // Ключевое слово final означает, что ссылка 'e' не может быть изменена внутри блока
            // То есть нельзя написать: e = new IllegalArgumentException("Новое исключение");
            System.out.println("Поймано исключение: " + e.getMessage());

            // Попытка переприсвоить — вызовет ОШИБКУ КОМПИЛЯЦИИ:
            // e = new RuntimeException(); // ← не разрешено

            // Однако можно вызывать методы у 'e', так как это не изменяет ссылку
            e.printStackTrace();
        }

        // Зачем использовать final в catch?
        // 1. Для предотвращения случайного изменения ссылки на исключение.
        // 2. Улучшает читаемость и безопасность кода (по аналогии с final-параметрами).
        // 3. Необязательно, но допустимо и иногда полезно.

        // Также можно вкладывать блоки try друг в друга:
        try {
            System.out.println("Внешний try");
            try {
                System.out.println("Внутренний try");
                int x = 1 / 0;
            } catch (ArithmeticException inner) {
                System.out.println("Обработка во внутреннем catch");
            }
        } catch (Exception outer) {
            System.out.println("Обработка во внешнем catch (не сработает, если исключение уже перехвачено)");
        }
    }
}
