package sorting;

import static sorting.BubbleSort.bubbleSort;
import static sorting.InsertionSort.insertionSort;

public class RuntimeTest {

    public static void main(String[] args) {
        int[] sizes = {5, 20, 100, 10000, 100000};

        for (int size : sizes) {
            int[] vet = gerarVetorAleatorio(size);

            // Teste com o bubbleSort
            long startBubbleSort = System.nanoTime();
            bubbleSort(vet.clone());
            long endBubbleSort = System.nanoTime();
            long diffBubbleSort = endBubbleSort - startBubbleSort;

            // Teste com o insertionSort
            long startInsertionSort = System.nanoTime();
            insertionSort(vet.clone());
            long endInsertionSort = System.nanoTime();
            long diffInsertionSort = endInsertionSort - startInsertionSort;
            double razaoBubbleInsertion = (double) diffBubbleSort / diffInsertionSort;

            System.out.println("Tempo de execução para vetor de tamanho " + size + ":");
            System.out.println("Bubble Sort:");
            System.out.println("  Nanosegundos: " + diffBubbleSort + " ns");
            System.out.println("  Milissegundos: " + (double) diffBubbleSort / 1_000_000.0 + " ms");
            System.out.println("Insertion Sort:");
            System.out.println("  Nanosegundos: " + diffInsertionSort + " ns");
            System.out.println("  Milissegundos: " + (double) diffInsertionSort / 1_000_000.0 + " ms");
            System.out.println("BubbleSort()/InsertionSort:()");
            System.out.println("  Razão: " + razaoBubbleInsertion);
            System.out.println();
        }
    }

    public static int[] gerarVetorAleatorio(int tamanho) {
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++)
            vetor[i] = (int) (Math.random() * 1000); // Números aleatórios de 0 a 99

        return vetor;
    }
}
