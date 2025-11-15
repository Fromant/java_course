package classes_methods.methods;

// Суперкласс
class Animal {
    public void makeSound() {
        System.out.println("Животное издаёт звук");
    }
}

// Подкласс 1
class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Гав-гав!");
    }
}

// Подкласс 2
class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Мяу!");
    }
}

public class OverridingExample {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Animal dog = new Dog();   // полиморфизм: ссылка типа Animal, объект Dog
        Animal cat = new Cat();

        animal1.makeSound(); // "Животное издаёт звук"
        dog.makeSound();     // "Гав-гав!" — переопределённый метод
        cat.makeSound();     // "Мяу!" — переопределённый метод
    }
}
