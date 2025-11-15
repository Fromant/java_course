package classes_methods.access_restrictions.another_package;

import classes_methods.access_restrictions.package1.AccessDemo;

public class SubclassInAnotherPackage extends AccessDemo {
    public void tryAccess() {
        System.out.println("\nИз SubclassInAnotherPackage (другой пакет, наследник):");
        System.out.println("publicField: " + publicField);        // OK (наследуется)
        // System.out.println(packagePrivateField);               // Недоступно
        System.out.println("protectedField: " + protectedField);  // OK (наследуется)
        // System.out.println(privateField);                      // Недоступно

        publicMethod();      // ОK
        // packagePrivateMethod(); // Недоступно
        protectedMethod();   // OK
        // privateMethod();        // Недоступно
    }
}
