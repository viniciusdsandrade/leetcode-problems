import java.util.Arrays;

public class _1662_CheckIfTwoStringArraysAreEquivalent {

    public static void main(String[] args) {

        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        testArrayStringsAreEqual(word1, word2);

        String[] word3 = {"abc", "d", "defg"};
        String[] word4 = {"abcddefg"};
        testArrayStringsAreEqual(word3, word4);
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        for (String s : word1) sb1.append(s);
        for (String s : word2) sb2.append(s);

        String s1 = sb1.toString();
        String s2 = sb2.toString();

        return s1.contentEquals(s2);
    }

    public static void testArrayStringsAreEqual(String[] word1, String[] word2) {
        System.out.println("\nInput: " + Arrays.toString(word1) + ", " + Arrays.toString(word2));

        long startTime = System.nanoTime();
        boolean result = arrayStringsAreEqual(word1, word2);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution time: " + (endTime - startTime) + "ns");
        System.out.printf("Execution time: %.4fms\n", (endTime - startTime) / 1_000_000.00);
    }
}