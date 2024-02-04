public class _172_FactorialTrailingZeroes {
    /*
    172. Given an integer n, return the number of trailing zeroes in n!.

    Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.

    Example 1:
    Input: n = 3
    Output: 0
    Explanation: 3! = 6, no trailing zero.

    Example 2:
    Input: n = 5
    Output: 1
    Explanation: 5! = 120, one trailing zero.

    Example 3:
    Input: n = 0
    Output: 0

     Constraints:
     0 <= n <= 10^4
    */
    
    public static void main(String[] args) {
        for (int i = 0; i <= 1000; i++) {
            testTrailingZeroes(i);
        }
    }

    private static void testTrailingZeroes(int input) {
        try {

            long startTime = System.nanoTime();
            int actualOutput = trailingZeroes(input);
            long endTime = System.nanoTime();

            System.out.println("\nInput:  " + input);
            System.out.println("Output: " + actualOutput);
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
            System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1000000.0);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int trailingZeroes(int n) {

        if (n < 5)
            return 0;

        int zeros = 0;

        while (n >= 5) {
            zeros += n / 5;
            n /= 5;
        }

        return zeros;
    }
}