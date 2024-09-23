import java.util.Arrays;

import static java.lang.Math.max;

public class _53_MaximumSubarray {

    /*
    53. Maximum Subarray
    Given an integer array nums, find thesubarray
    with the largest sum, and return its sum.

    Example 1:
    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: The subarray [4,-1,2,1] has the largest sum 6.

    Example 2:
    Input: nums = [1]
    Output: 1
    Explanation: The subarray [1] has the largest sum 1.

    Example 3:
    Input: nums = [5,4,-1,7,8]
    Output: 23
    Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

    Constraints:
    1 <= nums.length <= 10^5
    -10^4 <= nums[i] <= 10^4

    Follow up: If you have figured out the O(n) solution,
    try coding another solution using the divide and conquer approach,
    which is more subtle.
     */

    public static void main(String[] args) {
        int[] nums1 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        testMaxSubArray(nums1);

        int[] nums2 = new int[]{1};
        testMaxSubArray(nums2);

        int[] nums3 = new int[]{5, 4, -1, 7, 8};
        testMaxSubArray(nums3);

        // Exemplo 4: Array com todos os elementos negativos
        int[] nums4 = new int[]{-2, -3, -1, -5, -4};
        testMaxSubArray(nums4);

        // Exemplo 5: Array com um único elemento negativo
        int[] nums5 = new int[]{-2};
        testMaxSubArray(nums5);

        // Exemplo 6: Array com elementos repetidos
        int[] nums6 = new int[]{2, 2, 2, -1, 2, 2};
        testMaxSubArray(nums6);
    }

    /**
     * A função {@code maxSubArray} encontra a soma máxima de um subarray contíguo dentro de um array de inteiros.
     * Esse problema é conhecido como "Maximum Subarray Problem" e é resolvido de forma eficiente usando um algoritmo
     * de tempo linear baseado na abordagem de Kadane.
     *
     * <p>O algoritmo percorre o array uma única vez, mantendo a soma máxima encontrada até o momento e a soma atual
     * do subarray que está sendo considerado.</p>
     *
     * @param nums O array de inteiros contendo os valores a serem analisados.
     * @return A soma máxima possível de um subarray contíguo dentro do array.
     * @throws IllegalArgumentException se o array de entrada estiver vazio.
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];  // A variável 'maxSum' armazena a soma máxima encontrada até o momento.
        int currentSum = nums[0]; // A variável 'currentSum' armazena a soma do subarray contíguo atual.

        /*
         * Loop para percorrer os elementos do array, começando do segundo elemento (índice 1).
         * A ideia é verificar se é mais vantajoso continuar somando o valor atual ao subarray corrente,
         * ou se é melhor iniciar um novo subarray a partir do valor atual.
         */
        for (int i = 1; i < nums.length; i++) {
            currentSum = max(nums[i], currentSum + nums[i]); // Atualiza a soma atual, escolhendo entre o valor atual do elemento ou a soma deste valor com a soma corrente.
            maxSum = max(maxSum, currentSum); // Atualiza a soma máxima, caso a soma corrente seja maior que a soma máxima registrada até o momento.
        }

        // Retorna a soma máxima encontrada para um subarray contíguo.
        return maxSum;
    }

    /**
     * A função {@code maxSubArray} encontra a soma máxima de um subarray contíguo num array de inteiros.
     * Esta implementação utiliza uma abordagem de força bruta, calculando as somas de todos os subarrays possíveis
     * e retornando a maior delas.
     *
     * <p>A complexidade de tempo desta abordagem é O(n^2), onde n é o tamanho do array de entrada.</p>
     *
     * @param nums O array de inteiros contendo os valores a serem analisados.
     * @return A soma máxima possível de um subarray contíguo dentro do array.
     * @throws IllegalArgumentException se o array de entrada estiver vazio.
     */
    public static int maxSubArray2(int[] nums) {
        int maxSum = nums[0]; // Inicializa a soma máxima com o primeiro elemento do array.

        // Loop externo: define o ponto de início do subarray.
        for (int i = 0; i < nums.length; i++) {
            // Loop interno: define o ponto final do subarray.
            for (int j = i; j < nums.length; j++) {
                int currentSum = 0; // Inicializa a soma do subarray atual.

                // Loop para calcular a soma do subarray atual.
                for (int k = i; k <= j; k++) {
                    currentSum += nums[k];
                }

                // Atualiza a soma máxima, se necessário.
                maxSum = max(maxSum, currentSum);
            }
        }
        return maxSum;
    }

    public static void testMaxSubArray(int[] nums) {
        System.out.println("\nInput: nums = " + Arrays.toString(nums));

        long start1, end1, runtime1;
        long start2, end2, runtime2;
        int result1, result2;
        double diff;

        start1 = System.nanoTime();
        result1 = maxSubArray(nums);
        end1 = System.nanoTime();

        start2 = System.nanoTime();
        result2 = maxSubArray2(nums);
        end2 = System.nanoTime();

        runtime1 = end1 - start1;
        runtime2 = end2 - start2;

        System.out.println("Output1: " + result1);
        System.out.println("Output2: " + result2);

        System.out.println("Runtime1: " + runtime1 + " ns");
        System.out.println("Runtime2: " + runtime2 + " ns");

        diff = (double) runtime2 / runtime1;

        // Agora quero saber quantas vezes o primeiro foi mais rapido que o segundo
        System.out.printf("O primeiro foi: %.4f vezes mais rapido que o segundo\n%n", diff);
    }
}
