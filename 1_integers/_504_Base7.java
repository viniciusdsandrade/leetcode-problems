public class _504_Base7 {
    
    /*
    504. Base 7
    Given an integer num, return a string of its base 7 representation.

    Example 1:
    Input: num = 100
    Output: "202"
    
    Example 2:
    Input: num = -7
    Output: "-10"

    Constraints:
    -10^7 <= num <= 10^7
     */

    public static void main(String[] args) {
        for(int i = -10_0000; i <= 10_0000; i++)
            testConvertToBase7(i);
    }

    public static String convertToBase7(int num) {
        if (num < -10_000_000 || num > 10_000_000) return null;
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();

        if (num < 0) {
            sb.append("-");
            num = -num;
        }

        int base = 1;

        while (base * 7 <= num)
            base = base * 7;

        while (base > 0) {
            sb.append(num / base);
            num = num % base;
            base = base / 7;
        }

        return sb.toString();
    }

    public static void testConvertToBase7(int num) {
        System.out.println("\nInput: num = " + num);

        long start1 = System.nanoTime();
        String result = convertToBase7(num);
        long end1 = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.printf("Runtime: %d ns\n", end1 - start1);
        System.out.printf("Runtime: %.6f ms\n", (end1 - start1) / 1_000_000.00);
    }
}