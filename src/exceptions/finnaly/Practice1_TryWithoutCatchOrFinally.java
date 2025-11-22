package exceptions.finnaly;

public class Practice1_TryWithoutCatchOrFinally {
    public static void main(String[] args) {
        // Следующий код НЕ скомпилируется:
        /*
        try {
            int x = 10 / 0;
        }
        // ОШИБКА КОМПИЛЯЦИИ: 'try' without 'catch', 'finally' or resource declarations
        */

        // В Java блок try ДОЛЖЕН содержать хотя бы один из:
        // - catch
        // - finally
        // - ресурсные объявления (try-with-resources)

        System.out.println("Блок try без catch и finally недопустим.");
    }
}
