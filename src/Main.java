import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        { //practice 1
            //examples for all data types
            byte b1 = 123; //[-128, 127]
            short s1 = 1555; //[-32768, 32767]
            int i1 = 12487172; //[-2^31, 2^31-1]
            long i = 0xFFFFFFFFL; //[-2^63, 2^63-1]
        }

        {//practice 2
            //unicode print Роман
            System.out.println("\u0420\u043E\u043C\u0430\u043D");
        }

        {//practise 3
            int a = 1; //a=1
            {
                int b = 2;//a=1, b=2
            } //dealloc b
            int c = a + b; //err: cannot resolve symbol 'b'
            //Ответ: ошибка компиляции, т. к. переменной b нет на стеке и в scope
        }

        {//practice 4
            //Приведите пример использования перегруженного оператора + с объектами типа
            // String и переменными принадлежащим другим типам (объектам и базовым типам).
            String s = "123";
            String s1 = s + 1; //results in "1231" string
        }

        {//practice 5
            //Приведите примеры, когда арифметические операции выполняются с переменными различных типов. Объясните результат.
            float a = 2.0f + 1; //1 is converted to float 1.0f, result is 2.0+1.0=3.0
            float b = 2.0 + 1.0f; //err: cannot convert from double to float, because 2.0 is double, 1.0f converted to double, and the result is also double

            double c = 1 + 2.0f; //ok

            byte d1 = 2;
            short d2 = 3;
            int d = d1 + d2; //d1 is converted to short, d1+d2 is short, and then while assigning result is converted to int
        }

        {//practice 6
            //Приведите примеры сужающего преобразования типов.
            float b = (float) (2.0 + 1.0f); //double add result is converted to float and then assigned

            short c = 0x7FFF; //0x7FFF = 2047
            byte d = (byte) c; //0xFF = -1 (as 8bit signed int), highest 16 bits are cut
        }

        {//practice 7
            int a = 120; //120
            byte b = a + 10; //err: cant convert from int to byte.
            byte c = (byte) (a + 10); //overflow, 130>127 => c=-128+130-128 = -126
            System.out.println(c);
            byte d = a + 1; //err: cant convert from int to byte.
        }

        {//practice 8
            //Самостоятельно изучите, что означает type interface и приведите пример с использование var.

            //type interface? Я думаю вы имели в виду type inference - автоматический вывод типов

            var a = 2; //int
            var b = 2L; //long
            var c = 2.0; //double
            var d = 2.0f; //float

            var name = "Roman"; //String
            var flag = true; //bool
            var map = new HashMap<String, Integer>(); //HashMap<String, Integer>

            //Обобщая, компилятор вычисляет необходимый тип для локальной переменной
        }
    }
}
