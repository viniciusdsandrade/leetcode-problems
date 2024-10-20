import java.util.Arrays;

public class _238_ProductOfArrayExceptSelf {

    /*
    238. Product of Array Except Self

    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    You must write an algorithm that runs in O(n) time and without using the division operation.

    Example 1:
    Input: nums = [1,2,3,4]
    Output: [24,12,8,6]

    Example 2:
    Input: nums = [-1,1,0,-3,3]
    Output: [0,0,9,0,0]


    Constraints:
    2 <= nums.length <= 10^5
    -30 <= nums[i] <= 30
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.


    Follow up: Can you solve the problem in O(1) extra space complexity?
    (The output array does not count as extra space for space complexity analysis.)
     */

    public static void main(String[] ignoredArgs) {
        int[] nums1 = {1, 2, 3, 4};
        testProductExceptSelf(nums1);

        int[] nums2 = {-1, 1, 0, -3, 3};
        testProductExceptSelf(nums2);
    }

    /**
     * Computes an array such that each element at index `i` of the output is equal to the product
     * of all the elements of the input array except the element at `i`, without using division.
     *
     * <p>Essa função resolve o problema de cálculo de produtos acumulados sem considerar o elemento
     * da posição atual, de forma eficiente, com tempo linear O(n) e sem uso de espaço extra significativo,
     * além do vetor de saída.</p>
     *
     * <p>Ela realiza duas passagens no array: a primeira para calcular os produtos prefixados da esquerda
     * para a direita, e a segunda para calcular os produtos acumulados da direita para a esquerda, multiplicando
     * com o valor já calculado na primeira passagem.</p>
     *
     * @param nums Array de inteiros, onde se deseja calcular o produto acumulado dos outros elementos.
     *             Deve ter pelo menos um elemento, e pode conter valores positivos, negativos ou zero.
     * @return Um array de inteiros onde cada elemento é o produto de todos os outros elementos
     *         do array de entrada, exceto o elemento correspondente.
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length; // Armazena o tamanho do array de entrada
        int[] result = new int[n]; // Cria o array de resultados com o mesmo tamanho que o array de entrada
        result[0] = 1; // Define o primeiro elemento como 1, pois não há elementos à esquerda do primeiro

        // Primeira iteração: Preenche o array de resultados com produtos da esquerda para a direita
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1]; // Cada posição do resultado recebe o produto acumulado até o índice anterior
        }

        int right = 1; // Inicializa uma variável para armazenar o produto acumulado da direita

        // Segunda iteração: Multiplica os produtos acumulados da direita para a esquerda
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= right; // Atualiza o valor do resultado na posição i, multiplicando com o produto acumulado da direita
            right *= nums[i]; // Atualiza o valor acumulado da direita com o valor atual do array de entrada
        }

        // Retorna o array resultante, onde cada posição i contém o produto de todos os outros elementos, exceto nums[i]
        return result;
    }

    public static void testProductExceptSelf(int[] nums) {
        System.out.println("\nInput: nums = " + Arrays.toString(nums));

        long startRuntime, endRuntime, runtime;
        int[] result;

        startRuntime = System.nanoTime();
        result = productExceptSelf(nums);
        endRuntime = System.nanoTime();

        runtime = endRuntime - startRuntime;

        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("Runtime: " + runtime + " ns\n");
    }
}
