import java.util.Arrays;

public class SingleNumber {

    /*

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

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
     * */

    public static void main(String[] args) {
        try {
            int[] nums = {2, 2, 1};
            int[] nums2 = {4, 1, 2, 1, 2};
            int[] nums3 = {1};

            long startTime = System.nanoTime();
            int answer = singleNumber(nums);
            long endTime = System.nanoTime();

            long startTime2 = System.nanoTime();
            int answer2 = singleNumber(nums2);
            long endTime2 = System.nanoTime();

            long startTime3 = System.nanoTime();
            int answer3 = singleNumber(nums3);
            long endTime3 = System.nanoTime();

            System.out.println(Arrays.toString(nums));
            System.out.println("Answer: " + answer);
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
            System.out.println("Execution time: " + (endTime - startTime) / 1000000 + " ms");
            System.out.println();

            System.out.println(Arrays.toString(nums2));
            System.out.println("Answer: " + answer2);
            System.out.println("Execution time: " + (endTime2 - startTime2) + " ns");
            System.out.println("Execution time: " + (endTime2 - startTime2) / 1000000 + " ms");
            System.out.println();

            System.out.println(Arrays.toString(nums3));
            System.out.println("Answer: " + answer3);
            System.out.println("Execution time: " + (endTime3 - startTime3) + " ns");
            System.out.println("Execution time: " + (endTime3 - startTime3) / 1000000 + " ms");

        } catch (Exception e) {
            System.err.println(e.getMessage());
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
