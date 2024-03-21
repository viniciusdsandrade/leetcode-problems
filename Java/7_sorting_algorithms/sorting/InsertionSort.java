package sorting;

public class InsertionSort {
    public static void insertionSort(int[] array) {
        int i, j, key;
        for (i = 1; i < array.length; i++) {
            key = array[i];
            j = i - 1;

            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;

                //System.out.println("i: " + i + ", j: " + j + ", key: " + key + ", array: " + Arrays.toString(array));
            }

            array[j + 1] = key;
        }
    }
}