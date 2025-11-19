package inner_classes.inner;

// Демонстрация: внутренний класс имеет доступ ко ВСЕМ полям и методам внешнего класса,
// независимо от их спецификаторов доступа (включая private)
public class Practice2_InnerAccessesOuter {

    private int privateField = 1;
    int packageField = 2;          // package-private
    protected int protectedField = 3;
    public int publicField = 4;

    private void privateMethod() {
        System.out.println("privateMethod() вызван");
    }

    public class Inner {
        public void accessOuter() {
            // Доступ к private полю
            System.out.println("privateField = " + privateField);

            // Доступ к package-private полю
            System.out.println("packageField = " + packageField);

            // Доступ к protected полю
            System.out.println("protectedField = " + protectedField);

            // Доступ к public полю
            System.out.println("publicField = " + publicField);

            // Доступ к private методу
            privateMethod();
        }
    }

    public static void main(String[] args) {
        Practice2_InnerAccessesOuter outer = new Practice2_InnerAccessesOuter();
        Practice2_InnerAccessesOuter.Inner inner = outer.new Inner();
        inner.accessOuter();
    }
}
