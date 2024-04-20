import java.util.Arrays;
import java.util.HashSet;

public class _217_ContainsDuplicate {

    /*
    217. Contains Duplicate
    Given an integer array nums, return true if any value appears at least twice in the array,
    and return false if every element is distinct.

    Example 1:
    Input: nums = [1,2,3,1]
    Output: true

    Example 2:
    Input: nums = [1,2,3,4]
    Output: false

    Example 3:
    Input: nums = [1,1,1,3,3,4,3,2,4,2]
    Output: true

    Constraints:
    1 <= nums.length <= 10^5
    -10^9 <= nums[i] <= 10^9
     */
    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 1};
        testContainsDuplicate(nums1);

        int[] nums2 = {1, 2, 3, 4};
        testContainsDuplicate(nums2);

        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        testContainsDuplicate(nums3);

        int[] nums4 = {};
        testContainsDuplicate(nums4);

        int[] nums5 = {1};
        testContainsDuplicate(nums5);

        int[] nums6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 1};
        testContainsDuplicate(nums6);

        int[] nums7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        testContainsDuplicate(nums7);

        int[] nums8 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14};
        testContainsDuplicate(nums8);

        int[] nums9 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14, 1};
        testContainsDuplicate(nums9);

        int[] nums10 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14, 1, 1};
        testContainsDuplicate(nums10);

        int[] nums11 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14, 1, 1, 1};
        testContainsDuplicate(nums11);

        int[] nums12 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14, 1, 1, 1, 1};
        testContainsDuplicate(nums12);

        int[] nums13 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 14, 1, 1, 1, 1, 1};
        testContainsDuplicate(nums13);
    }

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums)
            if (!set.add(num))
                return true;

        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        int xor = 0;

        // Aplicar a operação XOR em todos os elementos do array
        for (int num : nums)
            xor ^= num;

        // Se houver uma duplicata, o resultado final do xor não será zero
        return xor != 0;
    }




    public static void testContainsDuplicate(int[] nums) {

        System.out.println("\nInput: " + Arrays.toString(nums));

        long startTime = System.nanoTime();
        boolean result = containsDuplicate(nums);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (endTime - startTime) + " ns");
        System.out.printf("Runtime: %.6f ms\n", (endTime - startTime) / 1_000_000.0);
    }
}
