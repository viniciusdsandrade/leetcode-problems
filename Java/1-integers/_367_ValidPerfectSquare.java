public class _367_ValidPerfectSquare {
    public static void main(String[] args) {

        testIsPerfectSquare(16);
        testIsPerfectSquare(14);
        testIsPerfectSquare(1);
        testIsPerfectSquare(2);
        testIsPerfectSquare(3);
        testIsPerfectSquare(4);
        testIsPerfectSquare(2147483647);
    }

    public static boolean isPerfectSquare(int num) {
        if (num == 1) return true;

        int sqrt = (int) Math.sqrt(num);

        return sqrt * sqrt == num;
    }

    /*
     public static boolean isPerfectSquare(int num) {
        if (num == 1) return true;

        for (int i = 1; i <= num / 2; i++) {
            if (i * i == num) return true;
        }

        return false;
    }

     */


    public static void testIsPerfectSquare(int num) {
        System.out.println("\n num = " + num);

        long start = System.nanoTime();
        boolean result = isPerfectSquare(num);
        long end = System.nanoTime();

        System.out.println("result = " + result);
        System.out.printf("Runtime: %d ms\n", end - start);
        System.out.printf("Runtime: %.6f ms\n", (end - start) / 1_000_000.00);
    }
}