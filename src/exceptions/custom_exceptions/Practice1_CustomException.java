package exceptions.custom_exceptions;

// Собственное проверяемое исключение (наследуется от Exception)
// По соглашению название заканчивается на "Exception"

class MyValidationException extends Exception {

    // 1. Конструктор без параметров
    public MyValidationException() {
        super(); // вызывает конструктор суперкласса без аргументов
    }

    // 2. Конструктор с сообщением об ошибке
    public MyValidationException(String message) {
        super(message); // передаёт сообщение в суперкласс
    }

    // 3. Конструктор с сообщением и первопричиной (cause)
    public MyValidationException(String message, Throwable cause) {
        super(message, cause); // сохраняет цепочку исключений
    }

    // Дополнительно (необязательно, но иногда полезно):
    // 4. Конструктор только с причиной
    public MyValidationException(Throwable cause) {
        super(cause);
    }
}

// Демонстрация использования собственного исключения
class Validator {
    public static void validateAge(int age) throws MyValidationException {
        if (age < 0) {
            throw new MyValidationException("Возраст не может быть отрицательным");
        }
        if (age > 150) {
            throw new MyValidationException("Возраст не может превышать 150 лет");
        }
    }
}

public class Practice1_CustomException {
    public static void main(String[] args) {
        try {
            Validator.validateAge(-5);
        } catch (MyValidationException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Validator.validateAge(200);
        } catch (MyValidationException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
