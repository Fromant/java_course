package inheritance_polymorphism.super_this;

// Ответ на вопрос: что произойдёт при вызове method() объекта класса C?

class A2 {
    int a = 42;

    void method() {
        System.out.println("method() из класса A");
    }
}

class B2 extends A2 {
    // Класс B НЕ переопределяет a и method()
    // Он наследует их от A автоматически
}

class C2 extends B2 {
    void method() {
        // super.a и super.method() обращаются к ближайшему унаследованному члену
        // Поскольку B не определяет свои a и method(), они берутся из A
        int a = super.a;         // получит 42 из A
        super.method();          // вызовет method() из A
        System.out.println("Значение a из суперкласса: " + a);
    }
}

public class Practice2_SuperInheritanceChain {
    public static void main(String[] args) {
        C2 obj = new C2();
        obj.method(); // Выведет: method() из класса A, затем значение a = 42
    }
}
