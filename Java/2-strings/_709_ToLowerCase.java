import static java.lang.IO.println;
import static util.Print.printf;

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
        testDebug("Hello");
        testDebug("here");
        testDebug("LOVELY");
        testDebug("Hello World!");
        testDebug("Hello World! 123");
        testDebug("ViniciusDSoSantosANDRADE");
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

    public static String toLowerCaseDebug(String s) {
        println("=== toLowerCase: modo debug ===");
        println("Entrada: \"" + s + "\" (len=" + s.length() + ")");

        StringBuilder sb = new StringBuilder();
        int i = 0; // apenas para mostrar o índice no debug

        for (char c : s.toCharArray()) {
            println("\n-- i=" + i);
            println("char = '" + c + "' | code = " + (int) c);
            println((c >= 65 && c <= 90)
                    ? "É maiúscula ASCII (A..Z). Convertendo somando 32…"
                    : "Não é maiúscula ASCII. Mantém igual.");

            if (c >= 65 && c <= 90)
                sb.append((char) (c + 32));
            else
                sb.append(c);

            println("Parcial: \"" + sb + "\"");

            i++;
        }

        println("\nResultado final: \"" + sb + "\"");
        println("=== fim do debug ===\n");

        return sb.toString();
    }

    public static String toLowerCase2(String s) {
        return s.toLowerCase();
    }

    public static void testDebug(String s) {
        println("\nInput: " + s);
        String result = toLowerCaseDebug(s);
        println("Output: " + result);
    }

    public static void test(String s) {
        println("\nInput: " + s);

        long start = System.nanoTime();
        String result = toLowerCase(s);
        long end = System.nanoTime();

        long start2 = System.nanoTime();
        String result2 = toLowerCase2(s);
        long end2 = System.nanoTime();

        double razao = (double) (end - start) / (end2 - start2);

        println("Output: " + result);
        println("Runtime1: (char) (c + 32): " + (end - start) + " ns");
        println("Runtime2: s.toLowerCase(): " + (end2 - start2) + " ns");
        printf("Runtime1 is %.6f times faster than Runtime2\n", razao);
    }
}