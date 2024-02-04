public class _557_ReverseWordsInAStringIII {

    /*
    557. Reverse Words in a String III
    Given a string s, reverse the order of characters
    in each word within a sentence while still preserving
    whitespace and initial word order.

    Example 1:
    Input: s = "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"

    Example 2:
    Input: s = "Mr Ding"
    Output: "rM gniD"

    Constraints:
    1 <= s.length <= 5 * 10^4
    s contains printable ASCII characters.
    s does not contain any leading or trailing spaces.
    There is at least one word in s.
    All the words in s are separated by a single space.
     */

    public static void main(String[] args) {
        testReverseWords("Let's take LeetCode contest");
        testReverseWords("Mr Ding");
    }

    public static String reverseWords(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                int j = i;
                while (j < s.length() && s.charAt(j) != ' ') {
                    j++;
                }
                s = reverse(s, i, j - 1);
                i = j;
            }
        }

        return s;
    }

    public static String reverse(String s, int i, int j) {
        char[] arr = s.toCharArray();
        while (i < j) {
            char temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
        return new String(arr);
    }

    public static void testReverseWords(String s) {
        System.out.println("\nInput: " + s);

        long startTime = System.nanoTime();
        String result = reverseWords(s);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (endTime - startTime) + " ns");
        System.out.printf("Runtime: %.5f ms\n", (endTime - startTime) / 1_000_000.00);
    }
}