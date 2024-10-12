public class _2652_SumMultiples {

    /*
    2652. Sum Multiples
    Given a positive integer n, find the sum of all integers in the range [1, n]
    inclusive that is divisible by 3, 5, or 7.

    Return an integer denoting the sum of all numbers in the given range satisfying the constraint.

    Example 1:
    Input: n = 7
    Output: 21
    Explanation: Numbers in the range [1, 7] that are divisible by 3, 5, or 7 are 3, 5, 6, 7.
    The sum of these numbers is 21.

    Example 2:
    Input: n = 10
    Output: 40
    Explanation: Numbers in the range [1, 10] that are divisible by 3, 5, or 7 are 3, 5, 6, 7, 9, 10.
    The sum of these numbers is 40.

    Example 3:
    Input: n = 9
    Output: 30
    Explanation: Numbers in the range [1, 9] that are divisible by 3, 5, or 7 are 3, 5, 6, 7, 9.
    The sum of these numbers is 30.

    Constraints:
    1 <= n <= 10^3
     */

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) testSumOfMultiples(i);
    }

    /**
     * Calcula a soma de todos os múltiplos de 3, 5 e 7 até um valor n.
     * Utiliza uma abordagem aritmética para otimizar a desempenho.
     *
     * @param n o valor limite até onde os múltiplos devem ser somados
     * @return a soma de todos os múltiplos de 3, 5 e 7 até n
     */
    public static int sumOfMultiples2(int n) {
        // Soma os múltiplos de 3, 5 e 7
        return sumMultiples2(n, 3) + sumMultiples2(n, 5) + sumMultiples2(n, 7)
                - sumMultiples2(n, 15) - sumMultiples2(n, 21) - sumMultiples2(n, 35) // Subtrai os múltiplos comuns de 3 e 5, 3 e 7, e 5 e 7 para evitar contagem dupla
                + sumMultiples2(n, 105); // Adiciona os múltiplos comuns de 3, 5 e 7 para corrigir a exclusão tripla
    }

    /**
     * Calcula a soma de todos os múltiplos de um dado número k até um valor n.
     *
     * @param n o valor limite até onde os múltiplos devem ser somados
     * @param k o valor cujos múltiplos serão somados
     * @return a soma de todos os múltiplos de k até n
     */
    private static int sumMultiples2(int n, int k) {
        int m = n / k; // Número de múltiplos de k até n
        return k * m * (m + 1) / 2; // Fórmula da soma de uma progressão aritmética
    }

    /**
     * Calcula a soma de todos os múltiplos de 3, 5 e 7 até um valor n.
     * Utiliza uma abordagem iterativa simples.
     *
     * @param n o valor limite até onde os múltiplos devem ser somados
     * @return a soma de todos os múltiplos de 3, 5 e 7 até n
     */
    public static int sumOfMultiples(int n) {
        int sum = 0;
        // Itera por todos os números de 1 até n
        for (int i = 1; i <= n; i++) {
            // Verifica se o número é múltiplo de 3, 5 ou 7
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum += i; // Adiciona o múltiplo à soma
            }
        }
        return sum;
    }


    public static void testSumOfMultiples(int n) {
        System.out.println("Input: n = " + n);

        long start = System.nanoTime();
        int result = sumOfMultiples(n);
        long end = System.nanoTime();

        long start2 = System.nanoTime();
        int result2 = sumOfMultiples2(n);
        long end2 = System.nanoTime();

        long executionTime1 = end - start;
        long executionTime2 = end2 - start2;

        System.out.println("Output1: " + result);
        System.out.println("Output2: " + result2);

        System.out.println("Execution time1: " + executionTime1 + " ns");
        System.out.println("Execution time2: " + executionTime2 + " ns");
    }
}
