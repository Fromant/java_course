package functional_interfaces;

// Интерфейс с default-методом и статическим методом
interface MyInterface {
    // Абстрактный метод (по умолчанию)
    void abstractMethod();

    // Неабстрактный метод с реализацией по умолчанию
    default void defaultMethod() {
        System.out.println("Вызван default-метод из MyInterface");
    }

    // Статический метод — вызывается через имя интерфейса
    static void staticMethod() {
        System.out.println("Вызван статический метод из MyInterface");
    }
}

// Класс, реализующий интерфейс
class MyClass implements MyInterface {
    @Override
    public void abstractMethod() {
        System.out.println("Реализация абстрактного метода");
    }

    // Можно переопределить default-метод, если нужно
    @Override
    public void defaultMethod() {
        System.out.println("Переопределённый default-метод в MyClass");
    }
}

public class Practice1_DefaultAndStaticMethods {
    public static void main(String[] args) {
        MyClass obj = new MyClass();

        // 1. Вызов абстрактного метода (реализован в классе)
        obj.abstractMethod();

        // 2. Вызов default-метода (переопределён в классе)
        obj.defaultMethod();

        // 3. Вызов статического метода — только через имя интерфейса
        MyInterface.staticMethod();

        // 4. Вызов default-метода через переменную интерфейсного типа
        MyInterface ref = new MyClass();
        ref.defaultMethod();

        // 5. Прямой вызов default-метода без переопределения (если бы не переопределяли):
        // obj.defaultMethod(); // использовалась бы реализация из интерфейса
    }
}
