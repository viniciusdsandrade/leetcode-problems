public class _59_spiral_matrix_II {

    public static void main(String[] args) {
        for (int i = 10; i < 11; i++) {
            testGenerateMatrix(i);
        }
    }

    public static void testGenerateMatrix(int n) {
        System.out.println("\nInput: " + n);

        long startTime = System.nanoTime();
        int[][] result = generateMatrix(n);
        long endTime = System.nanoTime();

        System.out.println("Output: ");
        printMatrix(result);
        System.out.println("Execution time: " + (endTime - startTime) + "ns");
        System.out.printf("Execution time: %.4fms\n", (endTime - startTime) / 1000000.0);
    }

    public static void printMatrix(int[][] matrix) {
        int maxLength = String.valueOf(matrix.length * matrix.length).length();
        String formatString = "%" + maxLength + "d ";

        for (int[] row : matrix) {
            for (int num : row) {
                System.out.printf(formatString, num);
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (num <= n * n) {
            for (int i = left; i <= right; i++)
                matrix[top][i] = num++;

            top++;

            for (int i = top; i <= bottom; i++)
                matrix[i][right] = num++;

            right--;

            for (int i = right; i >= left; i--)
                matrix[bottom][i] = num++;

            bottom--;

            for (int i = bottom; i >= top; i--)
                matrix[i][left] = num++;

            left++;
        }

        return matrix;
    }
}
