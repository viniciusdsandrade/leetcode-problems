import java.util.*;

public class _2610_ConvertAnArrayIntoA2DArrayWithConditions {

    /*
    2610. Convert an Array Into a 2D Array With Conditions
    You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:

    The 2D array should contain only the elements of the array nums.
    Each row in the 2D array contains distinct integers.
    The number of rows in the 2D array should be minimal.
    Return the resulting array. If there are multiple answers, return any of them.

    Note that the 2D array can have a different number of elements on each row.

    Example 1:
    Input: nums = [1,3,4,1,2,3,1]
    Output: [[1,3,4,2],[1,3],[1]]
    Explanation: We can create a 2D array that contains the following rows:
    - 1,3,4,2
    - 1,3
    - 1
    All elements of nums were used, and each row of the 2D array contains distinct integers, so it is a valid answer.
    It can be shown that we cannot have less than 3 rows in a valid array.

    Example 2:
    Input: nums = [1,2,3,4]
    Output: [[4,3,2,1]]
    Explanation: All elements of the array are distinct, so we can keep all of them in the first row of the 2D array.

    Constraints:
    1 <= nums.length <= 200
    1 <= nums[i] <= nums.length
     */

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 4, 1, 2, 3, 1};
        testFindMatrix(nums1);

        int[] nums2 = {1, 2, 3, 4};
        testFindMatrix(nums2);

        int[] nums3 = {1, 1, 1, 1, 1, 1, 1};
        testFindMatrix(nums3);

        int[] nums4 = {1, 2, 3, 4, 5, 6, 7};
        testFindMatrix(nums4);

        int[] nums5 = {1, 2, 3, 4, 5, 6, 7, 8};
        testFindMatrix(nums5);

        int[] nums6 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        testFindMatrix(nums6);

        int[] nums7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        testFindMatrix(nums7);

        int[] nums8 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        testFindMatrix(nums8);

        int[] nums9 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        testFindMatrix(nums9);
    }

    public static List<List<Integer>> findMatrix(int[] nums) {

        if (nums == null || nums.length == 0) return null;

        List<List<Integer>> result = new ArrayList<>();

        for (int num : nums) {

            if (result.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                list.add(num);
                result.add(list);
            } else {
                boolean found = false;
                for (List<Integer> list : result) {
                    if (!list.contains(num)) {
                        list.add(num);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static void testFindMatrix(int[] nums) {
        System.out.println("\nInput: " + Arrays.toString(nums));

        long startTime = System.nanoTime();
        List<List<Integer>> result = findMatrix(nums);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (endTime - startTime) + " ns\n");
        System.out.println("Runtime: " + (endTime - startTime) / 1_000_000 + " ms\n");
    }
}
