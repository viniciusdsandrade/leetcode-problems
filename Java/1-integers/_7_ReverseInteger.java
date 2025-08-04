import static java.lang.System.nanoTime;

public class _7_ReverseInteger {

    /*
    7. Given a signed 32-bit integer x, return x with its digits reversed.
    If reversing x causes the value to go outside the signed 32-bit integer
    range [-231, 231 - 1], then return 0.

    Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

    Example 1:
    Input: x = 123
    Output: 321

    Example 2:
    Input: x = -123
    Output: -321

    Example 3:
    Input: x = 120
    Output: 21

    Constraints:
    -2^31 <= x <= 2^31 - 1
    */

    public static void main(String[] ignoredArgs) {
//        testReverse(123);
//        testReverse(-123);
//        testReverse(120);

        testReverseVerbose(123);
        testReverseVerbose(-123);
        testReverseVerbose(120);
    }

    public static int reverse(int x) {

        if (x == 0) return 0;

        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            // Ao pegar o resto da divisão do número a ser "revertido" por 10, obtemos o seu último dígito
            // Exemplo: 123/10 = 12, resto 3. Portanto, o último dígito é 3.

            // Quando dividimos por 10, estamos efetivamente removendo o último dígito de x.
            // Exemplo 123/10 = 12.
            // (na vdd é 12.3, mas quando dividimos dois inteiros, o resultado é um inteiro, ou seja, a parte decimal é descartada)
            // Isso é feito para preparar x para a próxima iteração, onde o próximo dígito será processado.

            // Usamos a fórmula reversed = reversed * 10 + digit;
            // Como a variável reverse sempre começa com 0, na primeira iteração, reversed sempre vai ser igual ao último digito do número(digit)
            // Exemplo, se x = 123,
            // Na primeira iteração digit será 3 e reversed será 0 * 10 + 3 = 3.
            // Na segunda iteração, digit será 2, pois 12 % 10 = 2, e reversed será 3 * 10 + 2 = 32.
            // Na terceira iteração, digit será 1, pois 1 % 10 = 1, e reversed será 32 * 10 + 1 = 321.

            if (reversed > Integer.MAX_VALUE / 10 ||
                    (reversed == Integer.MAX_VALUE / 10 && digit > 7))
                return 0;

            // Check for underflow
            if (reversed < Integer.MIN_VALUE / 10 ||
                    (reversed == Integer.MIN_VALUE / 10 && digit < -8))
                return 0;

            x = x / 10;
            reversed = reversed * 10 + digit;
        }

        return reversed;
    }

    public static int reverseVerbose(int x) {
        System.out.println("Iniciando reverseVerbose com x = " + x);
        if (x == 0) {
            System.out.println("x é zero — resultado imediato: 0");
            return 0;
        }

        int reversed = 0;
        System.out.println("--------------------------------------------------");

        while (x != 0) {
            int digit = x % 10;
            System.out.println("Extrai dígito:");
            System.out.println("  digit = x % 10 = " + digit);
            System.out.println("  x antes da divisão = " + x);

            // Overflow check (limite positivo)
            System.out.println("  reversed = " + reversed);

            if (reversed > Integer.MAX_VALUE / 10 ||
                (reversed == Integer.MAX_VALUE / 10 && digit > 7)) {
                System.out.println("  → Detectado overflow! Retornando 0.");
                return 0;
            }

            // Underflow check (limite negativo)
            System.out.println("  reversed = " + reversed);
            if (reversed < Integer.MIN_VALUE / 10 ||
                (reversed == Integer.MIN_VALUE / 10 && digit < -8)) {
                System.out.println("  → Detectado underflow! Retornando 0.");
                return 0;
            }

            // Atualiza x e reversed
            x = x / 10;
            System.out.println("  x após x = x/10 -> " + x);
            reversed = reversed * 10 + digit;
            System.out.println("  reversed após reversed = reversed*10 + digit -> " + reversed);
            System.out.println("--------------------------------------------------");
        }

        System.out.println("Final do loop. Valor invertido = " + reversed);
        return reversed;
    }

    private static void testReverseVerbose(int x) {
        System.out.println("Input: x = " + x);

        long startTime = nanoTime();
        int result = reverseVerbose(x);
        long endTime = nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution time: " + (endTime - startTime) + "ns\n");
    }

    private static void testReverse(int x) {
        System.out.println("Input: x = " + x);

        long startTime = nanoTime();
        int result = reverse(x);
        long endTime = nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution time: " + (endTime - startTime) + "ns\n");
    }
}