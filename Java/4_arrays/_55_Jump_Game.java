import java.util.Arrays;

public class _55_Jump_Game {
    /*
    55. Jump Game

    You are given an integer array nums.
    You are initially positioned at the array's first index,
    and each element in the array represents your maximum jump length at that position.

    Return true if you can reach the last index, or false otherwise.

    Example 1:
    Input: nums = [2,3,1,1,4]
    Output: true
    Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

    Example 2:
    Input: nums = [3,2,1,0,4]
    Output: false
    Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

    Constraints:
    1 <= nums.length <= 10^4
    0 <= nums[i] <= 10^5
     */

    public static void main(String[] args) {

        int[] num_1 = {2, 3, 1, 1, 4};
        testCanJump(num_1);

        int[] num_2 = {3, 2, 1, 0, 4};
        testCanJump(num_2);
    }

    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxJump = 0;

        for (int i = 0; i < n; i++) {
            // Se não for possível pular até o índice i, false
            if (i > maxJump) return false;

            // Atualiza o máximo de pulos possíveis
            maxJump = Math.max(maxJump, i + nums[i]);
        }

        return true;
    }

    public static boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            // Se for possível pular até o último índice, atualiza o lastPos
            if (i + nums[i] >= lastPos) lastPos = i;
        }

        return lastPos == 0;
    }

    public static void testCanJump(int[] nums) {
        System.out.println("\nInput: nums = " + Arrays.toString(nums));

        long start = System.nanoTime();
        boolean result = canJump(nums);
        long end = System.nanoTime();

        long start_2 = System.nanoTime();
        boolean result_2 = canJump2(nums);
        long end_2 = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime1: " + (end - start) + " ns");
        System.out.println("Runtime2: " + (end_2 - start_2) + " ns");
    }
}
