package interfaces.interfaces;

// Попытка объявить интерфейс с модификатором protected вызывает ОШИБКУ КОМПИЛЯЦИИ
// Интерфейсы на верхнем уровне (top-level) не могут быть protected

/*
protected interface Interface {  // ОШИБКА: Illegal modifier for the interface;
                                 // only public & abstract are permitted
    void doSomething();
}
*/

// protected допустим ТОЛЬКО для вложенных интерфейсов (внутри класса или другого интерфейса),
// но не для интерфейсов верхнего уровня.

public class Practice3_ProtectedInterface {
    // Этот файл демонстрирует, что top-level интерфейс не может быть protected.
    // Компилятор выдаст ошибку, если раскомментировать объявление выше.
    public static void main(String[] args) {
        System.out.println("Интерфейс верхнего уровня не может быть protected.");
    }
}
