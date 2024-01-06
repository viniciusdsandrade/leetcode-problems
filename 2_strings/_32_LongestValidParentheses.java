import java.util.Stack;

public class _32_LongestValidParentheses {
    /*
    32. Longest Valid Parentheses
    Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses  substring

    Example 1:
    Input: s = "(()"
    Output: 2
    Explanation: The longest valid parentheses substring is "()".

    Example 2:
    Input: s = ")()())"
    Output: 4
    Explanation: The longest valid parentheses substring is "()()".

    Example 3:
    Input: s = ""
    Output: 0

    Constraints:
    0 <= s.length <= 3 * 10^4
    s[i] is '(', or ')'.
     */

    public static void main(String[] args) {
        testLongestValidParentheses("(()");
        testLongestValidParentheses(")()())");
        testLongestValidParentheses("");
        testLongestValidParentheses("()(()");
    }

    public static int longestValidParentheses(String s) {

        // Limite de borda
        if (s.length() < 2 || s.length() > 3 * Math.pow(10, 4)) return 0;


        Stack<Integer> stack = new Stack<>(); // Pilha para armazenar os índices dos caracteres de abertura
        stack.push(-1); // Inicializa a pilha com -1
        int max = 0; // Variável para armazenar o tamanho da maior substring válida

        // Itera sobre a string
        for (int i = 0; i < s.length(); i++) {
            // Se o caractere atual for um abre parênteses, adiciona seu índice à pilha
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                // Se o caractere atual for um fecha parênteses,
                // remove o índice do abre parênteses correspondente da pilha
                stack.pop();

                // Se a pilha estiver vazia, adiciona o índice do fecha parênteses atual à pilha
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    // Se a pilha não estiver vazia, calcula o tamanho da substring válida atual
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void testLongestValidParentheses(String s) {
        System.out.println("Input:  " + s);

        long start = System.nanoTime();
        int result = longestValidParentheses(s);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Time: " + (end - start) + " ns");
        System.out.printf("Time: %.5f ms\n", (end - start) / 1_000_000.0);
        System.out.println();
    }
}
