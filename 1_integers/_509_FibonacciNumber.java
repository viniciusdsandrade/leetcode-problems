public class _509_FibonacciNumber {

    /*
    509. Fibonacci Number
    The Fibonacci numbers, commonly denoted F(n)
    form a sequence, called the Fibonacci sequence,
    such that each number is the sum of the two preceding
    ones, starting from 0 and 1. That is,

    F(0) = 0, F(1) = 1
    F(n) = F(n - 1) + F(n - 2), for n > 1.
    Given n, calculate F(n).

    Example 1:
    Input: n = 2
    Output: 1
    Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

    Example 2:
    Input: n = 3
    Output: 2
    Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

    Example 3:
    Input: n = 4
    Output: 3
    Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

    Constraints:
    0 <= n <= 30
     */

    public static void main(String[] args) {
        for (int i = 0; i <= 92; i++) {
            testFib(i);
        }
    }

    public static long fib(long n) {
        if (n <= 1) return  n;
        return fib(n - 1) + fib(n - 2);
    }

    public static long fib2(long n) {
        if (n <= 1) {
            System.out.println("Fibonacci de " + n + ": " + n);
            return n;
        }

        long[] fib = new long[(int) (n + 1)];
        fib[0] = 0;
        fib[1] = 1;

        System.out.println("Fibonacci de 0: " + fib[0]);
        System.out.println("Fibonacci de 1: " + fib[1]);

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
            System.out.println("Fibonacci de " + i + ": " + fib[i]);
        }

        return fib[(int) n];
    }

    public static void testFib(int n) {
        System.out.println("==============================================================");
        System.out.println("\nInput: " + n);
        long startTime = System.nanoTime();
        //long answer = fib(n);
        long endTime = System.nanoTime();

        long startTime2 = System.nanoTime();
        long answer2 = fib2(n);
        long endTime2 = System.nanoTime();

        long interval1 = endTime - startTime;
        long interval2 = endTime2 - startTime2;


        System.out.println("Output: " + answer2);
        System.out.printf("Recursive time: %.5f ms\n", interval1 / 1_000_000.0);
        System.out.printf("Iterative time: %.5f ms\n", interval2 / 1_000_000.0);
        System.out.printf("Recursivo/Iterativo: %.3f\n", interval1 / (double) interval2);
        System.out.println("==============================================================");
    }
}