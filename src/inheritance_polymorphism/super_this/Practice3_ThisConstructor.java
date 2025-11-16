package inheritance_polymorphism.super_this;

// Переписанный класс с использованием цепочки конструкторов через this()

class A3 {
    int a;
    int b;
    int c;
    int z;

    // Основной конструктор — устанавливает все поля
    public A3(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
        z = 1;
    }

    // Конструктор с двумя параметрами — делегирует основному
    public A3(int a, int b) {
        this(a, b, 0); // вызывает A(int, int, int)
    }

    // Конструктор с одним параметром — делегирует предыдущему
    public A3(int a) {
        this(a, 0); // вызывает A(int, int)
    }

    // Конструктор без параметров — делегирует предыдущему
    public A3() {
        this(0); // вызывает A(int)
    }
}

// Демонстрация работы
public class Practice3_ThisConstructor {
    public static void main(String[] args) {
        A3 obj1 = new A3();           // a=0, b=0, c=0, z=1
        A3 obj2 = new A3(5);          // a=5, b=0, c=0, z=1
        A3 obj3 = new A3(5, 10);      // a=5, b=10, c=0, z=1
        A3 obj4 = new A3(5, 10, 15);  // a=5, b=10, c=15, z=1

        System.out.println("obj4: a=" + obj4.a + ", b=" + obj4.b + ", c=" + obj4.c + ", z=" + obj4.z);
    }
}