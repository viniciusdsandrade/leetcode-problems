public class _73_SetMatrizZeroes {
    /*
    73. Set Matrix Zeroes
    
    Given an m x n integer matrix matrix, if an element is 0, 
    set its entire row and column to 0's.

    You must do it in place.

    Example 1:
    Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
    Output: [[1,0,1],[0,0,0],[1,0,1]]

    Example 2:
    Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
    Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 
    Constraints:
    m == matrix.length
    n == matrix[0].length
    1 <= m, n <= 200
    -231 <= matrix[i][j] <= 231 - 1
 
    Follow up:
    A straightforward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?
     */
    public static void main(String[] args) {
        // Test Case 1
        int[][] matrix1 = {
                {0, 1, 2, 0},
                {3, 4, 5, 1},
                {1, 3, 1, 5}
        };

        // Test Case 2
        int[][] matrix2 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        // Test Case 3
        int[][] matrix3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}
        };

        // Test Case 4
        int[][] matrix4 = {
                {1, 0},
                {3, 4},
                {5, 6}
        };

        // Test Case 5
        int[][] matrix5 = {
                {1, 1, 1},
                {0, 1, 2}
        };

        System.out.println("Test Case 1\nInput:");
        printMatrix(matrix1);
        setZeroes(matrix1);
        System.out.println("Result:");
        printMatrix(matrix1);

        System.out.println("Test Case 2\nInput:");
        printMatrix(matrix2);
        setZeroes(matrix2);
        System.out.println("Result:");
        printMatrix(matrix2);

        System.out.println("Test Case 3\nInput:");
        printMatrix(matrix3);
        setZeroes(matrix3);
        System.out.println("Result:");
        printMatrix(matrix3);

        System.out.println("Test Case 4\nInput:");
        printMatrix(matrix4);
        setZeroes(matrix4);
        System.out.println("Result:");
        printMatrix(matrix4);

        System.out.println("Test Case 5\nInput:");
        printMatrix(matrix5);
        setZeroes(matrix5);
        System.out.println("Result:");
        printMatrix(matrix5);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void setZeroes(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];
        
        // check which row and col has 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        
        // set row 0
        for (int i = 0; i < m; i++) {
            if (row[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }                
            }
        }
        
        // set col 0
        for (int j = 0; j < n; j++) {
            if (col[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }                
            }
        }
    }
}