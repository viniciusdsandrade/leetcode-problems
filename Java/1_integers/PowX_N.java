import java.util.Scanner;

public class PowX_N {

    /*
    * Implement pow(x,n) which calculates x raised to power n (i.e., xn).
    * 
    * Example 1:
    * Input: x = 2.00000, n = 10
    * Output: 1024.00000
    * 
    * Example 2:
    * Input: x = 2.10000, n = 3
    * Output: 9.26100
    * 
    * Example 3:
    * Input: x = 2.00000, n = -2
    * Output: 0.25000
    */

    public static void main(String[] args) {
            double[] bases = {2.0, 2.1, 2.0};
            int[] exponents = {10, 3, -2};
            runTests(bases, exponents);
    }

    private static void runTests(double[] bases, int[] exponents) {
        for (int i = 0; i < bases.length; i++) {
            double x = bases[i];
            int n = exponents[i];

            long startTime = System.nanoTime();
            double answer = myPow(x, n);
            long endTime = System.nanoTime();
            try {
                printResult(x, n, answer, startTime, endTime);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());            
            }
        }
    }

    private static void printResult(double x, int n, double answer, long startTime, long endTime) {
        System.out.printf("Input: x = %.5f, n = %d\n", x, n);
        System.out.printf("Answer: %.5f\n", answer);
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
        System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1000000.0);
    }

    public static double myPow(double x, int n) {
        return Math.pow(x, n);
    }
}