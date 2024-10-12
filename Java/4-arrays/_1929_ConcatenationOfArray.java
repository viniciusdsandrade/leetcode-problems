import java.util.Arrays;

public class _1929_ConcatenationOfArray {

    /*
    1929. Concatenation of Array
    Given an integer array nums of length n, you want to create an array ans of length 2n
    where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

    Specifically, ans is the concatenation of two nums arrays.

    Return the array ans.

    Example 1:
    Input: nums = [1,2,1]
    Output: [1,2,1,1,2,1]
    Explanation: The array ans is formed as follows:
    - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
    - ans = [1,2,1,1,2,1]

    Example 2:
    Input: nums = [1,3,2,1]
    Output: [1,3,2,1,1,3,2,1]
    Explanation: The array ans is formed as follows:
    - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
    - ans = [1,3,2,1,1,3,2,1]

    Constraints:
    n == nums.length
    1 <= n <= 1000
    1 <= nums[i] <= 1000
     */

    public static void main(String[] args) {
        int[] nums_1 = {1, 2, 1};
        testGetConcatenation(nums_1);

        int[] nums_2 = {1, 3, 2, 1};
        testGetConcatenation(nums_2);
    }

    /**
     * Retorna um novo array que é a concatenação do array de entrada consigo mesmo.
     *
     * <p>Por exemplo, se o array de entrada for {1, 2, 1}, o array retornado será {1, 2, 1, 1, 2, 1}.</p>
     *
     * @param nums o array de inteiros a ser concatenado
     * @return um novo array que é a concatenação do array de entrada consigo mesmo
     */
    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2]; // um array com o dobro do tamanho

        // Coloca o elemento no início do Array, e na posição i + n (ou seja, no final do array)
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i];
            ans[i + nums.length] = nums[i];
        }

        return ans;
    }

    public static void testGetConcatenation(int[] nums) {
        System.out.println("Input: nums = " + Arrays.toString(nums));

        long startTime = System.nanoTime();
        int[] result = getConcatenation(nums);
        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("Output:         " + Arrays.toString(result));
        System.out.println("Execution time: " + timeElapsed + "ns\n");
    }
}
