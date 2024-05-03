import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _288_Summary_Ranges {
    /*
    228. Summary Ranges

    You are given a sorted unique integer array nums.
    A range [a,b] is the set of all integers from a to b (inclusive).
    Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
    That is, each element of nums is covered by exactly one of the ranges,
    and there is no integer x such that x is in one of the ranges but not in nums.

    Each range [a,b] in the list should be output as:
    "a->b" if a != b
    "a" if a == b

    Example 1:
    Input: nums = [0,1,2,4,5,7]
    Output: ["0->2","4->5","7"]
    Explanation: The ranges are:
    [0,2] --> "0->2"
    [4,5] --> "4->5"
    [7,7] --> "7"

    Example 2:
    Input: nums = [0,2,3,4,6,8,9]
    Output: ["0","2->4","6","8->9"]
    Explanation: The ranges are:
    [0,0] --> "0"
    [2,4] --> "2->4"
    [6,6] --> "6"
    [8,9] --> "8->9"

    Constraints:
    0 <= nums.length <= 20
    -2^31 <= nums[i] <= 2^31 - 1
    All the values of nums are unique.
    nums is sorted in ascending order.
     */

    public static void main(String[] args) {

        int[] nums1 = {0, 1, 2, 4, 5, 7};
        testSummaryRanges(nums1);

        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        testSummaryRanges(nums2);
    }

    /**
     * Dada uma matriz de inteiros ordenados sem duplicatas, esta função retorna uma lista de intervalos que representam todos os intervalos contíguos na matriz.
     * <p>
     * Por exemplo:
     * summaryRanges([0,1,2,4,5,7]) retorna ["0→2","4→5","7"]
     * summaryRanges([0,2,3,4,6,8,9]) retorna ["0","2→4","6","8→9"]
     *
     * @param nums A matriz ordenada de inteiros sem duplicatas
     * @return A lista de intervalos que representam todos os intervalos contíguos na matriz
     * @throws IllegalArgumentException se a matriz de entrada for nula
     */
    public static List<String> summaryRanges(int[] nums) {
        if (nums == null) throw new IllegalArgumentException("A matriz de entrada não pode ser nula.");
        if (nums.length == 0) return List.of(); // Retorna uma lista vazia se a matriz estiver vazia

        List<String> result = new ArrayList<>(); // Inicializa a lista de resultados
        int start = nums[0]; // Inicializa o início do intervalo atual
        int end = nums[0]; // Inicializa o fim do intervalo atual

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != end + 1) { // Verifica se o intervalo atual termina
                if (start == end)
                    result.add(String.valueOf(start)); // Adiciona um único número como uma string
                else
                    result.add(start + "->" + end); // Adiciona o intervalo como uma string "início→fim"
                start = nums[i]; // Inicia um novo intervalo
            }
            end = nums[i]; // Estende o intervalo atual
        }

        // Adiciona o último intervalo
        if (start == end)
            result.add(String.valueOf(start));
        else
            result.add(start + "->" + end);

        return result;
    }

    public static void testSummaryRanges(int[] nums) {
        System.out.println("Input: nums = " + Arrays.toString(nums));

        long startTime = System.nanoTime();
        List<String> result = summaryRanges(nums);
        long endTime = System.nanoTime();

        long executionTime = (endTime - startTime);

        System.out.println("Output: " + result);
        System.out.println("Execution time: " + executionTime + " ns");
    }
}
