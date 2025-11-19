package functional_interfaces;

// Два интерфейса с одинаковыми default-методами
interface InterfaceA {
    default void commonMethod() {
        System.out.println("Реализация из InterfaceA");
    }
}

interface InterfaceB {
    default void commonMethod() {
        System.out.println("Реализация из InterfaceB");
    }
}

// Класс, реализующий оба интерфейса
// Без явного переопределения commonMethod() компилятор выдаст ОШИБКУ:
// "Duplicate default methods named commonMethod with the parameters () and () are inherited"
class MyClass implements InterfaceA, InterfaceB {

    // Обязательное переопределение метода для устранения конфликта
    @Override
    public void commonMethod() {
        // Можно выбрать одну из реализаций:
        InterfaceA.super.commonMethod(); // вызов реализации из InterfaceA
        // InterfaceB.super.commonMethod(); // или из InterfaceB

        // Или предоставить собственную реализацию:
        // System.out.println("Собственная реализация в MyClass");
    }
}

public class Practice2_ConflictingDefaultMethods {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        obj.commonMethod(); // вызовет переопределённый метод в MyClass
    }
}