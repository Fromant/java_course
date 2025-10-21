public class Main {

    public static void main(String[] args) {

        int i = 0;

        int j = 0;

        for (; i < 10; i++) {
            if (i == 5) break;
            if (i < 3) continue; //skip increment
            j++; //j will only be incremented 3 times (i=0, 1, 2)
        }

        System.out.println(i); // i = 5
        System.out.println(j); // j = 2
    }
}
