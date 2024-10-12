import java.util.Arrays;

public class _832_FlippingAnImage {
    
    /*
    832. Flipping an Image
    Given an n x n binary matrix image, 
    flip the image horizontally, 
    then invert it, and return the resulting image.
    
    To flip an image horizontally means that each row of the image is reversed.
    
    For example, flipping [1,1,0] horizontally results in [0,1,1].
    To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. OK
    
    For example, inverting [0,1,1] results in [1,0,0].

    Example 1:
    Input: image = 
    [
        [1,1,0],
        [1,0,1],
        [0,0,0]
    ]
    Output: 
    [
        [1,0,0],
        [0,1,0],
        [1,1,1]
    ]
    Explanation: First reverse each row: 
    [
        [0,1,1],
        [1,0,1],
        [0,0,0]
    ].
    Then, invert the image: 
    [
        [1,0,0],
        [0,1,0],
        [1,1,1]
    ]
    
    Example 2:
    Input: image = 
    [
        [1,1,0,0],
        [1,0,0,1],
        [0,1,1,1],
        [1,0,1,0]
    ]
    Output: 
    [
        [1,1,0,0],
        [0,1,1,0],
        [0,0,0,1],
        [1,0,1,0]
    ]
    Explanation: First reverse each row: 
    [
        [0,0,1,1],
        [1,0,0,1],
        [1,1,1,0],
        [0,1,0,1]
    ].
    Then invert the image: 
    [
        [1,1,0,0],
        [0,1,1,0],
        [0,0,0,1],
        [1,0,1,0]
    ]
    
    Constraints:
    n == image.length
    n == image[i].length
    1 <= n <= 20
    images[i][j] is either 0 or 1.
     */

    public static void main(String[] args) {

        int[][] image1 = {
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        };
        testFlipAndInvertImage(image1);

        int[][] image2 = {
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        };
        testFlipAndInvertImage(image2);
    }

    public static int[][] flipAndInvertImage(int[][] image) {

        int rows = image.length;
        int cols = image[0].length;

        int[][] reversed = reverseImage(image, rows, cols);

        return inverseImage(reversed, rows, cols);
    }

    private static int[][] inverseImage(int[][] image, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                image[i][j] = image[i][j] == 0 ? 1 : 0;
            }
        }
        return image;
    }

    private static int[][] reverseImage(int[][] image, int rows, int cols) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = cols - 1; j >= 0; j--) {
                result[i][cols - 1 - j] = image[i][j];
            }
        }
        return result;
    }

    public static void testFlipAndInvertImage(int[][] image) {
        System.out.println("\nInput:");
        print2DArray(image);

        long startTime = System.nanoTime();
        int[][] result = flipAndInvertImage(image);
        long endTime = System.nanoTime();

        System.out.println("Output:");
        print2DArray(result);
        System.out.println("Execution time: " + (endTime - startTime) + "ns");
        System.out.printf("Execution time: %.6f ms %n \n", (endTime - startTime) / 1_000_000.00);
    }

    public static void print2DArray(int[][] arr) {
        for (int[] row : arr) {
            System.out.println(Arrays.toString(row));
        }
    }
}