import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.nanoTime;
import static java.util.Arrays.asList;
import static java.util.Arrays.copyOfRange;

public class _26_remove_duplicates_from_sorted_array {

    /*
    26. Remove Duplicates from Sorted Array

    Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

    Consider the number of unique elements of nums to be k, to get accepted. You need to do the following things:

    Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    Return k.
    Custom Judge:

    The judge will test your solution with the following code:

    int[] nums = [...]; // Input array
    int[] expectedNums = [...]; // The expected answer with correct length

    int k = removeDuplicates(nums); // Calls your implementation

    assert k == expectedNums.length;

    for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
    }

    If all assertions pass, then your solution will be accepted.


    Example 1:
    Input: nums = [1,1,2]
    Output: 2, nums = [1,2,_]
    Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).

    Example 2:
    Input: nums = [0,0,1,1,1,2,2,3,3,4]
    Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
    It does not matter what you leave beyond the returned k (hence they are underscores).

    Constraints:
    1 <= nums.length <= 3 * 10^4
    -100 <= nums[i] <= 100
    nums is sorted in non-decreasing order.
     */

    public static void main(String[] ignoredArgs) {
        int[] nums1 = new int[]{1, 1, 2};
        int[] nums2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        testRemoveDuplicates(nums1);
        testRemoveDuplicates(nums2);

        // Initialize the list as a mutable ArrayList
        List<Integer> nums3 = new ArrayList<>(asList(1, 2, 2));
        testRemoveDuplicates2(nums3);

        List<Integer> nums4 = new ArrayList<>(asList(0, 1, 2, 2, 2, 3, 3, 3, 4, 4));
        testRemoveDuplicates2(nums4);
    }

    /**
     * Remove os elementos duplicados de um array de inteiros ordenado em ordem não decrescente.
     * <p>
     * Este metodo modifica o array {@code nums} in-place, garantindo que cada elemento apareça apenas uma vez.
     * Retorna o novo comprimento do array após a remoção dos duplicados.
     * </p>
     *
     * <h2>Exemplos</h2>
     * <ul>
     *     <li>
     *         <strong>Entrada:</strong> nums = [1, 1, 2]<br>
     *         <strong>Saída:</strong> 2, nums = [1, 2, _]
     *     </li>
     *     <li>
     *         <strong>Entrada:</strong> nums = [0,0,1,1,1,2,2,3,3,4]<br>
     *         <strong>Saída:</strong> 5, nums = [0, 1, 2, 3, 4, _, _, _, _, _]
     *     </li>
     * </ul>
     *
     * <h2>Complexidade</h2>
     * <ul>
     *     <li><strong>Tempo:</strong> O(n), onde n é o número de elementos em {@code nums}.</li>
     *     <li><strong>Espaço:</strong> O(1), pois utiliza espaço constante adicional.</li>
     * </ul>
     *
     * @param nums Um array de inteiros ordenado em ordem não decrescente.
     * @return O novo comprimento do array após a remoção dos elementos duplicados.
     * @throws NullPointerException se {@code nums} for {@code null}.
     * @implNote Este metodo assume que o array {@code nums} está ordenado.
     */
    public static int removeDuplicates(int[] nums) {
        int n = nums.length; // Obtém o comprimento do array
        if (n == 0) return 0; // Se o array estiver vazio, retorna 0
        int i = 0; // Ponteiro para o último elemento único encontrado

        // Itera através do array a partir do segundo elemento
        for (int j = 1; j < n; j++) {
            // Se o elemento atual for diferente do último único encontrado
            if (nums[j] != nums[i]) {
                i++; // Avança o ponteiro dos únicos
                nums[i] = nums[j]; // Atualiza o próximo elemento único
            }
        }

        // Retorna o número de elementos únicos
        return i + 1;
    }

    public static void testRemoveDuplicates(int[] nums) {
        long start, end, executionTime;
        int result;
        int[] nums2;

        start = nanoTime();
        result = removeDuplicates(nums);
        end = nanoTime();

        nums2 = copyOfRange(nums, 0, result);

        executionTime = end - start;

        System.out.println("Input: nums =   " + Arrays.toString(nums));
        System.out.println("Output:         " + result + ", nums = " + Arrays.toString(nums2));
        System.out.println("Execution time: " + executionTime + " ns");
    }

    /**
     * Remove os elementos duplicados de uma lista de inteiros, mantendo apenas os elementos únicos.
     * <p>
     * Este metodo cria uma cópia mutável da lista de entrada {@code nums} e remove os elementos duplicados
     * de forma que cada elemento apareça apenas uma vez. A ordem dos elementos é preservada.
     * </p>
     *
     * <h2>Exemplos</h2>
     * <ul>
     *     <li>
     *         <strong>Entrada:</strong> nums = [1, 2, 2]<br>
     *         <strong>Saída:</strong> [1, 2]
     *     </li>
     *     <li>
     *         <strong>Entrada:</strong> nums = [0, 1, 2, 3, 4, 2, 2, 3, 3, 4]<br>
     *         <strong>Saída:</strong> [0, 1, 2, 3, 4]
     *     </li>
     * </ul>
     *
     * <h2>Complexidade</h2>
     * <ul>
     *     <li><strong>Tempo:</strong> O(n²) no pior caso, onde n é o número de elementos na lista {@code nums}, devido à operação de remoção.</li>
     *     <li><strong>Espaço:</strong> O(n), pois é criada uma cópia mutável da lista de entrada.</li>
     * </ul>
     *
     * @param nums Uma lista de inteiros que pode conter elementos duplicados. A ordem dos elementos não é necessariamente ordenada.
     * @return Uma nova lista de inteiros sem elementos duplicados, mantendo a ordem original dos elementos.
     * @throws NullPointerException se a lista {@code nums} for {@code null}.
     * @implNote Este metodo cria uma cópia mutável da lista de entrada para evitar modificar a lista original.
     */
    public static List<Integer> removeDuplicates2(List<Integer> nums) {
        List<Integer> mutableNums = new ArrayList<>(nums); // Cria uma cópia mutável da lista de entrada para permitir modificações

        int n = mutableNums.size(); // Obtém o tamanho da lista mutável
        if (n == 0) return mutableNums; // Retorna a lista vazia se não houver elementos


        int i = 0; // Ponteiro para rastrear a posição atual na lista

        // Itera pela lista até o penúltimo elemento
        while (i < n - 1) {
            // Compara o elemento atual com o próximo elemento
            if (mutableNums.get(i).equals(mutableNums.get(i + 1))) {
                mutableNums.remove(i + 1); // Remove o elemento duplicado
                n--; // Decrementa o tamanho da lista após a remoção
            } else {
                i++; // Avança para o próximo elemento se não houver duplicata
            }
        }

        // Retorna a lista sem duplicatas
        return mutableNums;
    }

    public static void testRemoveDuplicates2(List<Integer> nums) {
        long start, end, executionTime;
        List<Integer> result2;

        start = nanoTime();
        result2 = removeDuplicates2(nums);
        end = nanoTime();

        executionTime = end - start;

        System.out.println("Input: nums =   " + nums);
        System.out.println("Output:         " + result2);
        System.out.println("Execution time: " + executionTime + " ns");
    }
}
