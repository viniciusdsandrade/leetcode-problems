import java.util.Arrays;

public class _1732_FindTheHighestAltitude {

    /*
    1732. Find the Highest Altitude
    There is a biker going on a road trip. The road trip consists of n + 1 
    points at different altitudes. The biker starts his trip on point 0 with altitude equal 0.
    
    You are given an integer array gain of length n where gain[i] is the net gain in 
    altitude between points i and i + 1 for all (0 <= i < n). Return the highest altitude of a point.
    
    Example 1:
    Input: gain = [-5,1,5,0,-7]
    Output: 1
    Explanation: The altitudes are [0,-5,-4,1,1,-6]. The highest is 1.
    
    Example 2:
    Input: gain = [-4,-3,-2,-1,4,3,2]
    Output: 0
    Explanation: The altitudes are [0,-4,-7,-9,-10,-6,-3,-1]. The highest is 0.
     
    Constraints:
    n == gain.length
    1 <= n <= 100
    -100 <= gain[i] <= 100
     */
    public static void main(String[] args) {

        int[] gain_1 = new int[]{-5, 1, 5, 0, -7};
        int[] gain_2 = new int[]{-4, -3, -2, -1, 4, 3, 2};

        testLargestAltitude(gain_1);
        testLargestAltitude(gain_2);
    }

    public static int largestAltitude(int[] gain) {
        if (gain.length == 0 || gain.length > 100) return 0;

        int max = 0;

        for (int i = 0; i < gain.length; i++) {

            if (i != 0)
                gain[i] = gain[i] + gain[i - 1];

            max = Math.max(max, gain[i]);
        }
        return max;
    }

    public static void testLargestAltitude(int[] gain) {
        System.out.println("\nInput: gain = " + Arrays.toString(gain));

        long startTime = System.nanoTime();
        int result = largestAltitude(gain);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Duration: " + (endTime - startTime) + "ns");
        System.out.printf("Duration: %.6fms\n", (endTime - startTime) / 1_000_000.00);
    }
}