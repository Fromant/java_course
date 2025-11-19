package interfaces.interfaces;

// Интерфейс без модификатора доступа имеет область видимости "package-private"
// Такой интерфейс доступен только классам в том же пакете

interface PrivInterface {
    void doSomething();
}

// Пример реализации в том же пакете — разрешено
class Implementor implements PrivInterface {
    @Override
    public void doSomething() {
        System.out.println("Реализация package-private интерфейса");
    }
}

// Из другого пакета было бы нельзя (см. ../other_package)

public class Practice1_PackagePrivateInterface {
    public static void main(String[] args) {
        PrivInterface obj = new Implementor();
        obj.doSomething();
    }
}
