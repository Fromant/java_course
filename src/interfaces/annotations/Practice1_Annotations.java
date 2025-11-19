package interfaces.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// 1. @Override
// Указывает, что метод предназначен для переопределения метода из суперкласса.
// Помогает обнаружить ошибки (например, опечатки в имени метода) на этапе компиляции.

class Animal {
    public void makeSound() {
        System.out.println("Животное издаёт звук");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Гав!");
    }

    // Если раскомментировать следующий метод с опечаткой и @Override,
    // компилятор выдаст ошибку, потому что в Animal нет метода "makeSoud"
    /*
    @Override
    public void makeSoud() { // ОПЕЧАТКА
        System.out.println("Ошибка!");
    }
    */
}

// 2. @Deprecated
// Помечает элемент как устаревший. Компилятор выдаёт предупреждение при его использовании.
// Рекомендуется указывать причину и альтернативу через javadoc или параметр since.

class OldCalculator {
    @Deprecated(since = "1.2", forRemoval = true)
    public int add(int a, int b) {
        return a + b;
    }

    public int sum(int... numbers) {
        int total = 0;
        for (int n : numbers) total += n;
        return total;
    }
}

// 3. @SuppressWarnings
// Подавляет предупреждения компилятора. Указывается категория предупреждения в кавычках.

class WarningExample {
    @SuppressWarnings("unchecked")
    public void unsafeList() {
        // Этот код генерирует предупреждение: unchecked conversion
        java.util.List list = new java.util.ArrayList();
        list.add("Привет");
    }

    @SuppressWarnings("deprecation")
    public void useOldMethod() {
        OldCalculator calc = new OldCalculator();
        calc.add(2, 3); // без @SuppressWarnings — предупреждение об использовании @Deprecated
    }
}

// 4. Собственная аннотация

@Target(ElementType.TYPE) // Аннотация применима только к классам, интерфейсам и т.д.
public @interface BaseAction {
    int level(); // метод-член аннотации (обязательно должен быть задан при использовании)
}

@BaseAction(level = 2)
class Base {
    public void doAction() {
        Class<?> clazz = Base.class;
        // Получаем аннотацию во время выполнения через Reflection API
        BaseAction action = clazz.getAnnotation(BaseAction.class);
        if (action != null) {
            System.out.println("Уровень действия: " + action.level());
        }
    }
}

// Основной класс для демонстрации
public class Practice1_Annotations {
    public static void main(String[] args) {
        // @Override
        Dog dog = new Dog();
        dog.makeSound();

        // @Deprecated + @SuppressWarnings
        WarningExample example = new WarningExample();
        example.useOldMethod();

        // Собственная аннотация
        Base base = new Base();
        base.doAction();
    }
}
