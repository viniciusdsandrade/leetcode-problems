public class _441_ArrangingCoins {

    /*
    441. Arranging Coins
    You have n coins and you want to build a staircase with these coins.
    The staircase consists of k rows where the ith row has exactly i coins.
    The last row of the staircase may be incomplete.

    Given the integer n, return the number of complete rows of the staircase you will build.

    Example 1:
    Input: n = 5
    Output: 2
    Explanation: Because the 3rd row is incomplete, we return 2.

    Example 2:
    Input: n = 8
    Output: 3
    Explanation: Because the 4th row is incomplete, we return 3.

    Constraints:
    1 <= n <= 2^31 - 1
    feat: LeetCode 441 - Arranging Coins
     */

    public static void main(String[] args) {
        arrangeCoinsTest(5);
        arrangeCoinsTest(8);
    }

    public static int arrangeCoins(int n) {
        int result = 0;
        int i = 1;
        while (n >= i) {
            n = n - i;
            i = i + 1;
            result = result + 1;
        }
        return result;
    }

    public static void arrangeCoinsTest(int n) {
        System.out.println("\nInput: " + n);

        long startTime = System.nanoTime();
        int result = arrangeCoins(n);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execute Time: " + (endTime - startTime) + "ns");
        System.out.printf("Execute Time: %.5fms\n", (endTime - startTime) / 1_000_000.00);
    }
}