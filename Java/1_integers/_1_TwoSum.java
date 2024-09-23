import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.nanoTime;

public class _1_TwoSum {
    /*
    1. Two Sum
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]


    Constraints:
    2 <= nums.length <= 10^4
    -10^9 <= nums[i] <= 10^9
    -10^9 <= target <= 10^9
    Only one valid answer exists.


    Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
     */
    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        testTwoSum(nums1, target1);

        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        testTwoSum(nums2, target2);

        int[] nums3 = {3, 3};
        int target3 = 6;
        testTwoSum(nums3, target3);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                result[0] = map.get(diff);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }

        return result;
    }

    public static void testTwoSum(int[] nums, int target) {
        System.out.println("\nInput: nums = " + Arrays.toString(nums) + ", target = " + target);

        long startTime, endTime, executionTime;
        int[] result;

        startTime = nanoTime();
        result = twoSum(nums, target);
        endTime = nanoTime();

        executionTime = endTime - startTime;

        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("Execution time: " + executionTime + " ns\n");
    }
}
