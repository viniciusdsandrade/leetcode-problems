import java.util.Arrays;

import static java.lang.String.valueOf;
import static java.util.Arrays.sort;

public class _179_LargestNumber {

    /*
    179. Largest Number

    Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

    Since the result may be very large, so you need to return a string instead of an integer.

    Example 1:
    Input: nums = [10,2]
    Output: "210"

    Example 2:
    Input: nums = [3,30,34,5,9]
    Output: "9534330"

    Constraints:
    1 <= nums.length <= 100
    0 <= nums[i] <= 10^9
     */

    public static void main(String[] args) {
        int[] nums1 = {10, 2};
        testLargestNumber(nums1);

        int[] nums2 = {3, 30, 34, 5, 9};
        testLargestNumber(nums2);
    }

    /**
     * Esta função encontra o maior número que pode ser formado rearranjando os dígitos de um array de inteiros.
     *
     * @param nums O array de inteiros de entrada.
     * @return O maior número que pode ser formado rearranjando os dígitos em nums.
     */
    public static String largestNumber(int[] nums) {
        // 1. Converte cada inteiro em uma string.
        // Isso é feito para podermos concatenar os números mais tarde de forma mais eficiente.
        String[] strNums = new String[nums.length];
        StringBuilder answer;

        for (int i = 0; i < nums.length; i++) {
            strNums[i] = valueOf(nums[i]);
        }

        // 2. Ordena o array de strings em ordem decrescente com base em uma regra de comparação personalizada.
        // A regra de comparação personalizada compara duas strings concatenando-as em ambas as ordens (a + b e b + a)
        // e retorna a ordem lexicográfica inversa.
        // Isso garante que a string que produz o maior número quando concatenada com outras strings venha primeiro.
        sort(strNums, (a, b) -> {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        });

        // 3. Se o primeiro elemento do array ordenado for "0", significa que todos os elementos são "0".
        // Nesse caso, retornamos "0" como o maior número.
        if (strNums[0].equals("0")) {
            return "0";
        }

        // 4. Concatena todas as strings no array ordenado em uma única string.
        // Isso produz o maior número que pode ser formado rearranjando os dígitos no array de entrada.
        answer = new StringBuilder();
        for (String strNum : strNums) {
            answer.append(strNum);
        }

        // 5. Retorna o maior número.
        return answer.toString();
    }

    public static void testLargestNumber(int[] nums) {
        System.out.println("\nEntrada: " + Arrays.toString(nums));
        long startTime, endTime, runtime;
        String result;

        startTime = System.nanoTime();
        result = largestNumber(nums);
        endTime = System.nanoTime();

        runtime = endTime - startTime;

        System.out.println("Saída: " + result);
        System.out.println("Tempo de execução: " + runtime + " ns\n");
        System.out.println();
    }
}
