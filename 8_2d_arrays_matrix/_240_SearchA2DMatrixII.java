public class _240_SearchA2DMatrixII {
    /*
    240. Search a 2D Matrix II
    Write an efficient algorithm that searches for a value target 
    in an m x n integer matrix matrix. 
    This matrix has the following properties:
    
    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

    Example 1:
    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
    Output: true
    
    Example 2:
    Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
    Output: false
     
    Constraints:
    m == matrix.length
    n == matrix[i].length
    1 <= n, m <= 300
    -109 <= matrix[i][j] <= 109
    All the integers in each row are sorted in ascending order.
    All the integers in each column are sorted in ascending order.
    -10^9 <= target <= 10^9
     */
    
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        testSearchMatrix(matrix1, 5);

        int[][] matrix2 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        testSearchMatrix(matrix2, 20);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == target) return true;
            }
        }
        return false;
    }

    public static void testSearchMatrix(int[][] matrix, int target) {
        System.out.println("\nInput: \n" + printMatrix(matrix));
        System.out.println("Target: " + target);

        long startTime = System.nanoTime();
        boolean result = searchMatrix(matrix, target);
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
