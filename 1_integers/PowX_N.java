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

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a base: ");
            double x = scanner.nextDouble();

            System.out.print("Enter an exponent: ");
            int n = scanner.nextInt();
            
            long startTime = System.nanoTime();

            double answer = myPow(x, n);
            
            long endTime = System.nanoTime();

            System.out.printf("Answer: %.5f\n", answer);
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
            System.out.println("Execution time: " + (endTime - startTime) / 1000000 + " ms");
        }
    }

    public static double myPow(double x, int n) {

        return Math.pow(x, n);
    }
}

