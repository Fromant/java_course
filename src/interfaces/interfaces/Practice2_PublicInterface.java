package interfaces.interfaces;

// Интерфейс с модификатором public доступен из любого пакета
// Должен быть объявлен в файле с именем, совпадающим с именем интерфейса,
// но здесь размещён в одном файле для компактности демонстрации
public interface PubInterface {
    void doSomething();
}

// Реализация разрешена в любом классе, даже в другом пакете
class PublicInterfaceImplementor implements PubInterface {
    @Override
    public void doSomething() {
        System.out.println("Реализация public интерфейса");
    }
}

class Practice2_PublicInterface {
    public static void main(String[] args) {
        PubInterface obj = new PublicInterfaceImplementor();
        obj.doSomething();
    }
}
