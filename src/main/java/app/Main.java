package app;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Integer[] arr;
        arr = new Random().ints(9, 1,100)
                .boxed()
                .toArray(Integer[]::new);

        System.out.println("Unsorted array: " + Arrays.toString(arr));

        ArrayUtils.mergeSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array: " + Arrays.toString(arr));

//
        int targetRandom = new Random().nextInt(100);
        int index = ArrayUtils.binarySearch(arr, targetRandom);

        if (index != -1) {
            System.out.println("Element " + targetRandom + " found at index " + index);
        } else {
            System.out.println("Element " + targetRandom + " not found");
        }
    }
}
