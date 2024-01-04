import java.util.Arrays;

public class _4_MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        testFindMedianSortedArrays(nums1, nums2);

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        testFindMedianSortedArrays(nums3, nums4);

        int[] nums5 = {0, 0};
        int[] nums6 = {0, 0};
        testFindMedianSortedArrays(nums5, nums6);

        int[] nums7 = {};
        int[] nums8 = {1};
        testFindMedianSortedArrays(nums7, nums8);

        int[] nums9 = {2};
        int[] nums10 = {};
        testFindMedianSortedArrays(nums9, nums10);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        int i = 0, j = 0, k = 0;

        while (i < nums1.length && j < nums2.length) {
            merged[k++] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
        }

        while (i < nums1.length) {
            merged[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            merged[k++] = nums2[j++];
        }

        if (merged.length % 2 == 0) {
            return (merged[merged.length / 2 - 1] + merged[merged.length / 2]) / 2.0;
        } else {
            return merged[merged.length / 2];
        }
    }

    public static void testFindMedianSortedArrays(int[] nums1, int[] nums2) {
        long startTime = System.nanoTime();
        double result = findMedianSortedArrays(nums1, nums2);
        long endTime = System.nanoTime();

        System.out.println("\nInput:  " + Arrays.toString(nums1) + ", " + Arrays.toString(nums2));
        System.out.println("Output: " + result);
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
        System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1_000_000.0);
    }
}