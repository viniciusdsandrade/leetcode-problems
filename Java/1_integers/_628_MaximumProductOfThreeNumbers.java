import java.util.Arrays;

public class _628_MaximumProductOfThreeNumbers {
    
    /*
    628. Maximum Product of Three Numbers
    Given an integer array nums, find three numbers whose product 
    is maximum and return the maximum product.
    
    Example 1:
    Input: nums = [1,2,3]
    Output: 6
    
    Example 2:
    Input: nums = [1,2,3,4]
    Output: 24
    
    Example 3:
    Input: nums = [-1,-2,-3]
    Output: -6
     
    Constraints:    
    3 <= nums.length <= 10^4
    -1000 <= nums[i] <= 1000
     */

    public static void main(String[] args) {
        testMaximumProduct(new int[]{1, 2, 3});
        testMaximumProduct(new int[]{1, 2, 3, 4});
        testMaximumProduct(new int[]{-1, -2, -3});
        testMaximumProduct(new int[]{-1, -2, -3, 0});
        testMaximumProduct(new int[]{-1, -2, -3, 0, 1});
        testMaximumProduct(new int[]{-1, -2, -3, 0, 1, 2});
        testMaximumProduct(new int[]{-1, -2, -3, 0, 1, 2, 3});
        testMaximumProduct(new int[]{-1, -2, -3, 0, 1, 2, 3, 4});
        testMaximumProduct(new int[]{-1, -2, -3, 0, 1, 2, 3, 4, 5});
        testMaximumProduct(new int[]{-1, -2, -3, 0, 1, 2, 3, 4, 5, 6});
        testMaximumProduct(new int[]{-1, -2, -3, 0, 1, 2, 3, 4, 5, 6, 7});
        testMaximumProduct(new int[]{-1, -2, -3, 0, 1, 2, 3, 4, 5, 6, 7, 8});
        testMaximumProduct(new int[]{-1, -2, -3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        testMaximumProduct(new int[]{-1, -2, -3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        testMaximumProduct(new int[]{-1, -2, -3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        testMaximumProduct(new int[]{-1, -2, -3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        testMaximumProduct(new int[]{-1, -2, -3, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13});
    }

    public static int maximumProduct(int[] nums) {
        if (nums.length < 3 || nums.length > 10_000) return 0;
        if (nums.length == 3) return nums[0] * nums[1] * nums[2];

        Arrays.sort(nums);
        int n = nums.length;

        int max1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int max2 = nums[0] * nums[1] * nums[n - 1];

        return Math.max(max1, max2);
    }

    public static void testMaximumProduct(int[] nums) {
        System.out.println("\nInput: " + Arrays.toString(nums));

        long startTime = System.nanoTime();
        int result = maximumProduct(nums);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (endTime - startTime) + " ns");
        System.out.printf("Runtime: %.6f ms\n\n", (endTime - startTime) / 1_000_000.00);
    }
}