package classes_methods.generic_classes;

import java.util.ArrayList;
import java.util.List;

class Wrapper<T> {
    private T item;

    public Wrapper(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

public class Practice1_Instanceof {
    public static void main(String[] args) {
        Wrapper<String> stringWrapper = new Wrapper<>("Hello");
        Wrapper<Integer> intWrapper = new Wrapper<>(42);
        List<String> stringList = new ArrayList<>();
        stringList.add("Test");

        // 1. instanceof работает с "сырым" (raw) типом, а не с параметризованным
        // Компилятор разрешает проверку только на общий класс, без учёта T
        if (stringWrapper instanceof Wrapper) {
            System.out.println("stringWrapper — это экземпляр Wrapper (проверка без типа)");
        }

        // 2. Такая проверка ЗАПРЕЩЕНА и не скомпилируется:
        // if (stringWrapper instanceof Wrapper<String>) { } // ОШИБКА КОМПИЛЯЦИИ

        // 3. Для коллекций - то же самое:
        if (stringList instanceof ArrayList) {
            System.out.println("stringList — это ArrayList (без указания типа элементов)");
        }

        // 4. instanceof с интерфейсами тоже работает без параметров:
        if (stringList instanceof List) {
            System.out.println("stringList реализует List");
        }

        // 5. instanceof можно использовать для проверки типа хранимого значения:
        Wrapper<?> unknownWrapper = stringWrapper;
        Object item = unknownWrapper.getItem();
        if (item instanceof String) {
            System.out.println("Хранимое значение — строка: " + item);
        }

        // Вывод: из-за type erasure проверка параметризованного типа (например, Wrapper<String>)
        // невозможна во время выполнения. instanceof работает только с необобщённым типом.
    }
}