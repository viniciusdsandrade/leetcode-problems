import java.util.Arrays;

public class _136_SingleNumber {

    /*
    136. Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    You must implement a solution with a linear runtime complexity and use only constant extra space.

    Example 1:
    Input: nums = [2,2,1]
    Output: 1

    Example 2:
    Input: nums = [4,1,2,1,2]
    Output: 4

    Example 3:
    Input: nums = [1]
    Output: 1

    Constraints:
    1 <= nums.length <= 3 * 104
    -3 * 104 <= nums[i] <= 3 * 104
    Each element in the array appears twice except for one element which appears only once.
     */

    public static void main(String[] args) {
        testSingleNumber(new int[]{2, 2, 1});
        testSingleNumber(new int[]{4, 1, 2, 1, 2});
        testSingleNumber(new int[]{1});
    }

    private static void testSingleNumber(int[] nums) {
        try {
            long startTime = System.nanoTime();
            int answer = singleNumber(nums);
            long endTime = System.nanoTime();

            System.out.println("\nInput: " + Arrays.toString(nums));
            System.out.println("Answer: " + answer);
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
            System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1000000.0);
        } catch (RuntimeException e) {
            System.err.println("Error in test: " + e.getMessage());
        }
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) return nums[0]; // if there is only one element in the array, return it

        Arrays.sort(nums); // sort the array

        for (int i = 0; i < nums.length; i += 2) { // iterate through the array by 2
            if (i == nums.length - 1) return nums[i]; // if the last element is reached, return it
            if (nums[i] != nums[i + 1])
                return nums[i]; // if the current element is not equal to the next element, return the current element
        }

        return -1; // if no single number is found, return -1
    }
}