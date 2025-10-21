package arrays;

import java.util.Arrays;

public class practice2 {
    public static void main(String[] args) {
        // 1. Arrays.toString(...) — преобразует массив в строку для удобного вывода
        int[] arr1 = {3, 1, 4, 1, 5};
        System.out.println("toString: " + Arrays.toString(arr1));
        // Вывод: [3, 1, 4, 1, 5]

        // 2. Arrays.binarySearch(...) — ищет элемент в отсортированном массиве
        int[] sortedArr = {1, 3, 5, 7, 9};
        int index = Arrays.binarySearch(sortedArr, 5);
        System.out.println("binarySearch (5): " + index); // Вывод: 2

        // Если элемент не найден, возвращается отрицательное число
        int notFound = Arrays.binarySearch(sortedArr, 6);
        System.out.println("binarySearch (6): " + notFound); // Вывод: -4 (вставка на позицию 3)

        // 3. Arrays.equals(...) — сравнивает два массива поэлементно
        int[] arr2 = {1, 2, 3};
        int[] arr3 = {1, 2, 3};
        int[] arr4 = {1, 2, 4};
        System.out.println("equals(arr2, arr3): " + Arrays.equals(arr2, arr3)); // true
        System.out.println("equals(arr2, arr4): " + Arrays.equals(arr2, arr4)); // false

        // 4. Arrays.compare(...) — сравнивает два массива лексикографически (начиная с Java 9)
        // Возвращает:
        //   < 0, если arr2 < arr4
        //   = 0, если равны
        //   > 0, если arr2 > arr4
        int cmp1 = Arrays.compare(arr2, arr3);
        int cmp2 = Arrays.compare(arr2, arr4);
        System.out.println("compare(arr2, arr3): " + cmp1); // 0
        System.out.println("compare(arr2, arr4): " + cmp2); // -1

        // 5. Arrays.sort(...) — сортирует массив по возрастанию
        int[] unsorted = {5, 2, 8, 1, 9};
        System.out.println("До сортировки: " + Arrays.toString(unsorted));
        Arrays.sort(unsorted);
        System.out.println("После сортировки: " + Arrays.toString(unsorted));
        // Вывод: [1, 2, 5, 8, 9]
    }
}
