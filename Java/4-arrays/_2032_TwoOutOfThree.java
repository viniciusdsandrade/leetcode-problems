import java.util.*;

public class _2032_TwoOutOfThree {

    /*
    2032. Two Out of Three
    Given three integer arrays nums1, nums2, and nums3, return a distinct array
    containing all the values that are present in at least two out of the three arrays.
    You may return the values in any order.


    Example 1:
    Input: nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
    Output: [3,2]
    Explanation: The values that are present in at least two arrays are:
    - 3, in all three arrays.
    - 2, in nums1 and nums2.

    Example 2:
    Input: nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
    Output: [2,3,1]
    Explanation: The values that are present in at least two arrays are:
    - 2, in nums2 and nums3.
    - 3, in nums1 and nums2.
    - 1, in nums1 and nums3.

    Example 3:
    Input: nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
    Output: []
    Explanation: No value is present in at least two arrays.

    Constraints:
    1 <= nums1.length, nums2.length, nums3.length <= 100
    1 <= nums1[i], nums2[j], nums3[k] <= 100
     */

    public static void main(String[] args) {

        testTwoOutOfThree(new int[]{1, 1, 3, 2}, new int[]{2, 3}, new int[]{3});
        testTwoOutOfThree(new int[]{3, 1}, new int[]{2, 3}, new int[]{1, 2});
        testTwoOutOfThree(new int[]{1, 2, 2}, new int[]{4, 3, 3}, new int[]{5});
    }

    public static List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();

        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);
        for (int num : nums3) set3.add(num);

        for (int num : set1) {
            if (set2.contains(num) || set3.contains(num)) {
                result.add(num);
            }
        }
        for (int num : set2) {
            if (set1.contains(num) || set3.contains(num)) {
                result.add(num);
            }
        }
        for (int num : set3) {
            if (set1.contains(num) || set2.contains(num)) {
                result.add(num);
            }
        }

        for (int i = 0; i < result.size(); i++) {
            for (int j = i + 1; j < result.size(); j++) {
                if(Objects.equals(result.get(i), result.get(j))) {
                    result.remove(j);
                    j--;
                }
            }
        }
        return result;
    }

    public static void testTwoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("nums3 = " + Arrays.toString(nums3));
        System.out.println("twoOutOfThree(nums1, nums2, nums3) = " + twoOutOfThree(nums1, nums2, nums3));
    }
}
