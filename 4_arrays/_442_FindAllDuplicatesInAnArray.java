import java.util.*;

public class _442_FindAllDuplicatesInAnArray {

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