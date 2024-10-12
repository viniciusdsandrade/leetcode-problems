import java.util.*;

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

    public static int lengthOfLongestSubstring1(String s) {

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

    public static int lengthOfLongestSubstring2(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;

        int max = 0;
        int start = 0;
        int[] index = new int[128];

        for (int i = 0; i < s.length(); i++) {
            start = Math.max(start, index[s.charAt(i)]);
            max = Math.max(max, i - start + 1);
            index[s.charAt(i)] = i + 1;
        }
        return max;
    }

    public static int lengthOfLongestSubstring3(String s) {
        if (s.isEmpty()) return 0;
        Set<Character> set = new HashSet<>();
        int max = 0, i = 0, j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring4(String s) {
        if (s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int j = 0, i = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            max = Math.max(max, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return max;
    }

    public static void testLengthOfLongestSubstring(String s) {
        System.out.println("Input:  " + Arrays.toString(s.toCharArray()));

        long start = System.nanoTime();
        int result = lengthOfLongestSubstring1(s);
        long end = System.nanoTime();

        long start2 = System.nanoTime();
        int result2 = lengthOfLongestSubstring2(s);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        int result3 = lengthOfLongestSubstring3(s);
        long end3 = System.nanoTime();

        long start4 = System.nanoTime();
        int result4 = lengthOfLongestSubstring4(s);
        long end4 = System.nanoTime();

        System.out.println("Output1: " + result);
        System.out.println("Output2: " + result2);
        System.out.println("Output3: " + result3);
        System.out.println("Output4: " + result4);
        System.out.println("Time1: " + (end - start) + " ns");
        System.out.println("Time2: " + (end2 - start2) + " ns");
        System.out.println("Time3: " + (end3 - start3) + " ns");
        System.out.println("Time4: " + (end4 - start4) + " ns");
        System.out.println();
    }
}