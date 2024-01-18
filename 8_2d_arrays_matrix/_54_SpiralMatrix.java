import java.util.ArrayList;
import java.util.List;

public class _54_SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        testSpiralOrder(matrix1);

        int[][] matrix2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        testSpiralOrder(matrix2);

        int[][] matrix3 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        testSpiralOrder(matrix3);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        // Verifica se a matriz é nula ou vazia
        if (matrix == null || matrix.length == 0) return new ArrayList<>();

        // Lista para armazenar os elementos percorridos em ordem espiral
        List<Integer> resultado = new ArrayList<>();

        // Inicialização de variáveis para marcar as extremidades da matriz
        int inicioLinha = 0;
        int fimLinha = matrix.length - 1;

        int inicioColuna = 0;
        int fimColuna = matrix[0].length - 1;

        // Loop para percorrer a matriz em espiral
        while (inicioLinha <= fimLinha && inicioColuna <= fimColuna) {

            // Percorre da esquerda para a direita na linha superior (Travessia para a Direita)
            for (int i = inicioColuna; i <= fimColuna; i++) {
                resultado.add(matrix[inicioLinha][i]);
            }
            inicioLinha++;

            // Percorre de cima para baixo na coluna à direita (Travessia para Baixo)
            for (int i = inicioLinha; i <= fimLinha; i++) {
                resultado.add(matrix[i][fimColuna]);
            }
            fimColuna--;

            // Percorre da direita para a esquerda na linha inferior, se houver mais linhas (Travessia para a Esquerda)
            if (inicioLinha <= fimLinha) {
                for (int i = fimColuna; i >= inicioColuna; i--) {
                    resultado.add(matrix[fimLinha][i]);
                }
            }
            fimLinha--;

            // Percorre de baixo para cima na coluna à esquerda, se houver mais colunas (Travessia para Cima)
            if (inicioColuna <= fimColuna) {
                for (int i = fimLinha; i >= inicioLinha; i--) {
                    resultado.add(matrix[i][inicioColuna]);
                }
            }
            inicioColuna++;
        }

        // Retorna a lista resultante contendo os elementos da matriz percorridos em ordem espiral
        return resultado;
    }

    public static void testSpiralOrder(int[][] matrix) {
        System.out.println("\nInput: \n" + printMatrix(matrix));

        long startTime = System.nanoTime();
        List<Integer> result = spiralOrder(matrix);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.printf("Runtime: %d ns\n", (endTime - startTime));
        System.out.printf("Runtime: %.6f ms\n\n", (endTime - startTime) / 1_000_000.00);
    }


    private static String printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int[] ints : matrix) {
            sb.append("[");
            for (int j = 0; j < ints.length; j++) {
                sb.append(ints[j]);
                if (j != ints.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]\n");
        }
        return sb.toString();
    }


}
