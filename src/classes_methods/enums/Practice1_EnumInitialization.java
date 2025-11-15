package classes_methods.enums;

// Пример перечисления с инициализацией каждого элемента через конструктор

public class Practice1_EnumInitialization {

    // Перечисление с конструктором, полем и инициализацией
    public enum Planet {
        // Каждая константа вызывает конструктор Planet(double radius)
        MERCURY(2439.7),
        VENUS(6051.8),
        EARTH(6371.0),
        MARS(3389.5);

        // Поле экземпляра (не static!)
        private final double radiusInKm;

        // Приватный конструктор — вызывается при инициализации констант
        Planet(double radius) {
            this.radiusInKm = radius;
        }

        // Геттер для доступа к значению
        public double getRadius() {
            return radiusInKm;
        }
    }

    public static void main(String[] args) {
        // Использование проинициализированного перечисления
        System.out.println("Радиус Земли: " + Planet.EARTH.getRadius() + " км");
        System.out.println("Радиус Марса: " + Planet.MARS.getRadius() + " км");
    }
}