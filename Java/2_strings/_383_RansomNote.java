public class _383_RansomNote {
    /*
        383. Ransom Note
        Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
        Each letter in magazine can only be used once in ransomNote.

        Example 1:
        Input: ransomNote = "a", magazine = "b"
        Output: false

        Example 2:
        Input: ransomNote = "aa", magazine = "ab"
        Output: false

        Example 3:
        Input: ransomNote = "aa", magazine = "aab"
        Output: true

        Constraints:
        1 <= ransomNote.length, magazine.length <= 105
        ransomNote and magazine consist of lowercase English letters.
     */

    public static void main(String[] args) {
        testCanConstruct("a", "b");
        testCanConstruct("aa", "ab");
        testCanConstruct("aa", "aab");
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];

        for (char c : magazine.toCharArray()) count[c - 'a']++;

        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }

    public static void testCanConstruct(String ransomNote, String magazine) {
        System.out.println("ransomNote = " + ransomNote);
        System.out.println("magazine = " + magazine);

        long start = System.nanoTime();
        boolean result = canConstruct(ransomNote, magazine);
        long end = System.nanoTime();

        System.out.println("Output = " + result);
        System.out.println("Execution time = " + (end - start) + " ns\n");
    }
}
