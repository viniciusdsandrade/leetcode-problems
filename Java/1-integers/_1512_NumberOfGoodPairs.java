import java.util.Arrays;

public class _1512_NumberOfGoodPairs {
    /*
    1512. Number of Good Pairs
    Given an array of integers nums, return the number of good pairs.

    A pair (i, j) is called good if nums[i] == nums[j] and i < j.

    Example 1:
    Input: nums = [1,2,3,1,1,3]
    Output: 4
    Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.

    Example 2:
    Input: nums = [1,1,1,1]
    Output: 6
    Explanation: Each pair in the array is good.

    Example 3:
    Input: nums = [1,2,3]
    Output: 0

    Constraints:
    1 <= nums.length <= 100
    1 <= nums[i] <= 100
     */
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 1, 1, 3};
        testNumIdenticalPairs(nums1);

        int[] nums2 = {1, 1, 1, 1};
        testNumIdenticalPairs(nums2);

        int[] nums3 = {1, 2, 3};
        testNumIdenticalPairs(nums3);
    }

    public static int numIdenticalPairs(int[] nums) {
        int[] count = new int[101]; // Initialize an array to keep track of the frequency of each number
        int goodPairs = 0; // Initialize a variable to keep track of good pairs

        // Iterate through each element in the array
        for (int num : nums) goodPairs += count[num]++;

        // Return the total number of good pairs found
        return goodPairs;
    }

    public static int numIdenticalPairs2(int[] nums) {
        int count = 0; // Initialize a variable to keep track of good pairs

        // Iterate through each element (i) in the array
        for (int i = 0; i < nums.length; i++) {
            // For each element (i), compare it with all subsequent elements (j)
            for (int j = i + 1; j < nums.length; j++) {
                // If a pair is found with the same value and i < j, increment the count
                if (nums[i] == nums[j])
                    count++;
            }
        }

        // Return the total number of good pairs found
        return count;
    }

    public static void testNumIdenticalPairs(int[] nums) {
        System.out.println("Input: nums = " + Arrays.toString(nums));

        long start = System.nanoTime();
        int result = numIdenticalPairs(nums);
        long end = System.nanoTime();

        long start2 = System.nanoTime();
        int result2 = numIdenticalPairs2(nums);
        long end2 = System.nanoTime();

        long runtime1 = end - start;
        long runtime2 = end2 - start2;

        System.out.println("Output: " + result);
        System.out.println("Runtime:  " + runtime1 + " ns");
        System.out.println("Runtime2: " + runtime2 + " ns");
    }
}
