package exceptions.multiple_catch;

// Демонстрация обработки нескольких исключений

// Исключения в иерархии: Ex1 (базовый) -> Ex2 -> Ex3 (самый специфичный)
class Ex1 extends Exception {
    public Ex1(String message) { super(message); }
}

class Ex2 extends Ex1 {
    public Ex2(String message) { super(message); }
}

class Ex3 extends Ex2 {
    public Ex3(String message) { super(message); }
}

public class Practice1_MultipleCatchBlocks {

    public static void main(String[] args) {
        // === Часть 1: несколько исключений обрабатываются одинаково ===
        try {
            int choice = (int) (Math.random() * 3);
            if (choice == 0) {
                throw new ArithmeticException("Деление на ноль");
            } else if (choice == 1) {
                throw new NullPointerException("Ссылка равна null");
            } else {
                throw new ArrayIndexOutOfBoundsException("Индекс вне диапазона");
            }
        } catch (ArithmeticException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            // Все три исключения обрабатываются одинаково
            System.out.println("Обработка нескольких исключений единым блоком: " + e.getMessage());
        }

        System.out.println();

        // === Часть 2: иерархия исключений Ex1 ← Ex2 ← Ex3 ===
        try {
            // Генерируем самое специфичное исключение — Ex3
            throw new Ex3("Это Ex3");
        } catch (Ex3 e) {
            // Сначала проверяем самый специфичный тип
            System.out.println("Перехвачено Ex3: " + e.getMessage());
        } catch (Ex2 e) {
            // Если бы было Ex2 (но не Ex3), сработал бы этот блок
            System.out.println("Перехвачено Ex2: " + e.getMessage());
        } catch (Ex1 e) {
            // Если бы было только Ex1, сработал бы этот блок
            System.out.println("Перехвачено Ex1: " + e.getMessage());
        }

        // Важно: порядок catch-блоков важен!
        // Если поставить catch (Ex1 e) первым, то Ex2 и Ex3 никогда не будут пойманы,
        // потому что Ex1 — их суперкласс, и он "захватит" все подтипы.

        // === Демонстрация ошибки: недопустимое объединение в multi-catch ===
        /*
        try {
            throw new Ex3("Тест");
        } catch (Ex1 | Ex2 | Ex3 e) {  // ОШИБКА КОМПИЛЯЦИИ!
            // Нельзя объединять исключения из одной иерархической цепочки через |
            // Компилятор: "Alternatives in a multi-catch statement cannot be related by subclassing"
        }
        */
    }
}