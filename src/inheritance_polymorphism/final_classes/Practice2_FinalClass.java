package inheritance_polymorphism.final_classes;

// Класс объявлен как final — от него нельзя наследоваться
final class FinalClass {
    public void sayHello() {
        System.out.println("Привет из final-класса!");
    }
}

// Попытка создать подкласс от final-класса вызовет ОШИБКУ КОМПИЛЯЦИИ:
// "The type ChildOfFinal cannot subclass the final class FinalClass"
/*
class ChildOfFinal extends FinalClass {
    // Этот код не скомпилируется
}
*/

public class Practice2_FinalClass {
    public static void main(String[] args) {
        FinalClass obj = new FinalClass();
        obj.sayHello();
    }
}