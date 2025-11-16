package inheritance_polymorphism.final_classes;

// Суперкласс с final-методом
class Parent {
    // Метод объявлен как final — его нельзя переопределять в подклассах
    public final void display() {
        System.out.println("Это final-метод из класса Parent");
    }
}

// Подкласс, пытающийся переопределить final-метод
class Child extends Parent {
    // Следующий метод вызовет ОШИБКУ КОМПИЛЯЦИИ:
    // "Cannot override the final method from Parent"
    /*
    @Override
    public void display() {
        System.out.println("Попытка переопределить final-метод");
    }
    */
}

public class Practice1_FinalMethod {
    public static void main(String[] args) {
        Child child = new Child();
        child.display(); // Вызывается final-метод из Parent
    }
}