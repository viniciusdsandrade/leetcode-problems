public class _7_ReverseInteger {

    /*
    7. Given a signed 32-bit integer x, return x with its digits reversed.
    If reversing x causes the value to go outside the signed 32-bit integer
    range [-231, 231 - 1], then return 0.

    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

    Example 1:
    Input: x = 123
    Output: 321

    Example 2:
    Input: x = -123
    Output: -321

    Example 3:
    Input: x = 120
    Output: 21

    Constraints:
    -2^31 <= x <= 2^31 - 1
    */

    public static void main(String[] args) {
        testReverse(123);
        testReverse(-123);
        testReverse(120);
    }

    public static int reverse(int x) {

        if (x == 0) return 0;

        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;

            // Check for overflow
            if (reversed > Integer.MAX_VALUE / 10 ||
                    (reversed == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;

            // Check for underflow
            if (reversed < Integer.MIN_VALUE / 10 ||
                    (reversed == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;

            x = x / 10;
            reversed = reversed * 10 + digit;
        }

        return reversed;
    }

    private static void testReverse(int x) {
        System.out.println("Input: x = " + x);

        long startTime = System.nanoTime();
        int result = reverse(x);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution time: " + (endTime - startTime) + "ns\n");
    }
}