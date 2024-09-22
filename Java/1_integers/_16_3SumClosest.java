import java.util.Arrays;

import static java.lang.Math.abs;
import static java.util.Arrays.sort;

public class _16_3SumClosest {

    /*
    16. 3Sum Closest
    Given an integer array nums of length n and an integer target,
    find three integers in nums such that the sum is closest to target.

    Return the sum of the three integers.
    You may assume that each input would have exactly one solution.

    Example 1:
    Input: nums = [-1,2,1,-4], target = 1
    Output: 2
    Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

    Example 2:
    Input: nums = [0,0,0], target = 1
    Output: 0
    Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

    Constraints:
    3 <= nums.length <= 500
    -1000 <= nums[i] <= 1000
    -104 <= target <= 104
     */

    public static void main(String[] args) {
        int[] nums1 = {-1, 2, 1, -4};
        int target1 = 1;
        testThreeSumClosest(nums1, target1);

        int[] nums2 = {0, 0, 0};
        int target2 = 1;
        testThreeSumClosest(nums2, target2);

        int[] nums3 = {1, 1, 1, 0};
        int target3 = -100;
        testThreeSumClosest(nums3, target3);
    }

    public static int threeSumClosest(int[] nums, int target) {
        // 1. Ordena o array de entrada.
        sort(nums);

        // 2. Inicializa a variável que armazenará a soma mais próxima do alvo.
        int closestSum = nums[0] + nums[1] + nums[2];

        // 3. Itera sobre o array de entrada.
        for (int i = 0; i < nums.length - 2; i++) {
            // 4. Inicializa os ponteiros left e right.
            int left = i + 1;
            int right = nums.length - 1;

            // 5. Itera enquanto left < right.
            while (left < right) {
                // 6. Calcula a soma dos três números.
                int sum = nums[i] + nums[left] + nums[right];

                // 7. Atualiza a soma mais próxima do alvo.
                if (abs(target - sum) < abs(target - closestSum)) {
                    closestSum = sum;
                }

                // 8. Atualiza os ponteiros left e right.
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }

    public static void testThreeSumClosest(int[] nums, int target) {
        System.out.println("\nInput: nums = " + Arrays.toString(nums) + ", target = " + target);

        long startTime, endTime, runtime;
        int result;

        startTime = System.nanoTime();
        result = threeSumClosest(nums, target);
        endTime = System.nanoTime();

        runtime = endTime - startTime;

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + runtime + " ns\n");
    }
}
