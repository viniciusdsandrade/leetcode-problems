package sorting;

public class SelectionSort {
    public static void selectionSort(int[] array) {
        int n = array.length;
        int i, j, minIndex, temp;
        for (i = 0; i < n - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
}
