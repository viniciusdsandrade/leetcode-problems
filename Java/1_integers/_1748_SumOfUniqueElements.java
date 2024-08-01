import java.util.Arrays;

public class _1748_SumOfUniqueElements {

    /*
    1748. Sum of Unique Elements
    You are given an integer array nums. The unique elements
    of an array are the elements that appear exactly once in the array.

    Return the sum of all the unique elements of nums.

    Example 1:
    Input: nums = [1,2,3,2]
    Output: 4
    Explanation: The unique elements are [1,3], and the sum is 4.

    Example 2:
    Input: nums = [1,1,1,1,1]
    Output: 0
    Explanation: There are no unique elements, and the sum is 0.

    Example 3:
    Input: nums = [1,2,3,4,5]
    Output: 15
    Explanation: The unique elements are [1,2,3,4,5], and the sum is 15.

    Constraints:
    1 <= nums.length <= 100
    1 <= nums[i] <= 100
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2};
        testSumOfUnique(nums1);

        int[] nums2 = {1, 1, 1, 1, 1};
        testSumOfUnique(nums2);

        int[] nums3 = {1, 2, 3, 4, 5};
        testSumOfUnique(nums3);
    }

    /**
     * Calcula a soma dos elementos únicos em um array de inteiros.
     *
     * @param nums Um array de inteiros onde os elementos são valores entre 0 e 100.
     * @return A soma dos elementos que aparecem exatamente uma vez no array.
     */
    public static int sumOfUnique(int[] nums) {
        int[] freq = new int[101];
        int sum = 0;

        for (int num : nums) freq[num]++;

        for (int i = 1; i < freq.length; i++)
            if (freq[i] == 1) sum += i;

        return sum;
    }

    public static void testSumOfUnique(int[] nums) {
        System.out.println("Input: nums = " + Arrays.toString(nums));

        long start = System.nanoTime();
        int result = sumOfUnique(nums);
        long end = System.nanoTime();

        long elapsedTime = end - start;

        System.out.println("Output:  " + result);
        System.out.println("Runtime: " + elapsedTime + "ns");
    }


}
