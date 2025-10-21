public class Main {

    public static void main(String[] args) {
        int month = 1; //Номер месяца в году 1-январь, 2-февраль, и т.д.
        switch (month) {
            case 12:
            case 1:
            case 2:
                System.out.println("Winter"); // <- executed
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
        }

        // Отсутствие break вызывает fall-through
        // выполнение "проваливается" в следующие case.
        // Это может быть как ошибкой, так и осознанным приёмом.
    }
}
