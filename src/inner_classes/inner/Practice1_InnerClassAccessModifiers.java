package inner_classes.inner;

// Демонстрация спецификаторов доступа для внутренних классов

public class Practice1_InnerClassAccessModifiers {

    // Внутренний класс с public доступом — виден из любого другого класса
    public class PublicInner {
        public void info() {
            System.out.println("PublicInner");
        }
    }

    // Внутренний класс с protected доступом — виден в том же пакете и в подклассах
    protected class ProtectedInner {
        public void info() {
            System.out.println("ProtectedInner");
        }
    }

    // Внутренний класс с package-private доступом (по умолчанию)
    // — виден только в том же пакете
    class PackagePrivateInner {
        public void info() {
            System.out.println("PackagePrivateInner");
        }
    }

    // Внутренний класс с private доступом — виден ТОЛЬКО внутри внешнего класса
    private class PrivateInner {
        public void info() {
            System.out.println("PrivateInner");
        }
    }

    // Метод во внешнем классе для демонстрации доступа ко всем внутренним классам
    public void createAll() {
        PublicInner p = new PublicInner();
        ProtectedInner pr = new ProtectedInner();
        PackagePrivateInner pp = new PackagePrivateInner();
        PrivateInner prvt = new PrivateInner();

        p.info();
        pr.info();
        pp.info();
        prvt.info();
    }

    // Вложенный (статический) класс для сравнения — не хранит ссылку на внешний объект
    public static class StaticNested {
        public void info() {
            System.out.println("StaticNested — не внутренний, а вложенный");
        }
    }

    public static void main(String[] args) {
        Practice1_InnerClassAccessModifiers outer = new Practice1_InnerClassAccessModifiers();

        // Пример создания извне (в том же классе, но из main)
        PublicInner pub = outer.new PublicInner(); // OK
        pub.info();

        PrivateInner prv = outer.new PrivateInner(); // тут доступно, было бы недоступно если бы main был в другом классе

        // Статический вложенный класс создаётся без экземпляра внешнего класса
        StaticNested nested = new StaticNested();
        nested.info();
    }
}
