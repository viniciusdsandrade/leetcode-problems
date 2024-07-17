public class _2235_AddToIntegers {

    /*
    2235. Add Two Integers
    Given two integers num1 and num2, return the sum of the two integers.

    Example 1:
    Input: num1 = 12, num2 = 5
    Output: 17
    Explanation: num1 is 12, num2 is 5, and their sum is 12 + 5 = 17, so 17 is returned.

    Example 2:
    Input: num1 = -10, num2 = 4
    Output: -6
    Explanation: num1 + num2 = -6, so -6 is returned.

    Constraints:
    -100 <= num1, num2 <= 100
     */

    public static void main(String[] args) {
        testSum(12, 5);
        testSum(-10, 4);
    }

    public static int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static void testSum(int num1, int num2) {
        System.out.println("Input: ");
        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        long start = System.nanoTime();
        int result = sum(num1, num2);
        long end = System.nanoTime();

        long resultTime = end - start;

        System.out.println("Output:  " + result);
        System.out.println("Runtime: " + resultTime + " ns");
    }
}
