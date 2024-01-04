import java.util.Arrays;

public class _344_ReverseString {

    /*
    344. Write a function that reverses a string. 
    The input string is given as an array of characters s.
    You must do this by modifying the input array in-place with O(1) extra memory.

    Example 1:
    Input: s = ["h","e","l","l","o"]
    Output: ["o","l","l","e","h"]

    Example 2:
    Input: s = ["H","a","n","n","a","h"]
    Output: ["h","a","n","n","a","H"]

    Constraints:
    1 <= s.length <= 105
    s[i] is a printable ascii character.
     */

    public static void main(String[] args) {
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};

        testReverseString(s1);
        testReverseString(s2);
    }

    private static void testReverseString(char[] s) {
        System.out.println("Input:  " + Arrays.toString(s));

        long start = System.nanoTime();
        reverseString(s);
        long end = System.nanoTime();

        System.out.print("Output: ");
        printCharVector(s);
        System.out.println("\nTime: " + (end - start) + " ns");
        System.out.printf("Time: %.5f ms\n", (end - start) / 1_000_000.0);
        System.out.println();
    }

    private static void printCharVector(char[] s) {
        System.out.print("[");
        for (char c : s) {
            System.out.print(c + ", ");
        }
        System.out.print("\b\b]");
    }

    public static void reverseString(char[] s) {

        int left = 0;
        int right = s.length - 1;

        for (int i = 0; i < s.length / 2; i++) {
            swap(s, left, right);
            left++;
            right--;
        }
    }

    public static void swap(char[] s, int left, int right) {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
