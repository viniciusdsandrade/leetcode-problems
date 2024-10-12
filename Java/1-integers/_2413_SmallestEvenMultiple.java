public class _2413_SmallestEvenMultiple {

    /*
    2413. Smallest Even Multiple
    Given a positive integer n, returns the smallest positive integer that is a multiple of both 2 and n.

    Example 1:
    Input: n = 5
    Output: 10
    Explanation: The smallest multiple of both 5 and 2 is 10.

    Example 2:
    Input: n = 6
    Output: 6
    Explanation: The smallest multiple of both 6 and 2 is 6. Note that a number is a multiple of itself.

    Constraints:
    1 <= n <= 150
     */

    // MMC: Mínimo Múltiplo Comum
    public static void main(String[] args) {
        for (int i = 2; i < 200; i++)
            testSmallestEvenMultiple(i);

        for (int i = 2; i < 200; i++){
            for (int j = 2; j < 200; j++){
                System.out.println("MMC(" + i + ", " + j + ") = " + mmc(i, j));
            }
        }
    }

    /**
     * Retorna o menor múltiplo par do inteiro fornecido.
     * <p>
     * Se o inteiro for par, a função retorna o próprio inteiro.
     * Se o inteiro for ímpar, a função retorna o inteiro multiplicado por 2.
     *
     * @param n o inteiro para o qual se deseja encontrar o menor múltiplo par
     * @return o menor múltiplo par do inteiro fornecido
     */
    public static int smallestEvenMultiple(int n) {
        return (n % 2 == 0) ? n : 2 * n;
    }

    /**
     * Calcula o mínimo múltiplo comum (MMC) de dois inteiros.
     * <p>
     * O MMC é calculado usando a fórmula: (a * b) / MDC(a, b)
     * onde o MDC é calculado usando o algoritmo de Euclides.
     *
     * @param a o primeiro inteiro
     * @param b o segundo inteiro
     * @return o mínimo múltiplo comum dos dois inteiros fornecidos
     */
    public static int mmc(int a, int b) {
        if (a == 0 || b == 0) return 0;
        return (a * b) / mdc(a, b);
    }

    public static int mdc(int a, int b) {
        if (b == 0) return a;
        return mdc(b, a % b);
    }

    public static void testSmallestEvenMultiple(int n) {
        System.out.println("Input: n = " + n);

        long start = System.nanoTime();
        int result = smallestEvenMultiple(n);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution time: " + (end - start) + " ns");
    }
}
