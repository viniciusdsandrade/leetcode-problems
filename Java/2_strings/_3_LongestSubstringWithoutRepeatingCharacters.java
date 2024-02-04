import java.util.Arrays;

public class _3_LongestSubstringWithoutRepeatingCharacters {

    /*
    3. Longest Substring Without Repeating Characters
    
    Given a string s, find the length of the longest substring without repeating characters.

    Example 1:
    Input: s = "abcabcbb"
    Output: 3
    Explanation: The answer is "abc", with the length of 3.

    Example 2:
    Input: s = "bbbbb"
    Output: 1
    Explanation: The answer is "b", with the length of 1.

    Example 3:
    Input: s = "pwwkew"
    Output: 3
    Explanation: The answer is "wke", with the length of 3.
    Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 
    Constraints:
    0 <= s.length <= 5 * 104
    s consists of English letters, digits, symbols and spaces.
     */

    public static void main(String[] args) {

        String s1 = "abcabcbb";
        String s2 = "pwwkew";
        String s3 = "bbbbb";

        testLengthOfLongestSubstring(s1);
        testLengthOfLongestSubstring(s2);
        testLengthOfLongestSubstring(s3);
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        int max = 0;
        int start = 0;

        for (int i = 1; i < s.length(); i++) {
            for (int j = start; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    start = j + 1;
                    break;
                }
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }

    public static void testLengthOfLongestSubstring(String s) {
        System.out.println("Input:  " + Arrays.toString(s.toCharArray()));

        long start = System.nanoTime();
        int result = lengthOfLongestSubstring(s);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Time: " + (end - start) + " ns");
        System.out.printf("Time: %.5f ms\n", (end - start) / 1000000.0);
        System.out.println();
    }
}