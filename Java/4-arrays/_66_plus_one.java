import java.util.Arrays;

public class _66_plus_one {

    public static void main(String[] args) {

        int[] digits1 = {1, 2, 3};
        testPlusOne(digits1);

        int[] digits2 = {4, 3, 2, 1};
        testPlusOne(digits2);

        int[] digits3 = {0};
        testPlusOne(digits3);

        int[] digits4 = {9};
        testPlusOne(digits4);

        int[] digits5 = {9, 9};
        testPlusOne(digits5);

        int[] digits6 = {9, 9, 9};
        testPlusOne(digits6);

        int[] digits7 = {9, 9, 9, 9};
        testPlusOne(digits7);

        int[] digits8 = {9, 9, 9, 9, 9};
        testPlusOne(digits8);

        int[] digits9 = {9, 9, 9, 9, 9, 9};
        testPlusOne(digits9);

        int[] digits10 = {9, 9, 9, 9, 9, 9, 9};
        testPlusOne(digits10);

        int[] digits11 = {9, 9, 9, 9, 9, 9, 9, 9};
        testPlusOne(digits11);

        int[] digits12 = {9, 9, 9, 9, 9, 9, 9, 9, 9};
        testPlusOne(digits12);

        int[] digits13 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        testPlusOne(digits13);

        int[] digits14 = {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        testPlusOne(digits14);
    }


    public static int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) return null;

        //Caso o último dígito seja diferente de 9, basta incrementá-lo
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }

        int carry = 1;
        int[] result = new int[digits.length + 1];

        for (int i = digits.length - 1; i >= 0; i--) {

            int sum = digits[i] + carry;

            if (sum == 10) {
                result[i + 1] = 0;
                carry = 1;
            } else {
                result[i + 1] = sum;
                carry = 0;
            }
        }

        if (carry == 1) {
            result[0] = 1;
            return result;
        }

        return Arrays.copyOfRange(result, 1, result.length);
    }

    public static void testPlusOne(int[] digits) {
        System.out.println("\nInput: " + Arrays.toString(digits));

        long startTime = System.nanoTime();
        int[] result = plusOne(digits);
        long endTime = System.nanoTime();

        System.out.println("Output: " + Arrays.toString(result));
        System.out.println("Runtime: " + (endTime - startTime) + " ns\n");
        System.out.println("Runtime: " + (endTime - startTime) / 1_000_000 + " ms\n");
    }
}
