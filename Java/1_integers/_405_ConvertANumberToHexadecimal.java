public class _405_ConvertANumberToHexadecimal {
    /*
    405. Convert a Number to Hexadecimal

    Given an integer num, return a string representing its hexadecimal representation.
    For negative integers, two’s complement method is used.

    All the letters in the answer string should be lowercase characters,
    and there should not be any leading zeros in the answer except for the zero itself.

    Note: You are not allowed to use any built-in library method to directly solve this problem.


    Example 1:
    Input: num = 26
    Output: "1a"

    Example 2:
    Input: num = -1
    Output: "ffffffff"


    Constraints:
    -2^31 <= num <= 2^31 - 1
     */

    public static void main(String[] args) {
        testToHex(26);
        testToHex(-1);
    }

    /**
     * Converte um número inteiro em sua representação hexadecimal.
     *
     * @param num O número inteiro a ser convertido.
     * @return A representação hexadecimal do número, em minúsculas.
     */
    public static String toHex(int num) {
        // Se o número for 0, retorne "0" diretamente.
        if (num == 0) return "0";

        // Define um array de caracteres com os dígitos hexadecimais.
        char[] hex = "0123456789abcdef".toCharArray();

        // Inicializa um StringBuilder para construir a string hexadecimal.
        StringBuilder sb = new StringBuilder();

        // Loop enquanto o número não for zero.
        while (num != 0) {
            // Obtém o dígito hexadecimal menos significativo (últimos 4 bits).
            // Insere o dígito no início do StringBuilder.
            sb.insert(0, hex[num & 15]);

            // Desloca o número 4 bits para a direita (divisão por 16).
            num >>>= 4;
        }

        // Retorna a string hexadecimal construída.
        return sb.toString();
    }

    public static void testToHex(int num) {
        System.out.println("Input: num = " + num);

        long start = System.nanoTime();
        String result = toHex(num);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Runtime: " + (end - start) + " ns\n");
    }
}
