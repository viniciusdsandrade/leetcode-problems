import java.util.Arrays;

public class _189_RotateArray {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        testRotate(arr1, 1);
        testRotate(arr1, 7);
        testRotate(arr1, 14);

        int[] arr2 = {-1, -100, 3, 99};
        testRotate(arr2, 2);

        int[] arr3 = {1, 2, 3, 4, 5, 6};
        testRotate(arr3, 4);
    }

    public static void rotate(int[] nums, int k) {

        if (k == 0 || nums.length == 1 || k == nums.length) return;

        if (k > nums.length)
            k = k % nums.length; // Se k for maior que o tamanho do array, k = k % nums.length (resto da divisão de k por nums.length

        for (int i = 0; i < k; i++) {
            int last = nums[nums.length - 1]; // Define o último elemento do array

            // Move todos os elementos do array para a direita
            for (int j = nums.length - 1; j > 0; j--)
                nums[j] = nums[j - 1];

            nums[0] = last; // Define o primeiro elemento do array como o último
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