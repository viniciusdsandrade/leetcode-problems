import java.util.Scanner;

public class FactorialTrailingZeroes {
    /*
    * Given an integer n, return the number of trailing zeroes in n!.

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
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int n = scanner.nextInt();

            long startTime = System.nanoTime();
            int answer = trailingZeroes(n);
            long endTime = System.nanoTime();

            System.out.println("Input:  " + n);
            System.out.println("Output: " + answer);
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
            System.out.println("Execution time: " + (endTime - startTime) / 1000000 + " ms");
        }
    }
    //13! = 6227020800
    //12! = 479001600

    public static int trailingZeroes(int n) {

        if (n < 5)
            return 0;

        int zeros = 0;

        for (int i = 5; i <= n; i += 5) {
            int num = i;
            while (num % 5 == 0) {
                zeros++;
                num /= 5;
            }
        }

        return zeros;
    }
}