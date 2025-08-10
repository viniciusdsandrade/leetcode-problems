import java.util.Arrays;
import java.util.List;

import static java.lang.IO.println;
import static java.lang.System.nanoTime;
import static util.Print.printf;

public class _20_ValidParentheses {
    /*
    20. Valid Parentheses

    Given a string 's' containing just the characters
    '(', ')', '{', '}', '[' and ']',
    determine if the input string is valid.

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

        println("=== Testando isValid com log ===");
        testIsValidWithLog(s1);
        testIsValidWithLog(s2);
//        testIsValidWithLog(s3);
//        testIsValidWithLog(s4);
        testIsValidWithLog(s5);
//        testIsValidWithLog(s6);
        testIsValidWithLog(s7);
        testIsValidWithLog(s8);

//        println("=== Testando isValid sem log ===");
//        testIsValid(s1);
//        testIsValid(s2);
//        testIsValid(s3);
//        testIsValid(s4);
//        testIsValid(s5);
//        testIsValid(s6);
//        testIsValid(s7);
//        testIsValid(s8);
    }

    /*

        A função começa rejeitando de cara Strings de tamanho ímpar (s.length() % 2 != 0),
        porque não dá para casar aberturas e fechamentos — retorna false.
        Em seguida define a lista de aberturas open = ['(', '{', '['],
        cria uma “pilha” com um char[] stack do tamanho da String e um índice top = -1 (pilha vazia).
        Percorre cada caractere c: se for abertura (open.contains(c)), faz push incrementando top e guardando c em stack[top].
        Se for fechamento, primeiro confere se a pilha está vazia (top == -1); se estiver, já falha.
        Depois checa se o fechamento casa com a abertura do topo:
        ) com (,
        } com {,
        ] com [;
        se não casar, retorna false.

        Se casar, faz pop decrementando top.

        Ao final do laço, a expressão é válida somente se não sobrou abertura pendente —
        isto é, se a pilha ficou vazia (top == -1).

     */

    public static boolean isValid(String s) {
        // Verifica se o comprimento da String é ímpar, se sim, a expressão não pode ser válida
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
                top++;
                stack[top] = c;
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

    public static boolean isValidWithLog(String s) {
        println("╔══════════════════════════════════════════╗");
        printf("║ Validando expressão: \"%s\"%n", s);
        printf("║ Tamanho: %d  | Par? %s%n", s.length(), (s.length() % 2 == 0 ? "sim" : "não"));
        println("╚══════════════════════════════════════════╝");

        // Curto-circuito: comprimento ímpar não pode balancear
        if (s.length() % 2 != 0) {
            println("⟹ Comprimento ímpar ⇒ impossível balancear. Resultado: false");
            println("— Fim da validação —");
            return false;
        }

        // Aberturas válidas
        List<Character> abertas = Arrays.asList('(', '{', '[');

        // Pilha baseada em array + índice do topo
        char[] pilha = new char[s.length()];
        int topo = -1;

        int i = 0;
        for (char c : s.toCharArray()) {
            printf("%n— Passo %-2d | pos=%-2d | char='%c' %s —%n",
                    i, i, c, (abertas.contains(c) ? "[abertura]" : "[fechamento]"));

            if (abertas.contains(c)) {
                int antes = topo;
                pilha[++topo] = c;
                printf("  ↑ PUSH '%c'        | topo: %d → %d | pilha: %s%n",
                        c, antes, topo, stackToString(pilha, topo));
            } else {
                if (topo == -1) {
                    printf("  ✖ Fechamento '%c' com pilha vazia → inválida%n", c);
                    println("— Fim da validação —");
                    return false;
                }

                char esperado = switch (c) {
                    case ')' -> '(';
                    case '}' -> '{';
                    case ']' -> '[';
                    default -> '\0';
                };
                if (esperado == '\0') {
                    printf("  ✖ Caractere '%c' não suportado → inválida%n", c);
                    println("— Fim da validação —");
                    return false;
                }

                printf("  Comparando: topo='%c'  | esperado='%c'  | fechamento='%c'%n",
                        pilha[topo], esperado, c);

                if (pilha[topo] != esperado) {
                    printf("  ✖ MISMATCH em pos %d: topo='%c' ≠ esperado='%c' → inválida%n",
                            i, pilha[topo], esperado);
                    println("— Fim da validação —");
                    return false;
                }

                int antes = topo;
                topo--;
                printf("  ↓ POP              | topo: %d → %d | pilha: %s%n",
                        antes, topo, stackToString(pilha, topo));
            }
            i++;
        }

        boolean ok = (topo == -1);
        println("");
        if (ok) {
            println("✔ Resultado: VÁLIDA (pilha vazia no fim).");
        } else {
            printf("✖ Resultado: INVÁLIDA (restaram aberturas na pilha: %s).%n",
                    stackToString(pilha, topo));
        }
        println("— Fim da validação —");
        return ok;
    }

    // Helper apenas para imprimir a pilha de forma amigável
    private static String stackToString(char[] pilha, int topo) {
        if (topo < 0) return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int j = 0; j <= topo; j++) {
            sb.append(pilha[j]);
            if (j < topo) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void testIsValidWithLog(String s) {
        println("Input:  " + s);

        long start = nanoTime();
        boolean result = isValidWithLog(s);
        long end = nanoTime();

        println("Output: " + result);
        println("Time: " + (end - start) + " ns");
        printf("Time: %.5f ms\n", (end - start) / 1_000_000.0);
        println();
    }

    public static void testIsValid(String s) {
        println("Input:  " + s);

        long start = nanoTime();
        boolean result = isValid(s);
        long end = nanoTime();

        println("Output: " + result);
        println("Time: " + (end - start) + " ns");
        printf("Time: %.5f ms\n", (end - start) / 1_000_000.0);
        println();
    }
}