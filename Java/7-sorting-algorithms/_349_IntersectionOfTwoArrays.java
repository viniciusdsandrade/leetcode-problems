import java.util.*;

public class _349_IntersectionOfTwoArrays {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        testIntersection(nums1, nums2);

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        testIntersection(nums3, nums4);

        int[] nums5 = {1, 2, 3, 4, 5};
        int[] nums6 = {6, 7, 8, 9, 10};
        testIntersection(nums5, nums6);

        int[] nums7 = {1, 2, 3, 4, 5};
        int[] nums8 = {1, 2, 3, 4, 5};
        testIntersection(nums7, nums8);

        int[] nums9 = {1, 2, 3, 4, 5};
        int[] nums10 = {1, 2, 3, 4, 5, 6};
        testIntersection(nums9, nums10);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        // Converte os arrays para conjuntos (Set) para remover duplicatas
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();


        for (int num : nums1) set1.add(num);
        for (int num : nums2) set2.add(num);

        // Encontra a interseção dos conjuntos
        set1.retainAll(set2);

        // Converte o conjunto de interseção de volta para um array
        int[] result = new int[set1.size()];
        int index = 0;
        for (int num : set1)  result[index++] = num;

        return result;
    }

    public static void testIntersection(int[] nums1, int[] nums2) {

        System.out.println("\nInput: " + Arrays.toString(nums1) + ", " + Arrays.toString(nums2));

        long startTime = System.nanoTime();
        int[] result = intersection(nums1, nums2);
        long endTime = System.nanoTime();

        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("Runtime: " + (endTime - startTime) + " ns");
        System.out.printf("Runtime: %.5f ms\n", (endTime - startTime) / 1_000_000.0);
    }
}