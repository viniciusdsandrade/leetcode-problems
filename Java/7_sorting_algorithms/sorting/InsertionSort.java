package sorting;

import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] array = {6, 3, 4, 7, 1};

        long start;
        long end;
        int i, j;

        int repeticoes = 10;
        int ciclos = 1000;

        double[] averages = new double[ciclos]; // Array para armazenar as médias

        for (j = 0; j < ciclos; j++) { // Loop externo que executa 10 vezes
            long soma = 0; // Resetar a soma a cada ciclo externo
            for (i = 0; i < repeticoes; i++) { // Loop original
                start = System.nanoTime();
                insertionSort(array);
                end = System.nanoTime();
                soma += end - start;
            }
            averages[j] = (double) soma / repeticoes; // Armazena a média no array
            System.out.printf("Média %d: %.2f ns\n", j + 1, averages[j]);
        }

        double mediaTotal = Arrays.stream(averages).average().orElse(0);
        System.out.printf("Média total: %.6f ms\n", mediaTotal / 1_000_000);
        System.out.printf("Média total: %.3f ns\n", mediaTotal);
    }
}