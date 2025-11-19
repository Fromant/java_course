package interfaces.interfaces;

// Попытка объявить интерфейс с модификатором private вызывает ОШИБКУ КОМПИЛЯЦИИ
// Интерфейсы верхнего уровня не могут быть private

/*
private interface Interface {  // ОШИБКА: Illegal modifier for the interface;
                               // only public & abstract are permitted
    void doSomething();
}
*/

// private допустим ТОЛЬКО для вложенных интерфейсов (внутри класса),
// но не для интерфейсов верхнего уровня.

public class Practice4_PrivateInterface {
    // Этот файл показывает, что top-level интерфейс не может быть private.
    // Компилятор не разрешит такое объявление.
    public static void main(String[] args) {
        System.out.println("Интерфейс верхнего уровня не может быть private.");
    }
}
