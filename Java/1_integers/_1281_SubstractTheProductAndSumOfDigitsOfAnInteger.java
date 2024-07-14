public class _1281_SubstractTheProductAndSumOfDigitsOfAnInteger {

    /*
    1281. Subtract the Product and Sum of Digits of an Integer
    Given an integer number n, return the difference between the product of its digits and the sum of its digits.

    Example 1:
    Input: n = 234
    Output: 15
    Explanation:
    Product of digits = 2 * 3 * 4 = 24
    Sum of digits = 2 + 3 + 4 = 9
    Result = 24-9 = 15

    Example 2:
    Input: n = 4421
    Output: 21
    Explanation:
    Product of digits = 4 * 4 * 2 * 1 = 32
    Sum of digits = 4 + 4 + 2 + 1 = 11
    Result = 32-11 = 21

    Constraints:
    1 <= n <= 10^5
     */

    public static void main(String[] args) {
        testSubtractProductAndSum(234);
        testSubtractProductAndSum(4421);
    }

    /**
     * Calcula a diferença entre o produto e a soma dos dígitos de um número inteiro.
     *
     * <p>
     * Esta função recebe um número inteiro positivo, calcula o produto de seus dígitos,
     * calcula a soma de seus dígitos e então retorna a diferença entre esses dois valores.
     * </p>
     *
     * @param n o número inteiro positivo cujo produto e soma dos dígitos serão calculados
     * @return a diferença entre o produto e a soma dos dígitos de n
     */
    public static int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;

        // Loop para iterar sobre cada dígito do número
        while (n > 0) {
            int digit = n % 10;
            product = product * digit;
            sum = sum + digit;
            n = n / 10;
        }

        // Retorna a diferença entre o produto e a soma dos dígitos
        return product - sum;
    }

    public static void testSubtractProductAndSum(int n) {
        System.out.println("Input: n = " + n);

        long startTime = System.nanoTime();
        int result = subtractProductAndSum(n);
        long endTime = System.nanoTime();

        long runtime = endTime - startTime;

        System.out.println("Output: " + result);
        System.out.println("Execution time: " + runtime + "ns");
    }
}
