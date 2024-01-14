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

        if (matrix == null || matrix.length == 0) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        int rowStart = 0;
        int rowEnd = matrix.length - 1;

        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {

            // Traverse Right
            for (int i = colStart; i <= colEnd; i++) {
                result.add(matrix[rowStart][i]);
            }
            rowStart++;

            // Traverse Down
            for (int i = rowStart; i <= rowEnd; i++) {
                result.add(matrix[i][colEnd]);
            }
            colEnd--;

            // Traverse Left
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= colStart; i--) {
                    result.add(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            // Traverse Up
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    result.add(matrix[i][colStart]);
                }
            }
            colStart++;
        }

        return result;
    }

    public static void testSpiralOrder(int[][] matrix) {
        System.out.println("Input: \n" + printMatrix(matrix));

        long startTime = System.nanoTime();
        List<Integer> result = spiralOrder(matrix);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.printf("Runtime: %.3f ns\n\n", (endTime - startTime) / 1_000_000.00);
        System.out.printf("Runtime: %.3f ms\n\n", (endTime - startTime) / 1_000_000.00);
    }


    private static String printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append("[");
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
                if (j != matrix[i].length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]\n");
        }
        return sb.toString();
    }


}
