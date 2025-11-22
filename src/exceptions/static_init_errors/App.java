package exceptions.static_init_errors;

public class App {
    // Статическое final-поле должно быть инициализировано при загрузке класса
    final static int START_COUNTER;

    // Статический инициализирующий блок выполняется при загрузке класса
    static {
        // Попытка преобразовать строку "Y-" в целое число
        // Integer.parseInt("Y-") выбрасывает NumberFormatException,
        // потому что "Y-" - не корректное представление целого числа
        START_COUNTER = Integer.parseInt("Y-");
    }

    public static void main(String[] args) {
        // Этот код НИКОГДА не выполнится,
        // потому что ошибка возникает ДО запуска main - на этапе инициализации класса
        System.out.println("Hello");
    }
}

/*
Что произойдёт при запуске:

1. JVM начинает загружать класс App.
2. Выполняется статический блок инициализации.
3. В нём вызывается Integer.parseInt("Y-") → выбрасывается исключение
   java.lang.NumberFormatException.
4. Поскольку исключение не перехватывается, инициализация класса завершается неудачно.
5. JVM прерывает запуск программы и выводит стек-трейс ошибки.

Вывод в консоль:
Exception in thread "main" java.lang.ExceptionInInitializerError
Caused by: java.lang.NumberFormatException: For input string: "Y-"
    at java.lang.NumberFormatException.forInputString(...)
    at java.lang.Integer.parseInt(...)
    at java.lang.Integer.parseInt(...)
    at App.<clinit>(App.java:...)

Сообщение "Hello" напечатано НЕ БУДЕТ.
*/