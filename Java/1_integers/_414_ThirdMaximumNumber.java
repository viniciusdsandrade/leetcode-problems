import java.util.Arrays;
import java.util.Scanner;

public class _414_ThirdMaximumNumber {

    /*
    414. Third Maximum Number
    
    Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

    Example 1:
    Input: nums = [3,2,1]
    Output: 1
    Explanation:
    The first distinct maximum is 3.
    The second distinct maximum is 2.
    The third distinct maximum is 1.

    Example 2:
    Input: nums = [1,2]
    Output: 2
    Explanation:
    The first distinct maximum is 2.
    The second distinct maximum is 1.
    The third distinct maximum does not exist, so the maximum (2) is returned instead.

    Example 3:
    Input: nums = [2,2,3,1]
    Output: 1
    Explanation:
    The first distinct maximum is 3.
    The second distinct maximum is 2 (both 2's are counted together since they have the same value).
    The third distinct maximum is 1.
 
    Constraints:
    1 <= nums.length <= 10^4
    -2^31 <= nums[i] <= 2^31 - 1
 
    Follow up: Can you find an O(n) solution?
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the size of the array: ");
            int size = scanner.nextInt();

            if (size <= 0) {
                System.err.println("Array size must be greater than 0.");
                return;
            }

            int[] nums = new int[size];

            for (int i = 0; i < size; i++) {
                System.out.printf("Enter array[%d]: ", i);
                nums[i] = scanner.nextInt();
            }

            testThirdMax(nums);
        }
    }

    private static void testThirdMax(int[] nums) {
        try {
            long startTime = System.nanoTime();
            int answer = thirdMax(nums);
            long endTime = System.nanoTime();

            System.out.println("\nInput:  " + Arrays.toString(nums));
            System.out.println("Output: " + answer);
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
            System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1_000_000.0);
        } catch (RuntimeException e) {
            System.err.println("Error in test: " + e.getMessage());
        }
    }

    public static int thirdMax(int[] nums) {
        
        // Se o array tiver apenas 1 elemento, retornar esse elemento
        if (nums.length == 1)
            return nums[0];
        
        // Se o array tiver apenas 2 elementos, retornar o maior
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        
        // Se o array tiver apenas 3 elementos, retornar o terceiro maior
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;
        
        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            }
            else if (num > max2 && num < max1) {
                max3 = max2;
                max2 = num;
            }
            else if (num > max3 && num < max2) {
                max3 = num;
            }
        }
        
        return (int) (max3 == Long.MIN_VALUE ? max1 : max3);
    }
}
