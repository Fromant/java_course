public class Main {

    public static void main(String[] args) {

        // ====== Практика 1 ======

        // В switch могут быть:
        /*
        byte Целочисленный примитив
        short Целочисленный примитив
        int Целочисленный примитив
        char Символьный примитив
        Byte Обёртка над byte
        Short Обёртка над short
        Integer Обёртка над int
        Character Обёртка над char
        String Добавлено в Java 7
        enum Любой перечислимый тип (с Java 5)
        */

        {
            int value = 2;
            switch (value) {
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                default:
                    break;
            }
        }

        {
            Integer value = 2;
            switch (value) {
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                default:
                    break;
            }
        }

        {
            char ch = 'B';
            switch (ch) {
                case 'A':
                    System.out.println("Alpha");
                    break;
                case 'B':
                    System.out.println("Bravo");
                    break;
                default:
                    break;
            }
        }

        {
            Character ch = 'B';
            switch (ch) {
                case 'A':
                    System.out.println("Alpha");
                    break;
                case 'B':
                    System.out.println("Bravo");
                    break;
                default:
                    break;
            }
        }

        {
            byte b = 10;
            switch (b) {
                case 10:
                    System.out.println("Ten");
                    break;
                default:
                    break;
            }
        }

        {
            short s = 5;
            switch (s) {
                case 5:
                    System.out.println("Five");
                    break;
                default:
                    break;
            }
        }

        {
            String day = "MONDAY";
            switch (day) {
                case "MONDAY":
                    System.out.println("Start of week");
                    break;
                case "FRIDAY":
                    System.out.println("End of week");
                    break;
                default:
                    break;
            }
        }

        {
            enum Color {RED, GREEN, BLUE}

            Color c = Color.GREEN;
            switch (c) {
                case RED:
                    System.out.println("Red");
                    break;
                case GREEN:
                    System.out.println("Green");
                    break;
                default:
                    break;
            }
        }
    }
}
