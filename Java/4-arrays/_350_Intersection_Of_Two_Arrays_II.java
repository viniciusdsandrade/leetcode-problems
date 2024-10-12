import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _350_Intersection_Of_Two_Arrays_II {

    /*
    350. Intersection of Two Arrays II
    Given two integer arrays nums1 and nums2, return an array of their intersection.
    Each element in the result must appear as many times as it shows in both arrays,
    and you may return the result in any order.

    Example 1:
    Input: nums1 = [1,2,2,1], nums2 = [2,2]
    Output: [2,2]

    Example 2:
    Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    Output: [4,9]
    Explanation: [9,4] is also accepted.

    Constraints:
    1 <= nums1.length, nums2.length <= 1000
    0 <= nums1[i], nums2[i] <= 1000

    Follow up:
    What if the given array is already sorted?How would you optimize your algorithm?
    What if nums1's size is small compared to nums2's size?
    Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you
    cannot load all elements into the memory at once?
     */

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        testIntersect(nums1, nums2);

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        testIntersect(nums3, nums4);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        // Caso o tamanho de nums1 seja maior que o de nums2, chama a função com os parâmetros invertidos
        if (nums1.length > nums2.length)  return intersect(nums2, nums1);


        // Cria um HashMap para armazenar os elementos de nums1 e suas respectivas quantidades
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1)
            map.put(num, map.getOrDefault(num, 0) + 1);

        // Cria um array para armazenar os elementos em comum entre nums1 e nums2
        int[] result = new int[nums1.length];
        int index = 0;

        // Itera sobre os elementos de nums2 e verifica se o elemento está presente em nums1
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                result[index++] = num;
                map.put(num, count - 1);
            }
        }

        return Arrays.copyOf(result, index);
    }

    public static void testIntersect(int[] nums1, int[] nums2) {
        System.out.println("nums1: " + Arrays.toString(nums1));
        System.out.println("nums2: " + Arrays.toString(nums2));

        long start = System.nanoTime();
        int[] result = intersect(nums1, nums2);
        long end = System.nanoTime();

        System.out.println("Result: " + Arrays.toString(result));
        System.out.println("Execution Time: " + (end - start) + " ns\n");
    }
}
