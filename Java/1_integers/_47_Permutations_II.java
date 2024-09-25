import java.util.Arrays;
import java.util.List;

public class _47_Permutations_II {

    /*
    47. Permutations II

    Given a collection of numbers, nums, that might contain duplicates,
    return all possible unique permutations in any order.

    Example 1:
    Input: nums = [1,1,2]
    Output:
    [[1,1,2],
     [1,2,1],
     [2,1,1]]

    Example 2:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


    Constraints:
    1 <= nums.length <= 8
    -10 <= nums[i] <= 10
     */

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};
        testPermuteUnique(nums1);

        int[] nums2 = {1, 2, 3};
        testPermuteUnique(nums2);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        return null;
    }

    public static void testPermuteUnique(int[] nums) {
        System.out.println("Input: nums = " + Arrays.toString(nums));

        List<List<Integer>> result;
        long startTime, endTime, runtime;

        startTime = System.nanoTime();
        result = permuteUnique(nums);
        endTime = System.nanoTime();

        runtime = (endTime - startTime);

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + runtime + " ns\n");
    }
}
