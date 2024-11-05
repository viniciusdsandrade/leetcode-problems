import static java.lang.System.nanoTime;

public class _58_length_of_last_word {

    /*
    58. Length of Last Word

    Given a string s consisting of words and spaces, return the length of the last word in the string.

    A word is a maximal
    substring
    consisting of non-space characters only.



    Example 1:
    Input: s = "Hello World"
    Output: 5
    Explanation: The last word is "World" with length 5.

    Example 2:
    Input: s = "   fly me   to   the moon  "
    Output: 4
    Explanation: The last word is "moon" with length 4.

    Example 3:
    Input: s = "luffy is still joyboy"
    Output: 6
    Explanation: The last word is "joyboy" with length 6.

    Constraints:
    1 <= s.length <= 10^4
    s consists of only English letters and spaces ' '.
    There will be at least one word in s.
     */

    public static void main(String[] ignoredArgs) {
        String first = "Hello World";
        String second = "   fly me   to   the moon  ";
        String third = "luffy is still joyboy";

        testLengthOfLastWord(first);
        testLengthOfLastWord(second);
        testLengthOfLastWord(third);
    }

    /**
     * Calcula o comprimento da última palavra em uma string fornecida.
     *
     * <p>Uma palavra é definida como uma sequência de caracteres sem espaços.
     * A função ignora quaisquer espaços em branco no final da string antes de calcular o comprimento da última palavra.
     *
     * <p>Exemplos:
     * <ul>
     *   <li>Entrada: "Hello World" → Saída: 5</li>
     *   <li>Entrada: "   fly me   to   the moon  " → Saída: 4</li>
     *   <li>Entrada: "luffy is still joyboy" → Saída: 6</li>
     * </ul>
     *
     * @param s Uma string que consiste em palavras e espaços em branco.
     * @return O comprimento da última palavra na string. Retorna 0 se não houver palavras.
     */
    public static int lengthOfLastWord(String s) {

        int length = 0; // Variável para armazenar o comprimento da última palavra
        int i = s.length() - 1; // Índice inicial para percorrer a string do final

        // Ignora os espaços em branco no final da string
        while (i >= 0 && s.charAt(i) == ' ') i--;


        // Conta os caracteres da última palavra até encontrar um espaço ou o início da string
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length; // Retorna o comprimento da última palavra encontrada
    }


    public static void testLengthOfLastWord(String s) {
        System.out.println("\nInput" + s);

        long start, end, runtime;
        int answer;

        start = nanoTime();
        answer = lengthOfLastWord(s);
        end = nanoTime();

        runtime = end - start;

        System.out.println("Output: " + answer);
        System.out.println("Runtime: " + runtime + " ns");
    }
}
