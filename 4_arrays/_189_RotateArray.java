import java.util.Arrays;

public class _189_RotateArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        testRotate(arr1, 2);
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        System.out.println("Array original: " + Arrays.toString(nums));

        reverse(nums, 0, n - 1);
        System.out.println("Array após inverter todo o array: " + Arrays.toString(nums));

        reverse(nums, 0, k - 1); // Inverte os primeiros k elementos
        System.out.println("Array após inverter os primeiros " + k + " elementos: " + Arrays.toString(nums));

        reverse(nums, k, n - 1); // Inverte os elementos restantes
        System.out.println("Array após inverter os elementos restantes: " + Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            System.out.println("  Troca: " + Arrays.toString(nums));

            start++;
            end--;
        }
    }


    public static void testRotate(int[] nums, int k) {
        System.out.println("\nInput: " + Arrays.toString(nums) + ", k = " + k);

        long startTime = System.nanoTime();
        rotate(nums, k);
        long endTime = System.nanoTime();

        System.out.println("Output: " + Arrays.toString(nums));
        System.out.println("Runtime: " + (endTime - startTime) + " ns");
        System.out.printf("Runtime: %.6f ms\n", (endTime - startTime) / 1_000_000.0);
    }
}
