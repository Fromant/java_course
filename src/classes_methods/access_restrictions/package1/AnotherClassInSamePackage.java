package classes_methods.access_restrictions.package1;

public class AnotherClassInSamePackage {
    public void tryAccess() {
        AccessDemo demo = new AccessDemo();

        System.out.println("\nИз AnotherClassInSamePackage (тот же пакет):");
        System.out.println("publicField: " + demo.publicField);          // OK
        System.out.println("packagePrivateField: " + demo.packagePrivateField); // OK
        System.out.println("protectedField: " + demo.protectedField);   // OK
        // System.out.println(demo.privateField);                      // Ошибка компиляции

        demo.publicMethod();         // OK
        demo.packagePrivateMethod(); // OK
        demo.protectedMethod();      // OK
        // demo.privateMethod();     // Ошибка компиляции
    }
}