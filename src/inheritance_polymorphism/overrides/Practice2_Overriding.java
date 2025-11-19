package inheritance_polymorphism.overrides;

// Пример переопределения метода (overriding)

class Animal {
    // Метод в суперклассе
    public void speak() {
        System.out.println("Животное издаёт звук");
    }

    // Метод с возвращаемым типом
    public Number getAge() {
        return 5;
    }
}

class Dog extends Animal {
    // Корректное переопределение — сигнатура совпадает
    @Override
    public void speak() {
        System.out.println("Гав-гав!");
    }

    // Переопределение с совместимым возвращаемым типом (ковариантный возврат)
    @Override
    public Integer getAge() {
        return 3; // Integer — подкласс Number, разрешено
    }

    /*
    // Следующий метод вызовет ОШИБКУ КОМПИЛЯЦИИ:
    // "return type is incompatible with Animal.getNumber()"
    @Override
    public String getAge() {
        return "три";
    }
    */
}

public class Practice2_Overriding {
    public static void main(String[] args) {
        Animal myDog = new Dog(); // полиморфизм
        myDog.speak();            // вызов переопределённого метода — "Гав-гав!"
        System.out.println("Возраст: " + myDog.getAge()); // вызов Integer getAge()
    }
}
