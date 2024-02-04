import java.util.Arrays;

public class _35_SearchInsertPosition {

    /*
    35. Search Insert Position
    Given a sorted array of distinct integers and a
    target value, return the index if the target is found.
    If not, return the index where it would be if it were
    inserted in order.

    You must write an algorithm with O(log n) runtime complexity.

    Example 1:
    Input: nums = [1,3,5,6], target = 5
    Output: 2

    Example 2:
    Input: nums = [1,3,5,6], target = 2
    Output: 1

    Example 3:
    Input: nums = [1,3,5,6], target = 7
    Output: 4

    Constraints:
    1 <= nums.length <= 10^4
    -10^4 <= nums[i] <= 10^4
    nums contains distinct values sorted in ascending order.
    -10^4 <= target <= 10^4
     */

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 5, 6};
        testSearchInsert(nums1, 5);

        int[] nums2 = {1, 3, 5, 6};
        testSearchInsert(nums2, 2);

        int[] nums3 = {1, 3, 5, 6};
        testSearchInsert(nums3, 7);

        int[] nums4 = {1, 3, 5, 6};
        testSearchInsert(nums4, 0);

        int[] nums5 = {1};
        testSearchInsert(nums5, 0);
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target < nums[0]) return 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || nums[i] > target) return i;
        }
        return nums.length;
    }

    public static void testSearchInsert(int[] nums, int target) {
        System.out.println("\nInput: " + Arrays.toString(nums) + ", " + target);

        long startTime = System.nanoTime();
        int result = searchInsert(nums, target);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (endTime - startTime) + " ns\n");
        System.out.println("Runtime: " + (endTime - startTime) / 1_000_000 + " ms\n");
    }
}