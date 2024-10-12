import java.util.Arrays;

public class _1528_ShuffleString {

    /*
    1528. Shuffle String

    You are given a string s and an integer array indices of the same length.
    The string s will be shuffled such that the character at the ith position
    moves to indices[i] in the shuffled string.

    Return the shuffled string.

    Example 1:
    Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
    Output: "leetcode"
    Explanation: As shown, "codeleet" becomes "leetcode" after shuffling.

    Example 2:
    Input: s = "abc", indices = [0,1,2]
    Output: "abc"
    Explanation: After shuffling, each character remains in its position.

    Constraints:
    s.length == indices.length == n
    1 <= n <= 100
    s consists of only lowercase English letters.
    0 <= indices[i] < n
    All values of indices are unique.
     */

    public static void main(String[] args) {
        int[] indices1 = {4, 5, 6, 7, 0, 2, 1, 3};
        String s1 = "codeleet";
        testRestoreString(s1, indices1);

        int[] indice2 = {0, 1, 2};
        String s2 = "abc";
        testRestoreString(s2, indice2);
    }

    /**
     * Restaura uma string a partir de uma sequência de caracteres e um array de índices.
     *
     * <p>
     * Esta função recebe uma string `s` e um array de inteiros `indices`. O array `indices`
     * especifica a nova posição de cada caractere da string `s`. A função então constrói uma
     * nova string onde cada caractere da string `s` é colocado na posição indicada pelo array
     * `indices`.
     * </p>
     *
     * @param s A string original.
     * @param indices Um array de inteiros que especifica a nova posição de cada caractere da string `s`.
     * @return A string restaurada.
     */
    public static String restoreString(String s, int[] indices) {
        char[] result = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            result[indices[i]] = s.charAt(i);
        }

        return new String(result);
    }

    public static void testRestoreString(String s, int[] indices) {
        System.out.println("Input: s = " + s + ", indices = " + Arrays.toString(indices));

        long startTime = System.nanoTime();
        String result = restoreString(s, indices);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution time: " + (endTime - startTime) + "ns\n");
    }
}
