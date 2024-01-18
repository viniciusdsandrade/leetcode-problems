public class _2427_NumberOfCommonFactors {

    /*
    2427. Number of Common Factors
    Given two positive integers a and b, 
    return the number of common factors of a and b.

    An integer x is a common factor of a and b if x divides both a and b.
    
    Example 1:
    Input: a = 12, b = 6
    Output: 4
    Explanation: The common factors of 12 and 6 are 1, 2, 3, 6.
    
    Example 2:
    Input: a = 25, b = 30
    Output: 2
    Explanation: The common factors of 25 and 30 are 1, 5.
     
    Constraints:
    1 <= a, b <= 1000
     */

    public static void main(String[] args) {
        testCommonFactors(12, 6);
        testCommonFactors(25, 30);
        testCommonFactors(100, 100);
    }

    public static int commonFactors(int a, int b) {
        if (a < 1 || b < 1 || a > 1000 || b > 1000) return 0;

        int commonFactors = 0;
        int min;

        if (a < b)
            min = a;
        else
            min = b;

        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) commonFactors++;
        }

        return commonFactors;
    }

    public static void testCommonFactors(int a, int b) {
        System.out.println("\nInput: a = " + a + ", b = " + b);

        long startTime = System.nanoTime();
        int answer = commonFactors(a, b);
        long endTime = System.nanoTime();

        System.out.println("Answer: " + answer);
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
        System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1_000_000.0);
    }
}