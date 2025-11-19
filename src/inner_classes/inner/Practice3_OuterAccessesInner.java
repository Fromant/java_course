package inner_classes.inner;

// Демонстрация: внешний класс имеет доступ к полям и методам внутреннего класса
// в соответствии с их спецификаторами доступа
public class Practice3_OuterAccessesInner {

    public class Inner {
        private int privateInnerField = 10;
        int packageInnerField = 20;       // package-private
        protected int protectedInnerField = 30;
        public int publicInnerField = 40;

        private void privateInnerMethod() {
            System.out.println("privateInnerMethod() вызван");
        }

        public void publicInnerMethod() {
            System.out.println("publicInnerMethod() вызван");
        }
    }

    public void accessInnerFields() {
        Inner inner = new Inner();

        // Доступ к private полю внутреннего класса — разрешён
        System.out.println("privateInnerField = " + inner.privateInnerField);

        // Доступ к package-private полю
        System.out.println("packageInnerField = " + inner.packageInnerField);

        // Доступ к protected полю
        System.out.println("protectedInnerField = " + inner.protectedInnerField);

        // Доступ к public полю
        System.out.println("publicInnerField = " + inner.publicInnerField);

        // Вызов private метода внутреннего класса — разрешён
        inner.privateInnerMethod();

        // Вызов public метода
        inner.publicInnerMethod();
    }

    public static void main(String[] args) {
        Practice3_OuterAccessesInner outer = new Practice3_OuterAccessesInner();
        outer.accessInnerFields();
    }
}
