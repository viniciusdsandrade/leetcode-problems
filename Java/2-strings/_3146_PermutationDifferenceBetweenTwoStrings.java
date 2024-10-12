public class _3146_PermutationDifferenceBetweenTwoStrings {

    /*
    3146. Permutation Difference between Two Strings
    You are given two strings s and t such that every character occurs at most once in s and t is
    a permutation of s.

    The permutation difference between s and t is defined as the sum of the absolute difference
    between the index of the occurrence of each character in s and the index of the occurrence of
    the same character in t.

    Return the permutation difference between s and t.

    Example 1:
    Input: s = "abc", t = "bac"
    Output: 2
    Explanation:
    For s = "abc" and t = "bac", the permutation difference of s and t is equal to the sum of:
    The absolute difference between the index of the occurrence of "a" in s and the index of the occurrence of "a" in t.
    The absolute difference between the index of the occurrence of "b" in s and the index of the occurrence of "b" in t.
    The absolute difference between the index of the occurrence of "c" in s and the index of the occurrence of "c" in t.
    That is, the permutation difference between s and t is equal to |0 - 1| + |2 - 2| + |1 - 0| = 2.

    Example 2:
    Input: s = "abcde", t = "edbac"
    Output: 12
    Explanation:
    The permutation difference between s and t is equal to |0 - 3| + |1 - 2| + |2 - 4| + |3 - 1| + |4 - 0| = 12.

    Constraints:
    1 <= s.length <= 26
    Each character occurs at most once in s.
    t is a permutation of s.
    s consists only of lowercase English letters.
     */

    public static void main(String[] args) {
        String s1 = "abc";
        String t1 = "bac";
        testFindPermutationDifference(s1, t1);

        String s2 = "abcde";
        String t2 = "edbac";
        testFindPermutationDifference(s2, t2);
    }

    /**
     * Calcula a diferença de permutação entre duas strings fornecidas.
     *
     * <p>Este método assume que as strings de entrada consistem apenas de letras minúsculas
     * do alfabeto inglês ('a' a 'z') e que ambas as strings possuem o mesmo comprimento.</p>
     *
     * <p>A diferença de permutação é calculada somando as diferenças absolutas
     * entre os índices de cada letra nas duas strings.</p>
     *
     * @param s A primeira string a ser comparada.
     * @param t A segunda string a ser comparada.
     * @return A soma das diferenças absolutas dos índices das letras em cada string.
     */
    public static int findPermutationDifference(String s, String t) {
        int[] sIndex = new int[26];
        int[] tIndex = new int[26];

        // Intera
        for (int i = 0; i < s.length(); i++) {
            sIndex[s.charAt(i) - 'a'] = i;
            tIndex[t.charAt(i) - 'a'] = i;
        }

        int partial;
        int result = 0;
        for (int i = 0; i < 26; i++) {
            partial = sIndex[i] - tIndex[i];
            result += Math.abs(partial);
        }

        return result;
    }


    public static void testFindPermutationDifference(String s, String t) {
        System.out.println("Input: s = " + s + ", t = " + t);

        long startTime = System.nanoTime();
        int result = findPermutationDifference(s, t);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns");
    }
}
