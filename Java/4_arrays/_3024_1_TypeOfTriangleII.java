public class _3024_1_TypeOfTriangleII {

    public static void main(String[] args) {
        int[] nums = {3, 4, 5};
        testTypeOfTriangle(nums);

        int[] nums2 = {3, 3, 3};
        testTypeOfTriangle(nums2);

        int[] nums3 = {3, 4, 7};
        testTypeOfTriangle(nums3);

        int[] nums4 = {3, 4, 8};
        testTypeOfTriangle(nums4);
    }

    public static String typeOfTriangle(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if (!isValidTriangle(a, b, c))
            return "Não é um triângulo";

        StringBuilder sb = new StringBuilder();

        sb.append(typeAngleTriangle(a, b, c));
        sb.append(" ");
        sb.append(typeSideTriangle(a, b, c));

        return sb.toString();
    }

    public static boolean isValidTriangle(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    public static String typeAngleTriangle(int a, int b, int c) {
        // Calculate the cosine of each angle using the law of cosines
        double cosA = (b * b + c * c - a * a) / (2.0 * b * c);
        double cosB = (a * a + c * c - b * b) / (2.0 * a * c);
        double cosC = (a * a + b * b - c * c) / (2.0 * a * b);

        // Calculate the sine of each angle using trigonometric identities
        double sinA = Math.sqrt(1 - cosA * cosA);
        double sinB = Math.sqrt(1 - cosB * cosB);
        double sinC = Math.sqrt(1 - cosC * cosC);

        // Compare the sine and cosine values to determine the angle classification
        if (sinA == 0 || sinB == 0 || sinC == 0)
            return "Não é um triângulo"; // Degenerate triangle (one angle is 0°)
        else if (cosA == 0 || cosB == 0 || cosC == 0)
            return "Retângulo"; // Right triangle (one angle is 90°)
        else if (cosA > 0 && cosB > 0 && cosC > 0)
            return "Acutângulo"; // Acute triangle (all angles are less than 90°)
        else if (cosA < 0 || cosB < 0 || cosC < 0)
            return "Obtusângulo"; // Obtuse triangle (one angle is greater than 90°)
        else
            return "";
    }

    public static String typeSideTriangle(int a, int b, int c) {
        if (a == b && b == c)
            return "Equilátero";
        else if (a == b || b == c || a == c)
            return "Isosceles";
        else
            return "Escaleno";
    }

    public static void testTypeOfTriangle(int[] nums) {
        System.out.println("\nInput: A = " + nums[0] + ", B = " + nums[1] + ", C = " + nums[2]);

        long startTime = System.nanoTime();
        System.out.println(typeOfTriangle(nums));
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        System.out.printf("Duration = %d ns\n", duration);
    }
}