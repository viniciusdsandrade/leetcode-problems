import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.sort;

public class _47_Permutations_II {

    /*
    47. Permutations II

    Given a collection of numbers, nums, that might contain duplicates,
    return all possible unique permutations in any order.

    Example 1:
    Input: nums = [1,1,2]
    Output:
    [[1,1,2],
     [1,2,1],
     [2,1,1]]

    Example 2:
    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


    Constraints:
    1 <= nums.length <= 8
    -10 <= nums[i] <= 10
     */

    public static void main(String[] args) {
        int[] nums0 = {1, 2};
        testPermuteUnique(nums0);

        int[] nums1 = {1, 1, 2};
        testPermuteUnique(nums1);

        int[] nums2 = {1, 2, 3};
        testPermuteUnique(nums2);

        int[] nums3 = {1, 1, 1, 2};
        testPermuteUnique(nums3);

        int[] nums4 = {1, 1, 1, 1, 1, 1, 2};
        testPermuteUnique(nums4);
    }

    /**
     * Gera todas as permutações únicas de um array de inteiros, incluindo casos onde os elementos podem ser repetidos.
     * <p>
     * Esta função utiliza um algoritmo de backtracking para garantir que todas as permutações possíveis de um array de
     * inteiros sejam geradas, evitando duplicatas. O array de entrada pode conter números repetidos e, por isso,
     * as permutações são geradas de forma única.
     *
     * @param nums Array de inteiros a partir do qual as permutações serão geradas.
     * @return Uma lista contendo todas as permutações únicas possíveis do array de inteiros.
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        // Lista para armazenar todas as permutações únicas.
        List<List<Integer>> result = new ArrayList<>();

        // Ordena o array para garantir que elementos iguais fiquem próximos.
        // Isso facilita a verificação de duplicatas durante o processo de backtracking.
        sort(nums);

        // Chama o metodo backtrack para iniciar o processo de permutação.
        // A lista temporária vai armazenar uma permutação de cada vez, e o array booleano 'used'
        // serve para marcar quais elementos já foram utilizados na permutação atual.
        backtrack(result, new ArrayList<>(), nums, new boolean[nums.length]);

        // Retorna a lista com todas as permutações únicas.
        return result;
    }

    /**
     * Função auxiliar que utiliza o algoritmo de backtracking para gerar permutações.
     *
     * @param result   Lista de listas que armazena todas as permutações geradas.
     * @param tempList Lista temporária que armazena a permutação atual durante o processo de backtracking.
     * @param nums     Array de inteiros com os elementos a serem permutados.
     * @param used     Array booleano que marca quais elementos de nums já foram utilizados na permutação atual.
     */
    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        // Caso a lista temporária tenha o mesmo tamanho que o array de entrada, significa que uma permutação
        // completa foi gerada. Assim, essa permutação é adicionada ao resultado final.
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
        } else {
            // Itera sobre o array nums para tentar adicionar cada elemento na permutação atual.
            for (int i = 0; i < nums.length; i++) {
                // Evita reutilizar um número que já foi adicionado na permutação atual.
                // Além disso, evita gerar permutações duplicadas verificando se o número é igual ao anterior
                // e se o anterior ainda não foi utilizado.
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;  // Pula para o próximo número.
                }

                // Marca o elemento como utilizado.
                used[i] = true;

                // Adiciona o número atual na permutação temporária.
                tempList.add(nums[i]);

                // Recursivamente chama o backtrack para preencher o próximo número da permutação.
                backtrack(result, tempList, nums, used);

                // Após a chamada recursiva, desfaz a última escolha (backtracking), permitindo que o algoritmo
                // explore outras combinações.
                used[i] = false;

                // Remove o último número adicionado na permutação temporária para tentar outro número.
                tempList.removeLast();  // Usando tempList.size() - 1 para acessar o último elemento.
            }
        }
    }

    public static void testPermuteUnique(int[] nums) {
        System.out.println("Input: nums = " + Arrays.toString(nums));

        List<List<Integer>> result;
        long startTime, endTime, runtime;

        startTime = System.nanoTime();
        result = permuteUnique(nums);
        endTime = System.nanoTime();

        runtime = (endTime - startTime);

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + runtime + " ns\n");
    }
}
