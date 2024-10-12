import java.util.Arrays;

public class _169_MajorityElement {

    /*
    169. Majority Element
    Given an array nums of size n, return the majority element.

    The majority element is the element that appears more
    than ⌊n / 2⌋ times. You may assume that the majority element
    always exists in the array.

    Example 1:
    Input: nums = [3,2,3]
    Output: 3

    Example 2:
    Input: nums = [2,2,1,1,1,2,2]
    Output: 2

    Constraints:
    n == nums.length
    1 <= n <= 5 * 10^4
    -10^9 <= nums[i] <= 10^9
     */

    public static void main(String[] args) {


        int[] nums1 = {3, 2, 3};
        testMajorityElement(nums1);

        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        testMajorityElement(nums2);

        int[] nums3 = {1};
        testMajorityElement(nums3);

        int[] nums4 = {1, 2};
        testMajorityElement(nums4);

        int[] nums5 = {1, 1, 2};
        testMajorityElement(nums5);

        int[] nums6 = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        testMajorityElement(nums6);
    }

    public static int majorityElement(int[] nums) {
        if (nums.length == 1) return nums[0];

        int count = 1;
        int majority = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                majority = nums[i];
                count = 1;
            }
        }
        return majority;
    }

    public static void testMajorityElement(int[] nums) {

        System.out.println("\nInput: " + Arrays.toString(nums));

        long startTime = System.nanoTime();
        int result = majorityElement(nums);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (endTime - startTime) + " ns");
        System.out.printf("Runtime: %.6f ms\n", (endTime - startTime) / 1_000_000.00);
    }
}