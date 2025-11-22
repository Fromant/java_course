package introduction;

// Принцип подстановки Лисков (LSP):
// "Объекты в программе могут быть заменены их подтипами без изменения правильности программы."

// Правильный пример: подклассы ведут себя так же, как и суперкласс

// Суперкласс
class Rectangle {
    protected double width;
    protected double height;

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}

// Подкласс, который соблюдает поведение суперкласса
class Square extends Rectangle {
    // Важно: при изменении ширины или высоты — обе стороны меняются одинаково,
    // но это НЕ нарушает контракт getArea(), если клиент ожидает прямоугольник.
    // Однако на практике Square как подкласс Rectangle часто нарушает LSP.
    // Поэтому ниже приведён АЛЬТЕРНАТИВНЫЙ, корректный подход.

    // Вместо этого создадим отдельную иерархию, чтобы избежать нарушения LSP

    // Но для демонстрации правильного LSP используем другой пример:
}

// Корректная иерархия, соблюдающая LSP
abstract class Bird {
    public abstract void fly();
}

class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Воробей летает");
    }
}

class Penguin extends Bird {
    @Override
    public void fly() {
        // Пингвин — птица, но не летает.
        // Если мы заставим его выбрасывать исключение в fly(),
        // это НАРУШИТ LSP: клиентский код, ожидающий fly(), сломается.

        // Правильное решение: пересмотреть иерархию
    }
}

// Лучший подход: выделить интерфейсы по поведению
interface Flyable {
    void fly();
}

class Sparrow2 implements Flyable {
    @Override
    public void fly() {
        System.out.println("Воробей летает");
    }
}

class Penguin2 {
    // Пингвин не реализует Flyable — нет метода fly()
    public void swim() {
        System.out.println("Пингвин плавает");
    }
}

// Клиентский код, который работает только с летающими птицами
class BirdHandler {
    public void letBirdFly(Flyable bird) {
        bird.fly(); // безопасно: любой Flyable может летать
    }
}

// Демонстрация соблюдения LSP
public class Practice1_LiskovSubstitution {
    public static void main(String[] args) {
        BirdHandler handler = new BirdHandler();

        // Можно передать любого, кто реализует Flyable
        handler.letBirdFly(new Sparrow2()); // работает корректно

        // Penguin2 нельзя передать сюда — компилятор не разрешит.
        // Это и есть соблюдение LSP: поведение подтипов предсказуемо.

        // Вывод: подкласс должен быть взаимозаменяем со своим суперклассом
        // без изменения логики программы. Если подкласс нарушает контракт
        // (например, выбрасывает исключение или игнорирует метод),
        // то это нарушение принципа подстановки Лисков.
    }
}
