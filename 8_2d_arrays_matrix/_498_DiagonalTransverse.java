import java.util.Arrays;

public class _498_DiagonalTransverse {
    /*
    498. Diagonal Traverse
    Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.

    Example 1:
    Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [1,2,4,7,5,3,6,8,9]

    Example 2:
    Input: mat = [[1,2],[3,4]]
    Output: [1,2,3,4]
 
    Constraints:
    m == mat.length
    n == mat[i].length
    1 <= m, n <= 10^4
    1 <= m * n <= 10^4
    -10^5 <= mat[i][j] <= 10^5
     */

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        testFindDiagonalOrder(matrix1);

        int[][] matrix2 = {
                {1, 2},
                {3, 4}
        };
        testFindDiagonalOrder(matrix2);

        int[][] matrix3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        testFindDiagonalOrder(matrix3);

        int[][] matrix4 = {
                {1, 0},
                {3, 4},
                {5, 6}
        };
        testFindDiagonalOrder(matrix4);

        int[][] matrix5 = {
                {1, 1, 1},
                {0, 1, 2}
        };
        testFindDiagonalOrder(matrix5);

        int[][] matrix7 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };
        testFindDiagonalOrder(matrix7);

        int[][] matrix8 = {
                {1, 0},
                {3, 4},
                {5, 6}
        };
        testFindDiagonalOrder(matrix8);
    }

    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) return new int[0];
        if (mat.length == 1) return mat[0];

        int linhas = mat.length;
        int colunas = mat[0].length;

        //O número de diagonais é igual ao número de linhas + o número de colunas
        int[] transversais = new int[linhas * colunas];
        int index = 0;

        // Percorre as transversais
        // O número de transversais é igual ao número de linhas + o número de colunas - 1
        for (int i = 0; i < linhas + colunas - 1; i++) {
            if (i % 2 == 0) {
                // Descendente (para baixo à direita)
                for (int row = Math.min(i, linhas - 1); row >= 0 && i - row < colunas; row--) {
                    transversais[index++] = mat[row][i - row];
                }
            } else {
                // Ascendente (para cima à esquerda)
                for (int col = Math.min(i, colunas - 1); col >= 0 && i - col < linhas; col--) {
                    transversais[index++] = mat[i - col][col];
                }
            }
        }
        return transversais;
    }

    public static void testFindDiagonalOrder(int[][] mat) {
        System.out.println("\nInput:");
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));

        long start = System.nanoTime();
        int[] answer = findDiagonalOrder(mat);
        long end = System.nanoTime();

        System.out.println("\nOutput:");
        System.out.println(Arrays.toString(answer));
        System.out.println("Runtime: " + (end - start) + " ns\n");
        System.out.println("Runtime: " + (end - start) / 1e6 + " ms");
    }
}