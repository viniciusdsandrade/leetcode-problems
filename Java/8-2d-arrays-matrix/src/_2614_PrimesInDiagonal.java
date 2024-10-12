import java.util.Arrays;

public class _2614_PrimesInDiagonal {

    /*
    2614. Prime In Diagonal
    You are given a 0-indexed two-dimensional integer array nums.

    Return the largest prime number that lies on at least one of the diagonals of nums.
    In case, no prime is present on any of the diagonals, return 0.

    Note that
    An integer is prime if it is greater than 1 and has no positive integer divisors other than 1 and itself.
    An integer val is on one of the diagonals of nums if there exists an integer i for which nums[i][i] = val or an i for which nums[i][nums.length - i - 1] = val.

    In the above diagram, one diagonal is [1,5,9] and another diagonal is [3,5,7].

    Example 1:
    Input: nums = [[1,2,3],[5,6,7],[9,10,11]]
    Output: 11
    Explanation: The numbers 1, 3, 6, 9, and 11 are the only numbers present on at least one of the diagonals. Since 11 is the largest prime, we return 11.

    Example 2:
    Input: nums = [[1,2,3],[5,17,7],[9,11,10]]
    Output: 17
    Explanation: The numbers 1, 3, 9, 10, and 17 are all present on at least one of the diagonals. 17 is the largest prime, so we return 17.

    Constraints:
    1 <= nums.length <= 300
    nums.length == numsi.length
    1 <= nums[i][j] <= 4 x 10^6
     */

    public static void main(String[] args) {
        int[][] nums1 = {
                {1, 2, 3},
                {5, 6, 7},
                {9, 10, 11}
        };
        testDiagonalPrime(nums1);

        int[][] nums2 = {
                {1, 2, 3},
                {5, 17, 7},
                {9, 11, 10}
        };
        testDiagonalPrime(nums2);
    }

    /**
     * Encontra o maior número primo nas diagonais de uma matriz quadrada.
     *
     * @param nums A matriz quadrada de inteiros.
     * @return O maior número primo encontrado nas diagonais da matriz, ou 0 se não houver primos.
     * @throws IllegalArgumentException Se a matriz não for quadrada.
     */
    public static int diagonalPrime(int[][] nums) {
        if (nums.length != nums[0].length) throw new IllegalArgumentException("A matriz deve ser quadrada.");

        int n = nums.length;
        int largestPrime = 0;
        for (int i = 0; i < n; i++) {
            largestPrime = Math.max(largestPrime, checkPrimeAndMax(nums[i][i])); // Verifica o elemento na diagonal principal
            largestPrime = Math.max(largestPrime, checkPrimeAndMax(nums[i][n - i - 1])); // Verifica o elemento na diagonal secundária
        }
        return largestPrime;
    }

    /**
     * Verifica se um número é primo e retorna o número se for, caso contrário, retorna 0.
     *
     * @param num O número a ser verificado.
     * @return O número se for primo, caso contrário, 0.
     */
    private static int checkPrimeAndMax(int num) {
        return isPrime(num) ? num : 0;
    }

    /**
     * Verifica se um número é primo.
     *
     * @param num O número a ser verificado.
     * @return true se o número for primo, false caso contrário.
     */
    public static boolean isPrime(int num) {
        if (num <= 1) return false; // Números menores ou iguais a 1 não são primos
        if (num <= 3) return true; // 2 e 3 são primos
        if (num % 2 == 0 || num % 3 == 0) return false; // Otimização: Verificar divisibilidade por 2 e 3 separadamente

        // Otimização: Verificar divisibilidade apenas por números da forma 6k ± 1
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }

        return true;
    }

    public static void testDiagonalPrime(int[][] nums) {
        System.out.println("Input: nums = " + Arrays.deepToString(nums));

        long start = System.nanoTime();
        int result = diagonalPrime(nums);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (end - start) + " ns");
    }


}
