public class _43_MultiplyStrings {

    public static void main(String[] args) {

        testMultiply("2", "3");
        testMultiply("123", "456");
//        testMultiply("123456789", "987654321");
//        testMultiply("123456789", "0");
//        testMultiply("0", "123456789");
//        testMultiply("0", "0");
//        testMultiply("123456789", "1");
//        testMultiply("1", "123456789");
//        testMultiply("123456789", "2");
    }

    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];
        
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                result[i + j + 1] = result[i + j + 1] + x * y;
                System.out.println("Partial result at (" + (i + j + 1) + "): " + result[i + j + 1]);
            }
        }

        int carry = 0;
        for (int i = m + n - 1; i >= 0; i--) {
            result[i] = result[i] + carry;
            carry = result[i] / 10;
            result[i] = result[i] % 10;
            System.out.println("Intermediate result at (" + i + "): " + result[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + n; i++) {
            if (sb.isEmpty() && result[i] == 0) {
                continue;
            }
            sb.append(result[i]);
        }

        System.out.println("Final result: " + (sb.isEmpty() ? "0" : sb.toString()));
        return sb.isEmpty() ? "0" : sb.toString();
    }

    public static void testMultiply(String num1, String num2) {
        System.out.println("\nInput: num1 = " + num1 + ", num2 = " + num2);

        long startTime = System.nanoTime();
        String result = multiply(num1, num2);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    }
}
