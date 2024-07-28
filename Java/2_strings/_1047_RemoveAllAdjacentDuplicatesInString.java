public class _1047_RemoveAllAdjacentDuplicatesInString {

    /*
    1047. Remove All Adjacent Duplicates In String

    You are given a string s consisting of lowercase English letters.
    A duplicate removal consists of choosing two adjacent and equal letters and removing them.
    We repeatedly make duplicate removals on s until we no longer can.
    Return the final string after all such duplicate removals have been made.
    It can be proven that the answer is unique.

    Example 1:
    Input: s = "abbaca"
    Output: "ca"
    Explanation:
    For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal,
    and this is the only possible move.  The result of this move is that the string is "aaca",
    of which only "aa" is possible, so the final string is "ca".

    Example 2:
    Input: s = "azxxzy"
    Output: "ay"
    Constraints:

    1 <= s.length <= 10^5
    s consists of lowercase English letters.
     */

    public static void main(String[] args) {
        String first = "abbaca";
        testRemoveDuplicates(first);

        String second = "azxxzy";
        testRemoveDuplicates(second);

        String third = "vinicius";
        testRemoveDuplicates(third);
    }

    /**
     * Remove caracteres duplicados consecutivos de uma string.
     *
     * <p>Este metodo percorre a string de entrada e remove caracteres consecutivos duplicados.
     * Se um caractere for igual ao caractere anterior, ele será removido.
     *
     * @param s a string de entrada da qual os caracteres duplicados consecutivos serão removidos
     * @return uma nova string sem caracteres duplicados consecutivos
     */
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        int sbLength = 0;

        for (char character : s.toCharArray()) {
            // Se o caractere atual for igual ao caractere anterior, remova o caractere anterior
            if (sbLength != 0 && sb.charAt(sbLength - 1) == character) {
                sb.deleteCharAt(sbLength - 1);
                sbLength--;
            } else {
                // caso contrário, adicione o caractere ao StringBuilder
                sb.append(character);
                sbLength++;
            }
        }

        return sb.toString();
    }


    public static void testRemoveDuplicates(String s) {
        System.out.println("Input: " + s);

        long startTime = System.nanoTime();
        String result = removeDuplicates(s);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (endTime - startTime) + " ns\n");
    }
}
