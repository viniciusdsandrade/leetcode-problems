public class _1837_SumOfDigitsInBaseK {

    /*
    1837. Sum of Digits in Base K
    Given an integer n (in base 10) and a base k,
    return the sum of the digits of n after converting n from base 10 to base k.

    After converting, each digit should be interpreted as a base 10 number,
    and the sum should be returned in base 10.

    Example 1:
    Input: n = 34, k = 6
    Output: 9
    Explanation: 34 (base 10) expressed in base 6 is 54. 5 + 4 = 9.

    Example 2:
    Input: n = 10, k = 10
    Output: 1
    Explanation: n is already in base 10. 1 + 0 = 1.

    Constraints:
    1 <= n <= 100
    2 <= k <= 10
     */

    public static void main(String[] args) {
        int n1 = 34;
        int k1 = 6;
        testSumBase(n1, k1);

        int n2 = 10;
        int k2 = 10;
        testSumBase(n2, k2);
    }

    /**
     * Calcula a soma dos dígitos de um número n quando convertido para uma base k.
     *
     * @param n o número a ser convertido para a base k
     * @param k a base para a qual o número será convertido
     * @return a soma dos dígitos de n na base k
     */
    public static int sumBase(int n, int k) {
        int sum = 0;  // Variável para armazenar a soma dos dígitos

        // Loop para converter n para a base k e somar os dígitos resultantes
        while (n > 0) {
            sum = sum + n % k;  // Adiciona o dígito menos significativo de n na base k à soma
            n = n / k;          // Atualiza n para remover o dígito menos significativo
        }

        return sum;  // Retorna a soma dos dígitos de n na base k
    }

    public static void testSumBase(int n, int k) {
        System.out.println("Input: n = " + n + ", k = " + k);

        long startTime = System.nanoTime();
        int result = sumBase(n, k);
        long endTime = System.nanoTime();

        System.out.println("Output:         " + result);
        System.out.println("Execution time: " + (endTime - startTime) + "ns");
    }
}
