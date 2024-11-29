package app;

public class ArrayUtils {
    private ArrayUtils() {
    }

    public static <T extends Comparable<T>> void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static <T extends Comparable<T>> void merge(T[] array, int left, int mid, int right) {
        int sizeOfLeftSubArray = mid - left + 1;
        int sizeOfRightSubArray = right - mid;

        //Creating two temp arrays
        T[] leftArray = (T[]) new Comparable[sizeOfLeftSubArray];
        T[] rightArray = (T[]) new Comparable[sizeOfRightSubArray];

        //Copying data to the temp arrays
        int i = 0, j = 0; //starting indices
        for (i = 0; i < sizeOfLeftSubArray; i++) {
            leftArray[i] = array[left + i];
        }
        for (j = 0; j < sizeOfRightSubArray; j++) {
            rightArray[j] = array[mid + 1 + j];
        }

        //Re-setting starting indices of temp arrays
        i = 0;
        j = 0;
        int k = left; //starting index of merged sub-array

        while (i < sizeOfLeftSubArray && j < sizeOfRightSubArray) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //Copying remaining elements from left array
        for (; i < sizeOfLeftSubArray; i++) {
            array[k++] = leftArray[i];
        }

        //Copying remaining elements from right array
        for (; j < sizeOfRightSubArray; j++) {
            array[k++] = rightArray[j];
        }
    }

    public static <T extends Comparable<T>> int binarySearch(T[] array, T target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (array[mid].compareTo(target) == 0) {
                return mid;
            }

            if (array[mid].compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
