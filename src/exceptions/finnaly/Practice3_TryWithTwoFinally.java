package exceptions.finnaly;

public class Practice3_TryWithTwoFinally {
    public static void main(String[] args) {
        // Следующий код НЕ скомпилируется:
        /*
        try {
            System.out.println("Код в try");
        } finally {
            System.out.println("Первый finally");
        } finally {
            System.out.println("Второй finally"); // ← ОШИБКА КОМПИЛЯЦИИ
        }
        // Ошибка: "unreachable statement" или "duplicate finally block"
        */

        // В Java блок try может содержать ТОЛЬКО ОДИН блок finally.
        // Несколько finally-блоков запрещены синтаксисом языка.

        System.out.println("Нельзя использовать более одного блока finally.");
    }
}
