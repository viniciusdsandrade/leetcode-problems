import java.util.stream.IntStream;

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
        IntStream.range(2, 200).forEach(_2413_SmallestEvenMultiple::testSmallestEvenMultiple);
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

    public static void testSmallestEvenMultiple(int n) {
        System.out.println("Input: n = " + n);

        long start = System.nanoTime();
        int result = smallestEvenMultiple(n);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution time: " + (end - start) + " ns");
    }
}
