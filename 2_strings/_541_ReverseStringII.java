import static java.util.Collections.reverse;

public class _541_ReverseStringII {

    /*
    541. Reverse String II
    
    Given a string s and an integer k,  reverse the first k characters for every 
    2k characters counting from the start of the string.
    
    If there are fewer than k characters left, reverse all of them. If there are less 
    than 2k but greater than or equal to k characters, then reverse 
    the first k characters and leave the other as original.
    
    Example 1:
    Input: s = "abcdefg", k = 2
    Output: "bacdfeg"
    
    Example 2:
    Input: s = "abcd", k = 2
    Output: "bacd"
     
    Constraints:
    1 <= s.length <= 10^4
    s consists of only lowercase English letters.
    1 <= k <= 10^4
     */

    public static void main(String[] args) {
        testReverseStr("abcdefg", 2);
        testReverseStr("abcd", 2);
        testReverseStr("ab", 2);
        testReverseStr("a", 2);
    }

    public static String reverseStr(String s, int k) {
        if (s == null || s.isEmpty() || s.length() > 10_000 || k < 1 || k > 10_000)
            return null;

        char[] chars = s.toCharArray(); // Converte a string para um array de caracteres

        for (int i = 0; i < chars.length; i += 2 * k) {
            int start = i;
            int end = Math.min(i + k - 1, chars.length - 1);
            reverse(chars, start, end);
        }

        return String.valueOf(chars); // Converte o array de caracteres para uma string
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    public static void testReverseStr(String s, int k) {
        System.out.println("\nInput: s = " + s + ", k = " + k);

        long start = System.nanoTime();
        String result = reverseStr(s, k);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Time: " + (end - start) + " ns");
        System.out.printf("Time: %.5f ms\n", (end - start) / 1_000_000.0);
    }
}