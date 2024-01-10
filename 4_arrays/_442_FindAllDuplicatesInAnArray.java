import java.util.*;
import java.util.stream.Collectors;

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
    1 <= n <= 10^5
    1 <= nums[i] <= n
    Each element in nums appears once or twice.
     */

    public static void main(String[] args) {

        int[] listaDe105Elementos = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 43, 44, 45, 46, 47, 48, 49, 50,
                51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                61, 62, 63, 64, 65, 66, 67, 68, 69, 70,
                71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
                81, 82, 83, 84, 85, 86, 87, 88, 89, 90,
                91, 92, 93, 94, 95, 96, 97, 98, 99, 100,
                101, 102, 103, 104, 105, 1
        };
        testFindDuplicates(listaDe105Elementos);

        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        testFindDuplicates(nums1);

        int[] nums2 = {1, 1, 2};
        testFindDuplicates(nums2);

        int[] nums3 = {1};
        testFindDuplicates(nums3);

        int[] nums4 = {};
        testFindDuplicates(nums4);
    }

    public static List<Integer> findDuplicates3(int[] nums) {
        // Caso o array seja nulo ou vazio, retorna nulo
        if (nums == null || nums.length > 100000) return null;

        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (set.contains(num))
                result.add(num);
            else
                set.add(num);
        }

        return result;
    }

    public static List<Integer> findDuplicates1(int[] nums) {
        // Caso o array seja nulo ou vazio, retorna nulo
        if (nums == null || nums.length > 100000) return null;

        List<Integer> result = new ArrayList<>();
        boolean[] found = new boolean[nums.length + 1];

        for (int num : nums) {
            if (found[num])
                result.add(num);
            else
                found[num] = true;
        }
        return result;
    }

    public static List<Integer> findDuplicates2(int[] nums) {
        // Caso o array seja nulo ou vazio, retorna nulo
        if (nums == null || nums.length > 100000) return null;

        List<Integer> result = Arrays.stream(nums).boxed().toList();

        return result.stream()
                .filter(number -> result.stream().filter(number::equals).count() > 1)
                .distinct()
                .collect(Collectors.toList());
    }

    public static void testFindDuplicates(int[] nums) {
        System.out.println("\nInput: " + Arrays.toString(nums));

        long startTime = System.nanoTime();
        List<Integer> res1 = findDuplicates1(nums);
        long endTime = System.nanoTime();

        long startTime2 = System.nanoTime();
        List<Integer> res2 = findDuplicates2(nums);
        long endTime2 = System.nanoTime();

        long startTime3 = System.nanoTime();
        List<Integer> res3 = findDuplicates3(nums);
        long endTime3 = System.nanoTime();

        long intervalo1 = endTime - startTime;
        long intervalo2 = endTime2 - startTime2;
        long intervalo3 = endTime3 - startTime3;

        System.out.println(Arrays.toString(res1.toArray()));
        System.out.println(Arrays.toString(res2.toArray()));
        System.out.println(Arrays.toString(res3.toArray()));
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Runtime1: " + intervalo1 + " ns");
        System.out.println("Runtime2: " + intervalo2 + " ns");
        System.out.println("Runtime3: " + intervalo3 + " ns");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf(" Runtime2/Runtime1 = " + "%.6f\n", (double) intervalo2 / intervalo1);
        System.out.printf(" Runtime3/Runtime1 = " + "%.6f\n", (double) intervalo3 / intervalo1);
        System.out.printf(" Runtime3/Runtime2 = " + "%.6f\n", (double) intervalo2 / intervalo3);
        System.out.println("=================================================================");
    }
}