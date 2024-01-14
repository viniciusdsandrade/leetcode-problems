public class _28_FindTheIndexOfTheFirstOccurrenceInAString {

    /*

    28. Find the Index of the First Occurrence in a String
    Given two strings needle and haystack, return the index of the
    first occurrence of needle in haystack, or -1 if needle is not
    part of haystack.

    Example 1:
    Input: haystack = "sadbutsad", needle = "sad"
    Output: 0
    Explanation: "sad" occurs at index 0 and 6.
    The first occurrence is at index 0, so we return 0.

    Example 2:
    Input: haystack = "leetcode", needle = "leeto"
    Output: -1
    Explanation: "leeto" did not occur in "leetcode", so we return -1.

    Constraints:
1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
     */

    public static void main(String[] args) {

        testStrStr("sadbutsad", "sad");
        testStrStr("leetcode", "leeto");
        testStrStr("hello", "ll");
        testStrStr("aaaaa", "bba");
        testStrStr("", "");
        testStrStr("a", "");
        testStrStr("", "a");
        testStrStr("mississippi", "issip");
        testStrStr("mississippi", "issipi");
        testStrStr("mississippi", "pi");
        testStrStr("mississippi", "issipi");
        testStrStr("mississippi", "issipi");
        testStrStr("mississippi", "issipi");

    }

    public static int strStr(String haystack, String needle) {

        if (needle.length() > haystack.length()) return -1;

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            int j = 0;
            while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == needle.length()) return i;
        }

        return -1;
    }

    /*

    public int strStr(String haystack, String needle) {
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
    return -1;
    }
     */

    public static void testStrStr(String haystack, String needle) {
        System.out.println("\nInput:  " + haystack + ", " + needle);

        long start = System.nanoTime();
        int result = strStr(haystack, needle);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Time: " + (end - start) + " ns");
        System.out.printf("Time: %.5f ms\n", (end - start) / 1_000_000.0);
    }

}
