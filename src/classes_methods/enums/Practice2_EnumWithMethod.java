package classes_methods.enums;

// Пример перечисления с собственным методом и переопределением метода у отдельных констант

public class Practice2_EnumWithMethod {

    public enum Operation {
        ADD {
            @Override
            public double apply(double x, double y) {
                return x + y;
            }
        },
        SUBTRACT {
            @Override
            public double apply(double x, double y) {
                return x - y;
            }
        },
        MULTIPLY {
            @Override
            public double apply(double x, double y) {
                return x * y;
            }
        },
        DIVIDE {
            @Override
            public double apply(double x, double y) {
                if (y == 0) throw new ArithmeticException("Деление на ноль");
                return x / y;
            }
        };

        // Абстрактный метод, который должен быть реализован каждой константой
        public abstract double apply(double x, double y);
    }

    public static void main(String[] args) {
        double a = 10.0, b = 3.0;

        System.out.println("10 + 3 = " + Operation.ADD.apply(a, b));
        System.out.println("10 - 3 = " + Operation.SUBTRACT.apply(a, b));
        System.out.println("10 * 3 = " + Operation.MULTIPLY.apply(a, b));
        System.out.println("10 / 3 = " + Operation.DIVIDE.apply(a, b));

        // Пример использования в switch (опционально)
        Operation op = Operation.MULTIPLY;
        switch (op) {
            case ADD:
                System.out.println("Выбрано сложение");
                break;
            case MULTIPLY:
                System.out.println("Выбрано умножение");
                break;
            default:
                System.out.println("Другая операция");
        }
    }
}
