public class _342_PowerOfFour {

    /*
    342. Power of Four
    
    Given an integer n, return true if it is a power of four. 
    Otherwise, return false.
    An integer n is a power of four, if there exists an integer x such that n == 4x.

    Example 1:
    Input: n = 16
    Output: true

    Example 2:
    Input: n = 5
    Output: false

    Example 3:
    Input: n = 1
    Output: true
 

    Constraints:
    -2^31 <= n <= 2^31 - 1
     
    Follow up: Could you solve it without loops/recursion?
     */
    public static void main(String[] args) {
        
        testIsPowerOfFour(16);
        testIsPowerOfFour(5);
        testIsPowerOfFour(1);
        testIsPowerOfFour(0);
        testIsPowerOfFour(-2147483648);
        testIsPowerOfFour(2147483647);
        testIsPowerOfFour(1073741824);
    }

    public static boolean isPowerOfFour(int n) {
        //Valores negativos são inválidos
        if (n <= 0) return false;
        
        while (n > 1) {
            if (n % 4 != 0) return false;
            n /= 4;
        }
        
        return true;
    }
    
    public static void testIsPowerOfFour(int n) {
        try {
            long startTime = System.nanoTime();
            boolean answer = isPowerOfFour(n);
            long endTime = System.nanoTime();
            
            System.out.println("\nInput:  " + n);
            System.out.println("Output: " + answer);
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
            System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1_000_000.0);
        } catch (Exception e) {
            System.err.println("Error in test: " + e.getMessage());
        }
    }
}