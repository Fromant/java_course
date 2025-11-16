package inheritance_polymorphism.inheritance;

// Демонстрация видимости членов при наследовании

class inhA {
    int a1;              // package-private (видно в том же пакете)
    public int a2;       // public (видно везде)
    protected int a3;    // protected (видно в пакете + подклассах в других пакетах)
    private int a4;      // private (видно ТОЛЬКО в A)

    void method1() { }           // package-private
    public void method2() { }    // public
    protected void method3() { } // protected
    private void method4() { }   // private
}

class inhB extends inhA {
    void accessTestFromB() {
        // Доступные поля:
        System.out.println(a1);   // package-private: B в том же пакете — доступно
        System.out.println(a2);   // public — всегда доступно
        System.out.println(a3);   // protected — доступно в подклассе

        // System.out.println(a4); // ОШИБКА: private поле недоступно

        // Доступные методы:
        method1(); // package-private — доступен в том же пакете
        method2(); // public
        method3(); // protected

        // method4(); // ОШИБКА: private метод недоступен
    }
}

class inhC extends inhB {
    void accessTestFromC() {
        // В том же пакете, поэтому правила те же:
        System.out.println(a1); // package-private — доступно (тот же пакет)
        System.out.println(a2); // public
        System.out.println(a3); // protected — доступно как для подкласса

        // System.out.println(a4); // всё ещё недоступно

        method1(); // package-private — доступен в том же пакете
        method2(); // public
        method3(); // protected

        // method4(); // ОШИБКА: private метод недоступен
    }
}

// Дополнительный класс вне иерархии, но в том же пакете
class OtherClassInSamePackage {
    void test(inhA obj) {
        // В том же пакете, но не подкласс
        System.out.println(obj.a1); // package-private — доступно
        System.out.println(obj.a2); // public
        // System.out.println(obj.a3); // недоступно - protected — не подкласс и не внутри A
        // System.out.println(obj.a4); // недоступно - private

        obj.method1(); // OK
        obj.method2(); // OK
        // obj.method3(); // недоступно protected
        // obj.method4(); // недоступно private
    }
}

public class Practice2_AccessModifiersInheritance {
    public static void main(String[] args) {
        inhC c = new inhC();
        c.accessTestFromC();

        System.out.println("Доступ из C проверен.");
    }
}
