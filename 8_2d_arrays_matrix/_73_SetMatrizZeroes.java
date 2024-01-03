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
        int[][] matrix1 = {
                {0, 1, 2, 0},
                {3, 4, 5, 1},
                {1, 3, 1, 5}
        };

        setZeroes(matrix1);

        System.out.println("Result: ");
        for (int[] row : matrix1) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
        
        int[][] matrix2 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        
        setZeroes(matrix2);
        
        System.out.println("Result: ");
        for (int[] row : matrix2) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
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
        
        // set row and col to 0
        for (int i = 0; i < m; i++) {
            if (row[i]) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }                
            }
        }
        
        for (int j = 0; j < n; j++) {
            if (col[j]) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }                
            }
        }
    }
}
