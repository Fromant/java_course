package inheritance_polymorphism.overrides;

// Демонстрация, как аннотация @Override помогает обнаружить ошибку

class Vehicle {
    public void startEngine() {
        System.out.println("Двигатель запущен");
    }
}

class Car extends Vehicle {
    // Предположим, программист ошибся в имени метода
    // Без @Override компилятор не заметил бы, что это НЕ переопределение,
    // а новый метод. С @Override — ошибка компиляции.

    @Override
    public void startEngin() { // ОПЕЧАТКА: пропущена буква 'e' в конце
        System.out.println("Двигатель автомобиля запущен");
    }

    // Compile error:
    // "Method does not override method from its superclass"
    // Благодаря @Override пользователь ЯП сразу увидит ошибку и исправит имя метода.
}

// Если убрать @Override, метод startEngin() просто станет новым,
// и полиморфизм работать не будет: вызов через ссылку Vehicle вызовет старый метод.

public class Practice3_OverrideAnnotation {
    public static void main(String[] args) {
        Vehicle car = new Car();
        car.startEngine(); // без исправления — вызовет метод из Vehicle, а не Car
    }
}