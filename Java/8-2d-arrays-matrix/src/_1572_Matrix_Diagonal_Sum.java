import java.util.Arrays;

public class _1572_Matrix_Diagonal_Sum {

    /*
    1572. Matrix Diagonal Sum
    Given a square matrix mat, return the sum of the matrix diagonals.

    Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

    Example 1:
    Input: mat = [[1,2,3],
                  [4,5,6],
                  [7,8,9]]
    Output: 25
    Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
    Notice that element mat[1][1] = 5 is counted only once.

    Example 2:
    Input: mat = [[1,1,1,1],
                  [1,1,1,1],
                  [1,1,1,1],
                  [1,1,1,1]]
    Output: 8

    Example 3:
    Input: mat = [[5]]
    Output: 5

    Constraints:
    n == mat.length == mat[i].length
    1 <= n <= 100
    1 <= mat[i][j] <= 100
     */

    public static void main(String[] args) {
        int[][] mat1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        testDiagonalSum(mat1);

        int[][] mat2 = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        testDiagonalSum(mat2);

        int[][] mat3 = {{5}};
        testDiagonalSum(mat3);
    }

    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - i - 1];
        }

        if (n % 2 != 0) sum -= mat[n / 2][n / 2];

        return sum;
    }

    public static void testDiagonalSum(int[][] mat) {
        System.out.println("Input: mat = " + Arrays.deepToString(mat));

        long start = System.nanoTime();
        int output = diagonalSum(mat);
        long end = System.nanoTime();

        System.out.println("Output: " + output);
        System.out.println("Execution time : " + (end - start) + " ns");
    }
}
