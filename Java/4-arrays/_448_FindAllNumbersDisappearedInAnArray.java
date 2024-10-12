import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class _448_FindAllNumbersDisappearedInAnArray {

    /*
    448. Find All Numbers Disappeared in an Array

    Given an array nums of n integers where nums[i] is in the range [1, n],
    return an array of all the integers in the range [1, n] that do not appear in nums.

    Example 1:
    Input: nums = [4,3,2,7,8,2,3,1]
    Output: [5,6]

    Example 2:
    Input: nums = [1,1]
    Output: [2]

    Constraints:
    n == nums.length
    1 ≤ n ≤ 10^5
    1 ≤ nums[i] ≤ n

    Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
     */

    public static void main(String[] args) {
        int[] nums1 = {4, 3, 2, 7, 8, 2, 3, 1};
        testFindDisappearedNumbers(nums1);

        int[] nums2 = {1, 1};
        testFindDisappearedNumbers(nums2);
    }

    /**
     * Encontra todos os números desaparecidos em um array de 1 a n.
     * <p>
     * Dado um array de inteiros de comprimento n, onde cada número está no intervalo de 1 a n,
     * esta função identifica os números que estão faltando no array. O array de entrada é modificado
     * diretamente para marcar os números presentes, e os números que permanecem não marcados indicam
     * os que estão faltando.
     * </p>
     * <p>
     * O metodo funciona em O(n) tempo e usa O(1) de espaço adicional, excluindo a lista de resultados retornada.
     * </p>
     *
     * @param nums O array de inteiros de comprimento n, onde cada valor está no intervalo [1, n].
     * @return Uma lista contendo os números que estão desaparecidos no array de entrada.
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();

        int n = nums.length;

        // Etapa 1: Marca a presença dos números ao negativar os índices correspondentes
        for (int i = 0; i < n; i++) {
            int index = abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Etapa 2: Coleta os índices que permanecem positivos, indicando os números ausentes
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static void testFindDisappearedNumbers(int[] nums) {
        System.out.println("Input: nums = " + Arrays.toString(nums));

        List<Integer> result;
        long start, end, time;

        start = System.nanoTime();
        result = findDisappearedNumbers(nums);
        end = System.nanoTime();

        time = end - start;

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + time + " ns");
    }
}
