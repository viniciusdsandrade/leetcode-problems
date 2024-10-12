import java.util.Arrays;

public class _11_ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height_1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int[] height_2 = {1, 1};
        int[] height_3 = {4, 3, 2, 1, 4};
        int[] height_4 = {1, 2, 1};

        testMaxArea(height_1);
        testMaxArea(height_2);
        testMaxArea(height_3);
        testMaxArea(height_4);
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right])
                left++;
            else
                right--;

        }
        return maxArea;
    }

    public static void testMaxArea(int[] height) {
        System.out.println("\nInput: " + Arrays.toString(height));

        long start = System.nanoTime();
        int result = maxArea(height);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (end - start) + " ns\n");
    }
}