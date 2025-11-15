package classes_methods.generic_classes;

import java.util.ArrayList;
import java.util.List;

// Базовые классы для демонстрации
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
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }
}

public class Practice2_ExtendsSuper {

    // Метод с <? extends Animal> — можно читать из списка,
    // но нельзя добавлять (кроме null), потому что точный тип неизвестен.
    public static void processAnimalsReadOnly(List<? extends Animal> animals) {
        // Чтение — безопасно
        for (Animal a : animals) {
            a.makeSound();
        }

        // Запись — запрещена (кроме null)
//         animals.add(new Dog()); // ОШИБКА КОМПИЛЯЦИИ
        animals.add(null); // единственное допустимое исключение
    }

    // Метод с <? super Dog> — можно добавлять объекты типа Dog (и его подклассов),
    // но при чтении получаем только Object.
    public static void addDogs(List<? super Dog> list) {
        list.add(new Dog());
        list.add(new Dog());

        // Чтение даёт Object, не Dog
        Object obj = list.get(0);
        // Dog d = list.get(0); // ОШИБКА: компилятор не гарантирует тип Dog

        System.out.println("Добавлено 2 собаки. Первый элемент: " + obj);
    }

    public static void main(String[] args) {
        // Пример 1: <? extends Animal>
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());

        // Передаём списки с подтипами Animal — разрешено благодаря <? extends Animal>
        processAnimalsReadOnly(dogs);
        processAnimalsReadOnly(cats);

        System.out.println();

        // Пример 2: <? super Dog>
        List<Animal> animals = new ArrayList<>();     // Animal - супертип Dog
        List<Object> objects = new ArrayList<>();      // Object - супертип Dog

        addDogs(animals);  // OK: Animal - super Dog
        addDogs(objects);  // OK: Object - super Dog

        // Зачем это нужно?
        // - <? extends T> — "производит" значения (Producer) -> безопасное чтение.
        // - <? super T> — "потребляет" значения (Consumer) -> безопасная запись.
        // Это правило PECS: Producer Extends, Consumer Super.
    }
}