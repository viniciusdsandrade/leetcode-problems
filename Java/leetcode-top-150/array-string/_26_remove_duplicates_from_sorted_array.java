import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.nanoTime;
import static java.util.Arrays.asList;
import static java.util.Arrays.copyOfRange;

public class _26_remove_duplicates_from_sorted_array {

    /*
    26. Remove Duplicates from Sorted Array

    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

    Consider the number of unique elements of nums to be k, to get accepted. You need to do the following things:

    Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    Return k.
    Custom Judge:

    The judge will test your solution with the following code:

    int[] nums = [...]; // Input array
    int[] expectedNums = [...]; // The expected answer with correct length

    int k = removeDuplicates(nums); // Calls your implementation

    assert k == expectedNums.length;

    for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
    }

    If all assertions pass, then your solution will be accepted.


    Example 1:
    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).

    Example 2:
    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).

    Constraints:
    1 <= nums.length <= 3 * 10^4
    -100 <= nums[i] <= 100
    nums is sorted in non-decreasing order.
     */

    public static void main(String[] ignoredArgs) {
        int[] nums1 = new int[]{1, 1, 2};
        int[] nums2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        testRemoveDuplicates(nums1);
        testRemoveDuplicates(nums2);

        // Initialize the list as a mutable ArrayList
        List<Integer> nums3 = new ArrayList<>(asList(1, 2, 2));
        testRemoveDuplicates2(nums3);

        List<Integer> nums4 = new ArrayList<>(asList(0, 1, 2, 2, 2, 3, 3, 3, 4, 4));
        testRemoveDuplicates2(nums4);
    }

    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int i = 0;
        for (int j = 1; j < n; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void testRemoveDuplicates(int[] nums) {
        long start, end, executionTime;
        int result;
        int[] nums2;

        start = nanoTime();
        result = removeDuplicates(nums);
        end = nanoTime();

        nums2 = copyOfRange(nums, 0, result);

        executionTime = end - start;

        System.out.println("Input: nums =   " + Arrays.toString(nums));
        System.out.println("Output:         " + result + ", nums = " + Arrays.toString(nums2));
        System.out.println("Execution time: " + executionTime + " ns");
    }

    public static List<Integer> removeDuplicates2(List<Integer> nums) {
        // Create a mutable copy of the input list
        List<Integer> mutableNums = new ArrayList<>(nums);

        int n = mutableNums.size();
        if (n == 0) return mutableNums;

        int i = 0;
        while (i < n - 1) {
            if (mutableNums.get(i).equals(mutableNums.get(i + 1))) {
                mutableNums.remove(i + 1);
                n--;
            } else {
                i++;
            }
        }
        return mutableNums;
    }

    public static void testRemoveDuplicates2(List<Integer> nums) {
        long start, end, executionTime;
        List<Integer> result2;

        start = nanoTime();
        result2 = removeDuplicates2(nums);
        end = nanoTime();

        executionTime = end - start;

        System.out.println("Input: nums =   " + nums);
        System.out.println("Output:         " + result2);
        System.out.println("Execution time: " + executionTime + " ns");
    }
}
