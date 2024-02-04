public class _709_ToLowerCase {

    /*
    709. To Lower Case
    Given a string s, return the string after replacing
    every uppercase letter with the same lowercase letter.

    Example 1:
    Input: s = "Hello"
    Output: "hello"

    Example 2:
    Input: s = "here"
    Output: "here"

    Example 3:
    Input: s = "LOVELY"
    Output: "lovely"

    Constraints:
    1 <= s.length <= 100
    s consists of printable ASCII characters.
     */

    public static void main(String[] args) {
        test("Hello");
        test("here");
        test("LOVELY");
        test("Hello World!");
        test("Hello World! 123");
        test("ViniciusDSoSantosANDRADE");
    }

    public static String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 65 && c <= 90)
                sb.append((char) (c + 32));
            else
                sb.append(c);
        }
        return sb.toString();
    }

    public static String toLowerCase2(String s) {
        return s.toLowerCase();
    }

    public static void test(String s) {

        System.out.println("\nInput: " + s);

        long start = System.nanoTime();
        String result = toLowerCase(s);
        long end = System.nanoTime();

        long start2 = System.nanoTime();
        String result2 = toLowerCase2(s);
        long end2 = System.nanoTime();

        double razao = (double) (end - start) / (end2 - start2);

        System.out.println("Output: " + result);
        System.out.println("Runtime1: (char) (c + 32): " + (end - start) + " ns");
        System.out.println("Runtime2: s.toLowerCase(): " + (end2 - start2) + " ns");
        System.out.printf("Runtime1 is %.6f times faster than Runtime2\n", razao);
    }
}