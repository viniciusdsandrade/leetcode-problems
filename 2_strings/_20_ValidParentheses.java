import java.util.Arrays;
import java.util.List;

public class _20_ValidParentheses {
    /*
    20. Valid Parentheses
    
    Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
 
    Example 1:
    Input: s = "()"
    Output: true

    Example 2:
    Input: s = "()[]{}"
    Output: true

    Example 3:
    Input: s = "(]"
    Output: false
 
    Constraints:
    1 <= s.length <= 104
    s consists of parentheses only '()[]{}'.
     */

    public static void main(String[] args) {
        
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";
        String s6 = "]";
        String s7 = "([}}])";
        String s8 = "(([]){})";
        
        testIsValid(s1);
        testIsValid(s2);
        testIsValid(s3);
        testIsValid(s4);
        testIsValid(s5);
        testIsValid(s6);
        testIsValid(s7);
        testIsValid(s8);
        
    }

    public static boolean isValid(String s) {
        // Verifica se o comprimento da string é ímpar, se sim, a expressão não pode ser válida
        if (s.length() % 2 != 0) return false;

        // Lista de caracteres de abertura
        List<Character> open = Arrays.asList('(', '{', '[');

        // Inicializa uma pilha representada por um array de caracteres e um índice 'top' que aponta para o topo da pilha
        char[] stack = new char[s.length()];
        int top = -1;

        // Itera sobre cada caractere na string
        for (char c : s.toCharArray()) {
            // Se o caractere for uma abertura, adiciona à pilha
            if (open.contains(c)) {
                stack[++top] = c;
            } else {
                // Se o caractere for um fechamento
                // Verifica se a pilha está vazia, o que significa que não há correspondência para o fechamento
                if (top == -1) return false;

                // Verifica se o caractere de fechamento corresponde ao último caractere de abertura na pilha
                if (c == ')' && stack[top] != '(') return false;
                if (c == '}' && stack[top] != '{') return false;
                if (c == ']' && stack[top] != '[') return false;

                // Desempilha o caractere de abertura correspondente
                top--;
            }
        }

        // Verifica se a pilha está vazia no final. Se estiver, a expressão está balanceada
        return top == -1;
    }
    
    public static void testIsValid(String s) {
        System.out.println("Input:  " + Arrays.toString(s.toCharArray()));
        
        long start = System.nanoTime();
        boolean result = isValid(s);
        long end = System.nanoTime();
        
        System.out.println("Output: " + result);
        System.out.println("Time: " + (end - start) + " ns");
        System.out.printf("Time: %.5f ms\n", (end - start) / 1000000.0);
        System.out.println();
    }
}
