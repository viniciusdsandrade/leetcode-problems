public class ReverseString {

    /*
    Write a function that reverses a string. The input string is given as an array of characters s.

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
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};

        long start = System.nanoTime();
        reverseString(s);
        long end = System.nanoTime();

        System.out.println("Time: " + (end - start) + " ns");
        System.out.println("Time: " + (end - start) / 1000000 + " ms");
        for (char c : s) {
            System.out.print(c + " ");
        }
        System.out.println();

        long start2 = System.nanoTime();  // Correção aqui
        reverseString(s2);
        long end2 = System.nanoTime();  // Correção aqui
        System.out.println();

        System.out.println((end2 - start2) + " ns");  // Correção aqui
        System.out.println((end2 - start2) / 1000000 + " ms");  // Correção aqui

        for (char c : s2) {
            System.out.print(c + " ");
        }
    }

    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while(left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }
}
