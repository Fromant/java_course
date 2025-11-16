package inheritance_polymorphism.inheritance;

// Демонстрация использования this и super в подклассах

class Parent {
    protected String name;

    public Parent() {
        // Конструктор по умолчанию
    }

    public Parent(String name) {
        this.name = name; // this ссылается на текущий объект (Parent)
    }

    public void introduce() {
        System.out.println("Привет, я " + name + " из класса Parent");
    }

    public void greet() {
        System.out.println("Parent говорит: Привет!");
    }
}

class Child extends Parent {
    private int age;

    // Конструктор Child вызывает конструктор родителя с помощью super
    public Child(String name, int age) {
        super(name);      // вызов конструктора суперкласса
        this.age = age;   // this используется для обращения к полю текущего класса
    }

    // Переопределённый метод
    @Override
    public void introduce() {
        // super используется для вызова метода из суперкласса
        super.introduce();
        System.out.println("Мне " + this.age + " лет (Child)");
    }

    public void greet() {
        // this — вызов другого метода в том же классе
        this.introduce();

        // super — явный вызов метода родителя, даже если он переопределён
        super.greet();
    }

    // Метод, демонстрирующий разницу между this и super при обращении к полям
    public void showNames() {
        System.out.println("Имя из Child (через this): " + this.name);
        System.out.println("Имя из Parent (через super): " + super.name); // то же поле, но явное указание
        // В данном случае this.name и super.name — одно и то же, так как name унаследовано
    }
}

public class Practice1_ThisAndSuper {
    public static void main(String[] args) {
        Child child = new Child("Анна", 10);
        child.greet();
        System.out.println();
        child.showNames();
    }
}