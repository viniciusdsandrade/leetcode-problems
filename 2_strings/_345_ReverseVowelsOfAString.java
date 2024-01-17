public class _345_ReverseVowelsOfAString {

    /*
    345. Reverse Vowels of a String
    
    Given a string s, reverse only all the vowels in the string and 
    return it.

    The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in 
    both lower and upper cases, more than once.

    Example 1:
    Input: s = "hello"
    Output: "holle"
    
    Example 2:
    Input: s = "leetcode"
    Output: "leotcede"

    Constraints:
    1 <= s.length <= 3 * 10^5
    s consist of printable ASCII characters.
     */

    public static void main(String[] args) {

        testReverseVowels("hello");
        testReverseVowels("leetcode");
        testReverseVowels("abcdefghijklmnopqrstuvwxyz");
    }

    public static String reverseVowels(String s) {

        // Converte a string para um array de caracteres para facilitar a manipulação
        char[] chars = s.toCharArray();

        // Ponteiros para o início e o fim do array
        int left = 0;
        int right = chars.length - 1;

        // Itera enquanto o índice esquerdo for menor que o índice direito
        while (left < right) {

            // Verifica se os caracteres nos índices esquerdo e direito são vogais
            if (isVowel(chars[left]) && isVowel(chars[right])) {
                // Se ambos são vogais, troca os caracteres
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                // Move os índices para dentro do array
                left++;
                right--;
            } else if (isVowel(chars[left]))
                right--;// Se apenas o caractere na posição esquerda é uma vogal, move o índice direito para dentro
            else if (isVowel(chars[right]))
                left++;// Se apenas o caractere na posição direita é uma vogal, move o índice esquerdo para dentro
            else {
                left++; // Se nenhum dos dois é uma vogal, move ambos os índices para dentro
                right--;
            }
        }
        return new String(chars); // Converte o array de caracteres de volta para uma string e retorna o resultado
    }

    // Verifica se um caractere é uma vogal (maiúscula ou minúscula)
    private static boolean isVowel(char aChar) {
        return aChar == 'a' || aChar == 'e' || aChar == 'i' || aChar == 'o' || aChar == 'u' ||
                aChar == 'A' || aChar == 'E' || aChar == 'I' || aChar == 'O' || aChar == 'U';
    }

    public static void testReverseVowels(String s) {
        System.out.println("\nInput: " + s);

        long start = System.nanoTime();
        String result = reverseVowels(s);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Time: " + (end - start) + " ns");
        System.out.printf("Time: %.5f ms\n", (end - start) / 1_000_000.0);
    }
}