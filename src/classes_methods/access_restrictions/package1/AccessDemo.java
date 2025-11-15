package classes_methods.access_restrictions.package1;

public class AccessDemo {
    // public — доступен везде
    public int publicField = 1;

    // без спецификатора (package-private) — только в этом пакете
    int packagePrivateField = 2;

    // protected — в пакете + подклассы в других пакетах
    protected int protectedField = 3;

    // private — только внутри этого класса
    private int privateField = 4;

    // Публичный метод для доступа к private-полю
    public int getPrivateField() {
        return privateField;
    }

    // Пример метода с разными уровнями доступа
    public void publicMethod() {
        System.out.println("publicMethod вызван");
    }

    void packagePrivateMethod() {
        System.out.println("packagePrivateMethod вызван");
    }

    protected void protectedMethod() {
        System.out.println("protectedMethod вызван");
    }

    private void privateMethod() {
        System.out.println("privateMethod вызван");
    }

    // Метод для демонстрации доступа внутри класса
    public void testAccessInsideClass() {
        System.out.println("Внутри AccessDemo:");
        System.out.println("publicField: " + publicField);
        System.out.println("packagePrivateField: " + packagePrivateField);
        System.out.println("protectedField: " + protectedField);
        System.out.println("privateField: " + privateField);

        publicMethod();
        packagePrivateMethod();
        protectedMethod();
        privateMethod();
    }
}