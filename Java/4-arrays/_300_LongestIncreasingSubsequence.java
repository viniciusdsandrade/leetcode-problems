import java.util.Arrays;

public class _300_LongestIncreasingSubsequence {

    public static void main(String[] args) {

        int[] nums1 = {10,9,2,5,3,7,101,18};
        testLengthOfLIS(nums1);

        int[] nums2 = {0,1,0,3,2,3};
        testLengthOfLIS(nums2);

        int[] nums3 = {7,7,7,7,7,7,7};
        testLengthOfLIS(nums3);

        int[] nums4 = {4,10,4,3,8,9};
        testLengthOfLIS(nums4);
    }

    public static int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int[] dp = new int[nums.length];

        int max = 1;
        dp[0] = 1;

        for(int i = 1; i < nums.length; i++) {

            int maxVal = 0;

            for(int j = 0; j < i; j++) {

                if(nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }

            dp[i] = maxVal + 1;
            max = Math.max(max, dp[i]);
        }

        return max;
    }


    public static void testLengthOfLIS(int[] nums) {
        System.out.println("\nInput: " + Arrays.toString(nums));

        long startTime = System.nanoTime();
        int result = lengthOfLIS(nums);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (endTime - startTime) + " ns\n");
        System.out.println("Runtime: " + (endTime - startTime) / 1_000_000 + " ms\n");
    }
}
