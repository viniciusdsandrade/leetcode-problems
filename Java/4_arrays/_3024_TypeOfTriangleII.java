import java.util.Arrays;

public class _3024_TypeOfTriangleII {

    public static void main(String[] args) {

        int[] nums1 = {2, 2, 2};
        testTriangleType(nums1);

        int[] nums2 = {3, 4, 5};
        testTriangleType(nums2);

        int[] nums3 = {1, 2, 3};
        testTriangleType(nums3);

        int[] nums4 = {1, 1, 3};
        testTriangleType(nums4);

        int[] nums5 = {1, 2, 3};
        testTriangleType(nums5);
    }

    public static String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if (!isValidTriangle(a, b, c))
            return "Not a Triangle";

        if (a == b && b == c)
            return "equilateral";
        else if (a == b || b == c || a == c)
            return "isosceles";
        else
            return "scalene";
    }

    public static boolean isValidTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static void testTriangleType(int[] nums) {
        System.out.println("\n Input: nums = " + Arrays.toString(nums));

        long start = System.nanoTime();
        String result = triangleType(nums);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (end - start) + " ns\n");
    }
}