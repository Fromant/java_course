package inheritance_polymorphism.super_this;

// Демонстрация всех трёх способов использования super

class A1 {
    protected int a = 100;

    public A1() {
        System.out.println("Конструктор A() вызван");
    }

    public A1(int value) {
        this.a = value;
        System.out.println("Конструктор A(int) вызван, a = " + a);
    }

    public void method() {
        System.out.println("Метод method() из класса A, a = " + a);
    }
}

class B1 extends A1 {
    private int a = 200; // скрывает поле a из A

    // 1. super() — вызов конструктора суперкласса
    public B1() {
        super(50); // вызов A(int)
    }

    // 2. super.field — доступ к полю суперкласса
    // 3. super.method() — вызов метода суперкласса
    public void show() {
        System.out.println("Поле a в B: " + this.a);
        System.out.println("Поле a из A (через super.a): " + super.a);
        super.method(); // вызов метода из A
    }
}

public class Practice1_SuperUsage {
    public static void main(String[] args) {
        B1 obj = new B1();
        obj.show();
    }
}
