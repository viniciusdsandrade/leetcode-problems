public class _231_PowerOfTwo {

    /*
    231. Power of Two
    Given an integer n,
    return true if it is a power of two.
    Otherwise, return false.

    An integer n is a power of two, if there exists an integer x such that n == 2x.

    Example 1:
    Input: n = 1
    Output: true
    Explanation: 20 = 1

    Example 2:
    Input: n = 16
    Output: true
    Explanation: 24 = 16

    Example 3:
    Input: n = 3
    Output: false

    Constraints:
    -2^31 <= n <= 2^31 - 1
     */

    public static void main(String[] args) {

        for (int i = (int) -Math.pow(2, 31); i < Math.pow(2, 31) - 1; i++) {
            testIsPowerOfTwo(i);
        }
    }

    public static boolean isPowerOfTwo(int n) {

        if (n <= 0) return false;

        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    private static void testIsPowerOfTwo(int i) {
        System.out.printf("Input: %d\n", i);
        long startTime = System.nanoTime();
        boolean answer = isPowerOfTwo(i);
        long endTime = System.nanoTime();
        System.out.printf("Answer: %b\n", answer);
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
        System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1000000.0);


    }


}
