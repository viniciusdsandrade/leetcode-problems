import java.util.Arrays;

public class _1822_SignOfTheProductOfAnArray {

    /*
    1822. Sign of the Product of an Array

    There is a function signFunc(x) that returns:

    1 if x is positive.
    -1 if x is negative.
    0 if x is equal to 0.
    You are given an integer array nums. Let product be the product of all values in the array nums.

    Return signFunc(product).

    Example 1:
    Input: nums = [-1,-2,-3,-4,3,2,1]
    Output: 1
    Explanation: The product of all values in the array is 144, and signFunc(144) = 1

    Example 2:
    Input: nums = [1,5,0,2,-3]
    Output: 0
    Explanation: The product of all values in the array is 0, and signFunc(0) = 0

    Example 3:
    Input: nums = [-1,1,-1,1,-1]
    Output: -1
    Explanation: The product of all values in the array is -1, and signFunc(-1) = -1

    Constraints:
    1 <= nums.length <= 1000
    -100 <= nums[i] <= 100
     */

    public static void main(String[] args) {
        int[] nums1 = {-1, -2, -3, -4, 3, 2, 1};
        testArraySign(nums1);

        int[] nums2 = {1, 5, 0, 2, -3};
        testArraySign(nums2);

        int[] nums3 = {-1, 1, -1, 1, -1};
        testArraySign(nums3);
    }

    /**
     * Calcula o sinal do produto de um array de inteiros.
     *
     * <p>Este metodo retorna 1 se o produto de todos os elementos do array for positivo,
     * -1 se o produto for negativo e 0 se qualquer elemento do array for 0.</p>
     *
     * @param nums um array de inteiros
     * @return 1 se o produto de todos os elementos for positivo,
     *         -1 se o produto for negativo,
     *         ou 0 se qualquer elemento for 0
     */
    public static int arraySign(int[] nums) {
        int negativeCount = 0;
        for (int num : nums) {
            if (num == 0) return 0;
            if (num < 0) negativeCount++;
        }
        return (negativeCount % 2 == 0) ? 1 : -1;
    }

    public static void testArraySign(int[] nums) {
        System.out.println("Input: nums = " + Arrays.toString(nums));

        long startTime = System.nanoTime();
        int result = arraySign(nums);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution time: " + (endTime - startTime) + "ns\n");
    }
}
