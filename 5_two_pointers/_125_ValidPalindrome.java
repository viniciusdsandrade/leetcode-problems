public class _125_ValidPalindrome {
    
    /*
    125. Valid Palindrome
    
    A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing 
    all non-alphanumeric characters, it reads the same forward and backward. 
    Alphanumeric characters include letters and numbers.
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

    public static void main(String[] args) {

        testIsPalindrome("A man, a plan, a canal: Panama");
        testIsPalindrome("race a car");
        testIsPalindrome(" ");
        testIsPalindrome("Subi no onibus");
    }

    public static boolean isPalindrome(String s) {
        // Verifica se a string é nula ou vazia
        if (s == null || s.isEmpty())
            return true;

        int left = 0;
        int right = s.length() - 1;

        // Itera enquanto os índices não se cruzam
        while (left < right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));

            // Ignora caracteres não alfanuméricos
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }

            // Ignora caracteres não alfanuméricos
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }

            // Compara os caracteres, se diferentes, a string não é um palíndromo
            if (leftChar != rightChar)
                return false;

            // Move os índices para o meio
            left++;
            right--;
        }
        
        return true;
    }

    public static void testIsPalindrome(String s) {
        System.out.println("\nInput: s = " + s);
        long start = System.nanoTime();
        boolean actual = isPalindrome(s);
        long end = System.nanoTime();
        System.out.println("Output: " + actual);
        System.out.println("Execute Time: " + (end - start) + " ns");
        System.out.printf("Execute Time: %.5f ms\n", (end - start) / 1_000_000.0);
    }
}
