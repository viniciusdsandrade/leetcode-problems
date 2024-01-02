import java.util.Scanner;

public class PalindromeNumber {

    /*
    Given an integer, return true if it is a palindrome integer, and false otherwise.
    *
    * Example 1:
    * Input: x = 121
    * Output: true
    *
    * Example 2:
    * Input: x = -121
    * Output: false
    * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
    *
    * Example 3:
    * Input: x = 10
    * Output: false

    Constraints:
    -2^31 <= x <= 2^31 - 1
    */

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a number: ");
            int x = scanner.nextInt();

            long startTime = System.nanoTime();

            boolean answer = isPalindrome(x);

            long endTime = System.nanoTime();

            System.out.printf("Answer: %b\n", answer);
            System.out.println("Execution time: " + (endTime - startTime) + " ns");
            System.out.println("Execution time: " + (endTime - startTime) / 1000000 + " ms");
        }
    }

    public static boolean isPalindrome(int x) {

        if (x < 0)
            return false;

        if (x != 0 && x % 10 == 0)
            return false;

        String s = Integer.toString(x);

        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }

        return true;
    }
}
