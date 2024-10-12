import java.util.Arrays;

public class _75_Sort_Colors {

    /*
    75. Sort Colors
    Given an array nums with n objects colored red, white, or blue,
    sort them in-place so that objects of the same color are adjacent,
    with the colors in the order red, white, and blue.

    We will use integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

    You must solve this problem without using the library's sort function.

    Example 1:
    Input: nums = [2,0,2,1,1,0]
    Output: [0,0,1,1,2,2]

    Example 2:
    Input: nums = [2,0,1]
    Output: [0,1,2]

    Constraints:
    n == nums.length
    1 <= n <= 300
    nums[i] is either 0, 1, or 2.

    Follow up: Could you come up with a one-pass algorithm using only constant extra space?
     */

    public static void main(String[] args) {
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        testSortColors(nums1);

        int[] nums2 = {2, 0, 1};
        testSortColors(nums2);
    }

    /**
     * Ordena um array de inteiros contendo apenas 0s, 1s e 2s em ordem crescente.
     *
     * @param nums O array de inteiros a ser ordenado.
     */
    public static void sortColors(int[] nums) {
        // Implementação do algoritmo de ordenação Dutch National Flag.

        int n = nums.length;
        int low = 0;
        int high = n - 1;
        int i;

        for (i = 0; i <= high; i++) {
            if (nums[i] == 0) {
                swap(nums, i, low);
                low++;
            } else if (nums[i] == 2) {
                swap(nums, i, high);
                high--;
                i--;
            }
        }
    }

    /**
     * Método auxiliar para trocar dois elementos em um array de inteiros.
     *
     * @param nums O array de inteiros.
     * @param i O índice do primeiro elemento a ser trocado.
     * @param j O índice do segundo elemento a ser trocado.
     */
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void testSortColors(int[] nums) {
        System.out.println("Input: " + Arrays.toString(nums));

        long startTime = System.nanoTime();
        sortColors(nums);
        long endTime = System.nanoTime();

        long executionTime = (endTime - startTime);

        System.out.println("Output: " + Arrays.toString(nums));
        System.out.println("Execution time: " + executionTime + " ns\n");
    }
}
