public class _1816_TruncateSentence {
    /*
    1816. Truncate Sentence
    A sentence is a list of words that are separated by a single space with no
    leading or trailing spaces.
    Each of the words consists of only uppercase and lowercase English letters (no punctuation).

    For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.
    You are given a sentence s and an integer k.
    You want to truncate s such that it contains only the first k words.
    Return s after truncating it.

    Example 1:
    Input: s = "Hello how are you Contestant", k = 4
    Output: "Hello how are you"
    Explanation:
    The words in s are ["Hello", "how" "are", "you", "Contestant"].
    The first 4 words are ["Hello", "how", "are", "you"].
    Hence, you should return "Hello how are you".

    Example 2:
    Input: s = "What is the solution to this problem", k = 4
    Output: "What is the solution"
    Explanation:
    The words in s are ["What", "is" "the", "solution", "to", "this", "problem"].
    The first 4 words are ["What", "is", "the", "solution"].
    Hence, you should return "What is the solution".

    Example 3:
    Input: s = "chopper is not a tanuki", k = 5
    Output: "chopper is not a tanuki"

    Constraints:
    1 <= s.length <= 500
    k is in the range [1, the number of words in s].
    s consist of only lowercase and uppercase English letters and spaces.
    The words in s are separated by a single space.
    There are no leading or trailing spaces.
     */

    public static void main(String[] args) {
        String s1 = "Hello how are you Contestant";
        int k1 = 4;
        testTruncateSentence(s1, k1);

        String s2 = "What is the solution to this problem";
        int k2 = 4;
        testTruncateSentence(s2, k2);
    }

    /**
     * Trunca uma sentença após um número especificado de palavras.
     *
     * @param s a sentença a ser truncada
     * @param k o número de palavras após o qual a sentença deve ser truncada
     * @return a sentença truncada após o número especificado de palavras,
     *         ou a sentença completa se contiver menos de k palavras
     */
    public static String truncateSentence(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') count++;
            if (count == k) return s.substring(0, i);
        }
        return s;
    }


    public static void testTruncateSentence(String s, int k) {
        System.out.println("Input: s = " + s + ", k = " + k);

        long start = System.nanoTime();
        String output = truncateSentence(s, k);
        long end = System.nanoTime();

        System.out.println("Output: " + output);
        System.out.println("Runtime: " + (end - start) + "ns\n");
    }
}
