import static java.lang.System.nanoTime;
import static java.lang.System.out;

public class _392_IsSubsequence {

    /*
    392. Is Subsequence

    Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

    A subsequence of a string is a new string that is formed from the original string by deleting some
    (can be none) of the characters without disturbing the relative positions of the remaining characters.
    (i.e., "ace" is a subsequence of "abcde" while "aec" is not).


    Example 1:
    Input: s = "abc", t = "ahbgdc"
    Output: true

    Example 2:
    Input: s = "axc", t = "ahbgdc"
    Output: false


    Constraints:
    0 ≤ s.length ≤ 100
    0 ≤ t.length ≤ 10^4
    s and t consist only of lowercase English letters.

    Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and
    you want to check one by one to see if t has its subsequence.
    In this scenario, how would you change your code?
     */

    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        testIsSubsequence(s, t);

        s = "axc";
        t = "ahbgdc";
        testIsSubsequence(s, t);
    }

    /**
     * Verifica se a string 's' é uma subsequência da string 't'.
     *
     * <p>Uma subsequência mantém a ordem dos caracteres de 's' em 't',
     * mas não requer que eles sejam adjacentes.</p>
     *
     * @param s A string que será verificada como subsequência.
     * @param t A string onde será feita a verificação.
     * @return {@code true} se 's' for subsequência de 't',
     *         caso contrário, {@code false}.
     */
    public static boolean isSubsequence(String s, String t) {
        // Início dos índices para percorrer ambas as strings
        int i = 0, j = 0;

        // Enquanto não chegarmos ao fim de ambas as strings
        while (i < s.length() && j < t.length()) {

            // Se os caracteres em 's' e 't' forem iguais, avançamos no índice de 's'
            if (s.charAt(i) == t.charAt(j)) i++;

            // Avançamos sempre no índice de 't'
            j++;
        }

        // Retorna true se todos os caracteres de 's' forem encontrados em 't'
        return i == s.length();
    }

    public static void testIsSubsequence(String s, String t) {
        out.println("s = " + s + ", t = " + t);

        boolean result;
        long start, end, runtime;

        start = nanoTime();
        result = isSubsequence(s, t);
        end = nanoTime();

        runtime = end - start;

        out.println("Output: " + result);
        out.println("Runtime: " + runtime + " ms\n");
    }
}
