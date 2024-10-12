import java.util.ArrayDeque;
import java.util.Deque;

public class _20_Valid_Parentheses {
    public static void main(String[] args) {

        String s1 = "()";
        testIsValid(s1);

        String s2 = "()[]{}";
        testIsValid(s2);

        String s3 = "(]";
        testIsValid(s3);

        String s4 = "([)]";
        testIsValid(s4);

        String s5 = "{[]}";
        testIsValid(s5);
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(')
                stack.pop();
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[')
                stack.pop();
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{')
                stack.pop();
            else
                return false;
        }

        return stack.isEmpty();
    }

    public static void testIsValid(String s) {

        System.out.println("Input: " + s);

        long startTime = System.nanoTime();
        boolean result = isValid(s);
        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;

        System.out.println("Result: " + result);
        System.out.println("Execution time in nanoseconds: " + timeElapsed);
    }
}
