public class NumMatrix {

    /*
    304. Range Sum Query 2D - Immutable
    Given a 2D matrix, handle multiple queries of the following type:

    Calculate the sum of the elements of matrix inside the rectangle defined by its upper left corner
    (row1, col1) and lower right corner (row2, col2).

    Implement the NumMatrix class:
    NumMatrix(int[][] matrix) Initializes the object with the integer matrix matrix.
    int sumRegion(int row1, int col1, int row2, int col2) Returns the sum of the elements of matrix inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).
    You must design an algorithm where sumRegion works on O(1) time complexity.


    Example 1:
    Input
    ["NumMatrix", "sumRegion", "sumRegion", "sumRegion"]
    [[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]], [2, 1, 4, 3], [1, 1, 2, 2], [1, 2, 2, 4]]
    Output
    [null, 8, 11, 12]

    Explanation
    NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
    numMatrix.sumRegion(2, 1, 4, 3); // return 8 (i.e sum of the red rectangle)
    numMatrix.sumRegion(1, 1, 2, 2); // return 11 (i.e sum of the green rectangle)
    numMatrix.sumRegion(1, 2, 2, 4); // return 12 (i.e sum of the blue rectangle)

    Constraints:
    m == matrix.length
    n == matrix[i].length
    1 <= m, n <= 200
    -10^4 <= matrix[i][j] <= 10^4
    0 <= row1 <= row2 < m
    0 <= col1 <= col2 < n
    At most 10^4 calls will be made to sumRegion.
     */

    private int[][] prefixSum;

    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        // Initialize the prefix sum matrix with zeros
        prefixSum = new int[m + 1][n + 1];

        // Calculate the prefix sum matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // Sum of elements from (0, 0) to (i-1, j-1)
                prefixSum[i][j] = matrix[i - 1][j - 1] +
                        prefixSum[i - 1][j] +
                        prefixSum[i][j - 1] -
                        prefixSum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Use the prefix sum matrix to calculate the sum for the specified rectangle
        return prefixSum[row2 + 1][col2 + 1] -
                prefixSum[row1][col2 + 1] -
                prefixSum[row2 + 1][col1] +
                prefixSum[row1][col1];
    }

    public static void main(String[] args) {
        // Example usage
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // Output: 8
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // Output: 11
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // Output: 12
    }
}
