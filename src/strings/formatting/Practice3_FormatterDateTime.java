package strings.formatting;

import java.util.Calendar;
import java.util.Formatter;

public class Practice3_FormatterDateTime {
    public static void main(String[] args) {
        // Получаем текущую дату и время
        Calendar cal = Calendar.getInstance();

        Formatter fmt = new Formatter(System.out);

        // Использование пяти спецификаторов для даты и времени

        // %tY — год в 4-значном формате
        fmt.format("Год: %tY%n", cal);

        // %tm — месяц (1-12)
        fmt.format("Месяц: %tm%n", cal);

        // %tB - полное название месяца
        fmt.format("Месяц (название): %tB%n", cal);

        // %tA - полное название дня недели
        fmt.format("День недели: %tA%n", cal);

        // %tH:%tM:%tS - часы, минуты, секунды в 24-часовом формате
        fmt.format("Время: %tH:%tM:%tS%n", cal, cal, cal);

        fmt.close();
    }
}
