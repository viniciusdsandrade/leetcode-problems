
import java.util.Arrays;

public class _268_MissingNumber {
    /*
    268. Missing Number

    Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

    Example 1:
    Input: nums = [3,0,1]
    Output: 2
    Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

    Example 2:
    Input: nums = [0,1]
    Output: 2
    Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

    Example 3:
    Input: nums = [9,6,4,2,3,5,7,0,1]
    Output: 8
    Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

    Constraints:
    n == nums.length
    1 <= n <= 104
    0 <= nums[i] <= n
    All the numbers of nums are unique.


    Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
     */

    public static void main(String[] args) {
        int[] nums1 = new int[]{3, 0, 1};
        testMissingNumber(nums1);

        int[] nums2 = new int[]{0, 1};
        testMissingNumber(nums2);

        int[] nums3 = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        testMissingNumber(nums3);
    }

    /**
     * A função {@code missingNumber} encontra o número faltante em um array contendo
     * todos os números de 0 a n, exceto um. O array não possui números duplicados e
     * sempre falta um número no intervalo de 0 a n.
     *
     * <p>O algoritmo utiliza a fórmula da soma dos primeiros n inteiros, que é
     * {@code n * (n + 1) / 2}, para calcular a soma esperada e subtrai a soma dos
     * números presentes no array. O resultado final será o número que está faltando.</p>
     *
     * @param nums O array de inteiros contendo n-1 números distintos no intervalo de 0 a n.
     * @return O número faltante no intervalo de 0 a n.
     *
     * @throws IllegalArgumentException se o array de entrada estiver vazio.
     */
    public static int missingNumber(int[] nums) {
        int n = nums.length; // 'n' é o tamanho do array, que deve conter n-1 elementos.

        // Calcula a soma esperada de todos os números de 0 a n
        // usando a fórmula da soma aritmética.
        int sum = n * (n + 1) / 2;

        /*
         * Subtrai os valores do array da soma calculada.
         * Ao final, a variável 'sum' conterá o número que está faltando.
         */
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum -= num;
        }

        // Retorna o número que está faltando.
        return sum;
    }


    public static void testMissingNumber(int[] nums) {
        System.out.println("\nInput: nums = " + Arrays.toString(nums));

        long startTime = System.nanoTime();
        int result = missingNumber(nums);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Time taken: " + (endTime - startTime) + " ns\n");
    }
}
