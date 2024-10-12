import java.util.Arrays;

public class _1979_FindGreatestCommonDivisorOfArray {

    /*
    1979. Find Greatest Common Divisor of Array

    Given an integer array nums, return the greatest common divisor
    of the smallest number and the largest number in nums.

    The greatest common divisor of two numbers is the
    largest positive integer that evenly divides both numbers.

    Example 1:
    Input: nums = [2,5,6,9,10]
    Output: 2
    Explanation:
    The smallest number in nums is 2.
    The largest number in nums is 10.
    The greatest common divisor of 2 and 10 is 2.

    Example 2:
    Input: nums = [7,5,6,8,3]
    Output: 1
    Explanation:
    The smallest number in nums is 3.
    The largest number in nums is 8.
    The greatest common divisor of 3 and 8 is 1.

    Example 3:
    Input: nums = [3,3]
    Output: 3
    Explanation:
    The smallest number in nums is 3.
    The largest number in nums is 3.
    The greatest common divisor of 3 and 3 is 3.

    Constraints:
    2 <= nums.length <= 1000
    1 <= nums[i] <= 1000
     */

    public static void main(String[] args) {
        int[] nums0 = {2, 5, 6, 9, 10, 12, 15, 18, 20, 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75};
        testFindGCD(nums0);

        int[] nums1 = {2, 5, 6, 9, 10};
        testFindGCD(nums1);

        int[] nums2 = {7, 5, 6, 8, 3};
        testFindGCD(nums2);

        int[] nums3 = {3, 3};
        testFindGCD(nums3);
    }

    /**
     * Encontra o maior divisor comum (GCD) de um array de inteiros.
     *
     * @param nums o array de inteiros
     * @return o maior divisor comum (GCD) dos valores no array
     */
    public static int findGCD(int[] nums) {
        int min = nums[0]; // Inicializa o mínimo com o primeiro valor do array
        int max = nums[0]; // Inicializa o máximo com o primeiro valor do array

        // Encontra o mínimo e o máximo no array: compara cada valor com o mínimo e o máximo atuais e atualiza se necessário
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return gcd(min, max);
    }

    /**
     * Calcula o maior divisor comum (GCD) de dois inteiros usando o algoritmo de Euclides.
     *
     * @param a o primeiro inteiro
     * @param b o segundo inteiro
     * @return o maior divisor comum (GCD) de a e b
     */
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void testFindGCD(int[] nums) {
        System.out.println("\nInput: nums = " + Arrays.toString(nums));

        long startTime = System.nanoTime();
        int result = findGCD(nums);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution time: " + (endTime - startTime) + "ns");
    }
}
