package arrays;

public class practice1 {
    public static void main(String[] args) {
        int a1[] = {1,2,3,4,5};
        int a2[] = {6,7,8,9,10};
        a1 = a2; // reference to a2 is now stored in a1
        // a1 → [6, 7, 8, 9, 10]
        // a2 → [6, 7, 8, 9, 10] <- Same address

        System.out.println(a1==a2); //true, due to address'es equality
    }
}
