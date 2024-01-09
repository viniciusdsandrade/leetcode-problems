import java.util.*;

public class _442_FindAllDuplicatesInAnArray {

    /*
    442. Find All Duplicates in an Array
    Given an integer array nums of length n where all the integers of nums
    are in the range [1, n] and each integer appears once or twice,
    return an array of all the integers that appears twice.

    You must write an algorithm that runs in O(n) time and uses only constant extra space.

    Example 1:
    Input: nums = [4,3,2,7,8,2,3,1]
    Output: [2,3]

    Example 2:
    Input: nums = [1,1,2]
    Output: [1]

    Example 3:
    Input: nums = [1]
    Output: []

    Constraints:
    n == nums.length
    1 <= n <= 105
    1 <= nums[i] <= n
    Each element in nums appears once or twice.
     */

    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        testFindDuplicates(nums1);

        int[] nums2 = {1, 1, 2};
        testFindDuplicates(nums2);

        int[] nums3 = {1};
        testFindDuplicates(nums3);

        int[] nums4 = {};
        testFindDuplicates(nums4);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        // Caso o array seja nulo ou vazio, retorna nulo
        if (nums == null || nums.length == 0) return null;

        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                result.add(num);
            } else {
                seen.add(num);
            }
        }

        return result;
    }

    public static void testFindDuplicates(int[] nums) {
        System.out.println("\nInput: " + Arrays.toString(nums));

        long startTime = System.nanoTime();
        List<Integer> result = findDuplicates(nums);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (endTime - startTime) + " ns\n");
        System.out.println("Runtime: " + (endTime - startTime) / 1_000_000 + " ms\n");
    }
}