public class _1780_CheckIfNumberIsASumOfPowersOfThree {

    /*
    1780. Check if the Number is a Sum of Powers of Three

    Given an integer n, return is true if it is possible to represent n as the sum of distinct powers of three.
    Otherwise, return false.

    An integer y is a power of three if there exists an integer x such that y == 3x.

    Example 1:
    Input: n = 12
    Output: true
    Explanation: 12 = 3^1 + 3^2

    Example 2:
    Input: n = 91
    Output: true
    Explanation: 91 = 3^0 + 3^2 + 3^4

    Example 3:
    Input: n = 21
    Output: false

    Constraints:
    1 <= n <= 10^7
     */

    public static void main(String[] args) {
        testCheckPowersOfThree(12);
        testCheckPowersOfThree(91);
        testCheckPowersOfThree(21);
    }

        /**
         * Verifica se um determinado inteiro pode ser representado como uma soma de potências distintas de 3.
         *<p>
         * Este metodo aproveita as propriedades da representação ternária (base-3). Qualquer número que pode ser formado
         * usando potências únicas de 3 não terá resto 2 quando dividido por 3. Isso ocorre porque:
         * - Potências de 3 (1, 3, 9, 27...) sempre deixam resto 1 quando divididas por 3.
         * - Usar uma potência de 3 duas vezes exigiria um "2" em sua representação ternária.
         *</p>
         * @param n O inteiro a ser verificado.
         * @return {@code true} se o inteiro puder ser representado como uma soma de potências distintas de 3,
         *         {@code false} caso contrário.
         */
        public static boolean checkPowersOfThree(int n) {
            // Itera enquanto n for maior que 0.
            while (n > 0) {
                if (n % 3 == 2)
                    return false;
                n = n / 3;
            }

            return true;
        }

    public static void testCheckPowersOfThree(int n) {
        System.out.println("\nInput: n = " + n);

        long startTime = System.nanoTime();
        boolean result = checkPowersOfThree(n);
        long endTime = System.nanoTime();

        System.out.println("Output:  " + result);
        System.out.println("Runtime: " + (endTime - startTime) + " ns");
    }
}
