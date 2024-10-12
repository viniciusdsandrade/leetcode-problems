public class _326_PowerOfThree {
    public static void main(String[] args) {

        testIsPowerOfThree(27);
        testIsPowerOfThree(0);
        testIsPowerOfThree(9);
        testIsPowerOfThree(45);
        testIsPowerOfThree(1);
        testIsPowerOfThree(-1);
        testIsPowerOfThree(-3);
        testIsPowerOfThree(-9);
        testIsPowerOfThree(3);
    }

    public static boolean isPowerOfThree(long n) {

        if (n < 1) return false;

        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n = n / 3;
        }
        return true;
    }

    public static void testIsPowerOfThree(int n) {
        System.out.printf("Input: %d\n", n);
        long startTime = System.nanoTime();
        boolean answer = isPowerOfThree(n);
        long endTime = System.nanoTime();
        System.out.printf("Answer: %b\n", answer);
        System.out.println("Execution time: " + (endTime - startTime) + " ns");
        System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1000000.0);
    }
}