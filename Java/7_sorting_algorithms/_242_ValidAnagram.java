public class _242_ValidAnagram {

    /*
    242. Valid Anagram
    Given two strings s and t, return true if t is an anagram of s,
    and false otherwise.

    An Anagram is a word or phrase formed by rearranging the letters of a
    different word or phrase, typically using all the original letters exactly once.

    Example 1:
    Input: s = "anagram", t = "nagaram"
    Output: true

    Example 2:
    Input: s = "rat", t = "car"
    Output: false

    Constraints:
    1 <= s.length, t.length <= 5 * 104
    s and t consist of lowercase English letters.
     */

    public static void main(String[] args) {
        testIsAnagram("anagram", "nagaram");
        testIsAnagram("rat", "car");
        testIsAnagram("a", "ab");
        testIsAnagram("ab", "a");
        testIsAnagram("a", "a");
        testIsAnagram("a", "b");
        testIsAnagram("a", "aa");
        testIsAnagram("aa", "a");
        testIsAnagram("aa", "aa");
        testIsAnagram("aa", "ab");
    }

    public static boolean isAnagram(String s, String t) {
        // Verifica se os comprimentos das strings são diferentes
        if (s.length() != t.length()) return false;

        // Array para armazenar a contagem de ocorrências de cada caractere ('a' a 'z')
        int[] letras = new int[26];

        // Itera sobre cada caractere das strings s e t
        for (int i = 0; i < s.length(); i++) {
            // Incrementa a contagem para o caractere atual em s e decrementa em t
            letras[s.charAt(i) - 'a']++;
            letras[t.charAt(i) - 'a']--;
        }

        // Verifica se todas as contagens no array são zero
        for (int n : letras)
            if (n != 0)
                return false;

        // Se chegou até aqui, as strings são anagramas
        return true;
    }

    public static void testIsAnagram(String s, String t) {

        System.out.println("\nInput: " + s + ", " + t);

        long startTime = System.nanoTime();
        boolean result = isAnagram(s, t);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (endTime - startTime) + " ns");
        System.out.printf("Runtime: %.6f ms\n", (endTime - startTime) / 1_000_000.0);
    }
}