import java.util.Arrays;

public class _2733_NeitherMinimumNorMaximum {

    /*
    2733. Neither Minimum nor Maximum
    Given an integer array nums containing distinct positive integers, find and return any 
    number from the array that is neither the minimum nor the maximum value in the array, or -1 if there is no such number.

    Return the selected integer.

    Example 1:
    Input: nums = [3,2,1,4]
    Output: 2
    Explanation: In this example, the minimum value is 1 and the maximum value is 4. 
    Therefore, either 2 or 3 can be valid answers.

    Example 2:
    Input: nums = [1,2]
    Output: -1
    Explanation: Since there is no number in nums that is neither 
    the maximum nor the minimum, we cannot select a number that satisfies the given condition. Therefore, there is no answer.

    Example 3:
    Input: nums = [2,1,3]
    Output: 2
    Explanation: Since 2 is neither the maximum nor the minimum value in nums, it is the only valid answer. 
 
    Constraints:

    1 <= nums.length <= 100
    1 <= nums[i] <= 100
    All values in nums are distinct
     */

    public static void main(String[] args) {
            int[] array1 = {3, 2, 1, 4};
            int[] array2 = {1, 2};
            int[] array3 = {2, 1, 3};

            runTest(array1);
            runTest(array2);
            runTest(array3);
    }

    private static void runTest(int[] nums) {
        try {
            long startTime = System.nanoTime();
            int answer = findNonMinOrMax(nums);
            long endTime = System.nanoTime();

            System.out.println("\nInput:  " + Arrays.toString(nums));
            System.out.println("Output: " + answer);
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
            System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1000000.0);
            System.out.println();
        } catch (RuntimeException e) {
            System.err.println("Error in test: " + e.getMessage());
        }
    }

    public static int findNonMinOrMax(int[] nums) {
        //Se o array tiver menos de 3 elementos, retornar -1
        if (nums.length < 3)
            return -1;

        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if ((a > b && a < c) || (a < b && a > c))
            return a;
        else if ((b > a && b < c) || (b < a && b > c))
            return b;
        else if ((c > a && c < b) || (c < a && c > b))
            return c;

        return -1;
    }
}
