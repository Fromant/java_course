package inner_classes.nested;

// Интерфейс с вложенным статическим классом
interface MyInterface {

    // Вложенный класс в интерфейсе неявно является public static
    // (в интерфейсе нельзя объявить нестатический класс)
    class NestedInInterface {
        private String message = "Привет из вложенного класса в интерфейсе!";

        public void printMessage() {
            System.out.println(message);
        }

        // Вложенный класс имеет доступ только к статическим членам интерфейса
        // (все поля в интерфейсе неявно public static final)
        public void printConstant() {
            System.out.println("Константа из интерфейса: " + CONSTANT);
        }
    }

    // Статическая константа интерфейса (неявно public static final)
    int CONSTANT = 42;
}

// Класс для демонстрации использования
public class Practice1_NestedInInterface {

    public static void main(String[] args) {
        // Создание экземпляра вложенного класса
        // Так как класс статический, экземпляр внешнего интерфейса не нужен
        MyInterface.NestedInInterface obj = new MyInterface.NestedInInterface();

        // Вызов методов вложенного класса
        obj.printMessage();
        obj.printConstant();

        // Альтернативный способ: создание и вызов в одной строке
        new MyInterface.NestedInInterface().printMessage();
    }
}
