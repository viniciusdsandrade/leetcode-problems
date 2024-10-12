public class _867_TransposeMatrix {
    
    /*
    867. Transpose Matrix
    
    Given a 2D integer array matrix, return the transpose of matrix.
    The transpose of a matrix is the matrix flipped over its main diagonal, 
    switching the matrix's row and column indices.

    Example 1:
    Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [[1,4,7],[2,5,8],[3,6,9]]

    Example 2:
    Input: matrix = [[1,2,3],[4,5,6]]
    Output: [[1,4],[2,5],[3,6]]

    Constraints:
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 10^3
    1 <= m * n <= 10^5
    -10^9 <= matrix[i][j] <= 10^9
     */

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6}
        };

        int[][] matrix3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };

        int[][] matrix4 = {
                {1, 0},
                {3, 4},
                {5, 6}
        };

        int[][] matrix5 = {
                {1, 1, 1},
                {0, 1, 2}
        };

        int[][] matrix7 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };

        int[][] matrix8 = {
                {1, 0},
                {3, 4},
                {5, 6}
        };

        int[][] matrix9 = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
        };

        testTranspose(matrix1);
        testTranspose(matrix2);
        testTranspose(matrix3);
        testTranspose(matrix4);
        testTranspose(matrix5);
        testTranspose(matrix7);
        testTranspose(matrix8);
        testTranspose(matrix9);
    }

    public static int[][] transpose(int[][] matrix) {
        int linhas = matrix.length;
        int colunas = matrix[0].length;

        // Matriz com linhas e colunas invertidas = Matriz Transposta
        int[][] matrizT = new int[colunas][linhas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                matrizT[j][i] = matrix[i][j];
            }
        }
        return matrizT;
    }

    public static void testTranspose(int[][] matrix) {

        System.out.println("\nInput:");
        printMatrix(matrix);
        long startTime = System.nanoTime();
        int[][] matrizT = transpose(matrix);
        long endTime = System.nanoTime();
        System.out.println("Transpose:");
        printMatrix(matrizT);

        System.out.println("Time: " + (endTime - startTime) + " ns");
        System.out.printf("Time: %.3f ms%n", (double) (endTime - startTime) / 1000000);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[");
            for (int num : row) {
                System.out.printf("%2d", num); // Ajuste o valor dentro do printf conforme necessário
            }
            System.out.println(" ]");
        }
    }
}