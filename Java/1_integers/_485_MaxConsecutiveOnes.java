import java.util.Arrays;

public class _485_MaxConsecutiveOnes {
    /*
    485. Max Consecutive Ones
    Given a binary array nums, return the maximum number of consecutive 1's in the array.

    Example 1:
    Input: nums = [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s.
    The maximum number of consecutive 1s is 3.

    Example 2:
    Input: nums = [1,0,1,1,0,1]
    Output: 2

    Constraints:
    1 <= nums.length <= 10^5
    nums[i] is either 0 or 1.
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 0, 1, 1, 1};
        testFindMaxConsecutiveOnes(nums1);

        int[] nums2 = {1, 0, 1, 1, 0, 1};
        testFindMaxConsecutiveOnes(nums2);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxConsecutiveOnes = 0;
        int currentConsecutiveOnes = 0;

        for (int num : nums) {
            if (num == 1) {
                currentConsecutiveOnes++;
                if (currentConsecutiveOnes > maxConsecutiveOnes) {
                    maxConsecutiveOnes = currentConsecutiveOnes;
                }
            } else {
                currentConsecutiveOnes = 0;
            }
        }

        return maxConsecutiveOnes;
    }

    public static void testFindMaxConsecutiveOnes(int[] nums) {
        System.out.println("Input: nums = " + Arrays.toString(nums));

        long start = System.nanoTime();
        int result = findMaxConsecutiveOnes(nums);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (end - start) + " ns");
    }
}
