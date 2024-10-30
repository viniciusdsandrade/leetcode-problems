import java.util.Arrays;

import static java.lang.System.nanoTime;

public class _189_rotate_array {

    /*
    189. Rotate Array
    Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



    Example 1:
    Input: nums = [1,2,3,4,5,6,7], k = 3
    Output: [5,6,7,1,2,3,4]
    Explanation:
    rotate 1 steps to the right: [7,1,2,3,4,5,6]
    rotate 2 steps to the right: [6,7,1,2,3,4,5]
    rotate 3 steps to the right: [5,6,7,1,2,3,4]

    Example 2:
    Input: nums = [-1,-100,3,99], k = 2
    Output: [3,99,-1,-100]
    Explanation:
    rotate 1 steps to the right: [99,-1,-100,3]
    rotate 2 steps to the right: [3,99,-1,-100]


    Constraints:
    1 <= nums.length <= 10^5
    -2^31 <= nums[i] <= 2^31 - 1
    0 <= k <= 10^5


    Follow up:

    Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
    Could you do it in-place with O(1) extra space?
     */

    public static void main(String[] ignoredArgs) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        testRotate1(nums1, k1);

        int[] nums3 = {1, 2, 3, 4, 5, 6, 7};
        testRotate2(nums3, k1);

        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        testRotate1(nums2, k2);

        int[] nums4 = {-1, -100, 3, 99};
        testRotate2(nums4, k2);
    }

    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        if (k == 0) return;

        int[] temp = new int[k];
        System.arraycopy(nums, n - k, temp, 0, k);
        for (int i = n - 1; i >= k; i--) nums[i] = nums[i - k];
        System.arraycopy(temp, 0, nums, 0, k);
    }

    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void testRotate1(int[] nums, int k) {
        System.out.println("Input: nums = " + Arrays.toString(nums) + ", k = " + k);

        long start1, end1, runtime1;

        start1 = nanoTime();
        rotate1(nums, k);
        end1 = nanoTime();

        runtime1 = end1 - start1;


        System.out.println("Output: " + Arrays.toString(nums));
        System.out.println("Runtime1: " + runtime1 + " ns");
    }

    public static void testRotate2(int[] nums, int k) {
        System.out.println("Input: nums = " + Arrays.toString(nums) + ", k = " + k);

        long start1, end1, runtime1;

        start1 = nanoTime();
        rotate2(nums, k);
        end1 = nanoTime();

        runtime1 = end1 - start1;

        System.out.println("Output: " + Arrays.toString(nums));
        System.out.println("Runtime1: " + runtime1 + " ns");
    }
}
