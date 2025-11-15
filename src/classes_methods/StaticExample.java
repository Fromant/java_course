package classes_methods;

//класс из ТЗ
class staticClass {
    public static int a = 1;
    public static int b;

    public static void printVars() {
        System.out.println(a);
        System.out.println(b);
    }
}

public class StaticExample {
    public static void main(String[] args) {
        staticClass.printVars(); // Вызов через имя класса

        staticClass obj = new staticClass();
        obj.printVars(); // Вызов через ссылку на экземпляр класса (не рекомендуется)
    }
}
