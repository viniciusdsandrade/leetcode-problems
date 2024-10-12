import java.util.Arrays;
import java.util.HashMap;

public class _1_TwoSum {
    /*
    1. Two Sum
    
    Given an array of integers nums and an integer target, 
    return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, 
    and you may not use the same element twice.

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
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        int[] nums2 = {3, 2, 4};
        int target2 = 6;

        int[] nums3 = {3, 3};
        int target3 = 6;

        testTwoSum(nums1, target1);
        testTwoSum(nums2, target2);
        testTwoSum(nums3, target3);
    }

    private static void testTwoSum(int[] nums, int target) {
        long startTime = System.nanoTime();
        int[] result = twoSum(nums, target);
        long endTime = System.nanoTime();

        System.out.println("\nInput:  " + Arrays.toString(nums));
        System.out.println("Target:  " + target);
        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
        System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1_000_000.0);
    }

    public static int[] twoSum(int[] nums, int target) {
        // Inicializa um array para armazenar os índices dos dois números que somam o target
        int[] result = new int[2];

        // Cria um HashMap para armazenar os números do array e seus índices
        HashMap<Integer, Integer> map = new HashMap<>();

        // Itera sobre o array
        for (int i = 0; i < nums.length; i++) {
            // Calcula o complemento necessário para atingir o target
            int complement = target - nums[i];

            // Verifica se o complemento está presente no HashMap
            if (map.containsKey(complement)) {
                // Se sim, encontramos dois números cuja soma é igual ao target
                // Armazena os índices dos dois números no array result
                result[0] = map.get(complement); // Índice do primeiro número
                result[1] = i; // Índice do segundo número
                return result; // Retorna o array result com os índices
            }

            // Se o complemento não está no HashMap, adiciona o número atual e seu índice ao HashMap
            map.put(nums[i], i);
        }

        // Retorna o array result com os valores padrão [0, 0] se nenhum par for encontrado
        return result;
    }
}