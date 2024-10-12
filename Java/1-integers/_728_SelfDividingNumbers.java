import java.util.List;

public class _728_SelfDividingNumbers {

    /*
    728. Self-Dividing Numbers
    A self-dividing number is a number that is divisible by every digit it contains.

    For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
    A self-dividing number is not allowed to contain the digit zero.

    Given two integers left and right, return a list of all the self-dividing numbers
    in the range [left, right].

    Example 1:
    Input: left = 1, right = 22
    Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]

    Example 2:
    Input: left = 47, right = 85
    Output: [48,55,66,77]

    Constraints:
    1 <= left <= right <= 10^4
     */

    public static void main(String[] args) {
        testSelfDividingNumbers(1, 22);
        testSelfDividingNumbers(47, 85);
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new java.util.ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividing(i))
                result.add(i);
        }
        return result;
    }

    public static boolean isSelfDividing(int num) {
        int n = num;
        while (n > 0) {
            int digit = n % 10;
            if (digit == 0 || num % digit != 0)
                return false;
            n /= 10;
        }
        return true;
    }

    public static void testSelfDividingNumbers(int left, int right) {
        System.out.println("Input: left = " + left + ", right = " + right);

        long start = System.nanoTime();
        List<Integer> result = selfDividingNumbers(left, right);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (end - start) + " ns\n");
    }

}
