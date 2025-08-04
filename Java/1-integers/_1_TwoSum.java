import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.lang.System.nanoTime;

public class _1_TwoSum {
    /*
    1. Two Sum
    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.

    Example 1:
    Input: nums = [2,7,11,15], target = 9
    Output: [0,1]
    Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

    Example 2:
    Input: nums = [3,2,4], target = 6
    Output: [1,2]

    Example 3:
    Input: nums = [3,3], target = 6
    Output: [0,1]


    Constraints:
    2 <= nums.length <= 10^4
    -10^9 <= nums[i] <= 10^9
    -10^9 <= target <= 10^9
    Only one valid answer exists.


    Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
     */

    public static void main(String[] args) {
//        int[] nums1 = {2, 7, 11, 15};
//        int target1 = 9;
//        testTwoSum(nums1, target1);
//
//        int[] nums2 = {3, 2, 4};
//        int target2 = 6;
//        testTwoSum(nums2, target2);
//
//        int[] nums3 = {3, 3};
//        int target3 = 6;
//        testTwoSum(nums3, target3);

        int[] nums4 = {2, 7, 11, 15};
        int target4 = 9;
        testTwoSumVerbose(nums4, target4);

        int[] nums5 = {3, 2, 4};
        int target5 = 6;
        testTwoSumVerbose(nums5, target5);

        int[] nums6 = {3, 3};
        int target6 = 6;
        testTwoSumVerbose(nums6, target6);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                result[0] = map.get(diff);
                result[1] = i;
                return result;
            }
            map.put(nums[i], i);
        }

        return result;

        // Primeiro, criamos um array de inteiros com 2 posições(result)
        // e um mapa para armazenar os números e seus índices.

        // Para concluir o problema em complexidade O(n), percorremos o array nums uma vez.
        // Para cada número no vetor passado como parâmetro, calculamos a diferença entre o target e o número atual (diff = target - nums[i]).
        // em seguida verificamos se essa diferença já existe no mapa.
        // Em caso positivo, significa que encontramos dois números que somam o target.
        // Nesse caso, armazenamos o valor e seu indice no array result respectivamente e retornarmos "result".
        // Caso contrário, adicionamos o número atual e seu índice na variável map.
    }

    public static int[] twoSumVerbose(int[] nums, int target) {
        // Array de resultado
        int[] result = new int[2];
        // Mapa de valor -> índice
        Map<Integer, Integer> map = new HashMap<>();

        System.out.println("Iniciando twoSumVerbose com target = " + target);
        System.out.println("Entrada nums: " + Arrays.toString(nums));
        System.out.println("--------------------------------------------------");

        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int diff = target - current;

            // Imprime estado atual
            System.out.println("Iteração i = " + i);
            System.out.println("  current = nums[" + i + "] = " + current);
            System.out.println("  diff = target (" + target + ") - current (" + current + ") = " + diff);
            System.out.println("  Mapa antes de containsKey: " + map);

            // Verifica se já vimos o complemento
            if (map.containsKey(diff)) {
                int j = map.get(diff);
                result[0] = j;
                result[1] = i;
                System.out.println("  → PAR ENCONTRADO!");
                System.out.println("    nums[" + j + "] = " + diff + " + nums[" + i + "] = " + current + " = " + target);
                System.out.println("  Retornando resultado: [" + j + ", " + i + "]");
                return result;
            }

            // Registra o número atual no mapa
            map.put(current, i);
            System.out.println("  Mapa após put(" + current + ", " + i + "): " + map);
            System.out.println("--------------------------------------------------");
        }

        // Caso não encontre, imprime vazio (mas pelo problema sempre existe um par)
        System.out.println("Nenhum par encontrado que some a " + target);
        return result;
    }

    public static void testTwoSum(int[] nums, int target) {
        System.out.println("\nInput: nums = " + Arrays.toString(nums) + ", target = " + target);

        long startTime, endTime, executionTime;
        int[] result;

        startTime = nanoTime();
        result = twoSum(nums, target);
        endTime = nanoTime();

        executionTime = endTime - startTime;

        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("Execution time: " + executionTime + " ns\n");
    }

    public static void testTwoSumVerbose(int[] nums, int target) {
        System.out.println("\nInput: nums = " + Arrays.toString(nums) + ", target = " + target);

        long startTime, endTime, executionTime;
        int[] result;

        startTime = nanoTime();
        result = twoSumVerbose(nums, target);
        endTime = nanoTime();

        executionTime = endTime - startTime;

        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("Execution time: " + executionTime + " ns\n");
    }
}
