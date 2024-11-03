import static java.lang.Character.isLetterOrDigit;
import static java.lang.Character.toLowerCase;
import static java.lang.System.nanoTime;

public class _125_valid_palindrome {

    /*
    125. Valid Palindrome

    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

    Given a string s, return true if it is a palindrome, or false otherwise.

    Example 1:
    Input: s = "A man, a plan, a canal: Panama"
    Output: true
    Explanation: "amanaplanacanalpanama" is a palindrome.

    Example 2:
    Input: s = "race a car"
    Output: false
    Explanation: "raceacar" is not a palindrome.

    Example 3:
    Input: s = " "
    Output: true
    Explanation: s is an empty string "" after removing non-alphanumeric characters.
    Since an empty string reads the same forward and backward, it is a palindrome.

    Constraints:
    1 <= s.length <= 2 * 10^5
    s consists only of printable ASCII characters.
     */

    public static void main(String[] ignoredArgs) {
        String s = "A man, a plan, a canal: Panama";
        testIsPalindrome(s);

        String r = "race a car";
        testIsPalindrome(r);

        String t = " ";
        testIsPalindrome(t);
    }

    /**
     * Verifica se uma determinada string é um palíndromo, ignorando caracteres não alfanuméricos e diferenças de maiúsculas e minúsculas.
     *
     * <p>Um palíndromo é uma palavra, frase, número ou outra sequência de caracteres que lê o mesmo para a frente e para trás,
     * desconsiderando espaços, pontuações e diferenças entre maiúsculas e minúsculas.</p>
     *
     * @param s A string que será verificada.
     * @return {@code true} se a string for um palíndromo; {@code false} caso contrário.
     */
    public static boolean isPalindrome(String s) {
        // Verifica se a string é nula
        if (s == null) return false;

        int left = 0;               // Ponteiro inicial
        int right = s.length() - 1; // Ponteiro final

        // Continua até que os ponteiros se cruzem
        while (left < right) {
            char charLeft = s.charAt(left); // Obtém o caractere na posição left
            char charRight = s.charAt(right); // Obtém o caractere na posição right

            // Verifica se o caractere da esquerda não é alfanumérico
            if (!isLetterOrDigit(charLeft)) {
                left++; // Move o ponteiro da esquerda para a direita
                continue; // Pula para a próxima iteração
            }

            // Verifica se o caractere da direita não é alfanumérico
            if (!isLetterOrDigit(charRight)) {
                right--; // Move o ponteiro da direita para a esquerda
                continue; // Pula para a próxima iteração
            }

            // Compara os caracteres convertidos para minúsculas
            // Retorna falso se os caracteres não coincidirem
            if (toLowerCase(charLeft) != toLowerCase(charRight)) return false;

            left++; // Move o ponteiro da esquerda para a direita
            right--; // Move o ponteiro da direita para a esquerda
        }

        return true; // Retorna verdadeiro se todos os caracteres corresponderem
    }

    public static void testIsPalindrome(String s) {
        System.out.println("\nInput: s = \"" + s + "\"");

        long start, end, runtime;
        boolean answer;

        start = nanoTime();
        answer = isPalindrome(s);
        end = nanoTime();

        runtime = end - start;

        System.out.println("Output: " + answer);
        System.out.println("Runtime: " + runtime + " ns\n");
    }
}
