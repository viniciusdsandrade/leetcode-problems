public class _67_AddBinary {
    /*
    67. Add Binary

    Given two binary strings a and b, return their sum as a binary string.

    Example 1:
    Input: a = "11", b = "1"
    Output: "100"

    Example 2:
    Input: a = "1010", b = "1011"
    Output: "10101"

    Constraints:
    1 <= a.length, b.length <= 10^4
    a and b consist only of '0' or '1' characters.
    Each string does not contain leading zeros except for the zero itself.
     */

    public static void main(String[] args) {
        testAddBinary("11", "1");
        testAddBinary("1010", "1011");
        testAddBinary("0", "0");
        testAddBinary("0", "1");
        testAddBinary("1", "0");
        testAddBinary("1", "1");
        testAddBinary("111", "100");
        testAddBinary("111", "111");
    }

=
    public static String addBinary(String a, String b) {
        StringBuilder answer = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {

            // Inicia a soma com o valor do carry (carry representa o bit que é "levado" para a próxima posição)
            int sum = carry;

            // Se ainda há bits em 'a', adiciona o bit atual de 'a' à soma
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            // Se ainda há bits em 'b', adiciona o bit atual de 'b' à soma
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            // Adiciona o bit menos significativo da soma ao resultado final
            answer.append(sum % 2);

            // Calcula o novo carry (o que será "levado" para a próxima posição)
            carry = sum / 2;
        }

        // Se ainda há um carry não processado, adiciona-o ao resultado final
        if (carry != 0) answer.append(carry);

        return answer.reverse().toString();
    }

    public static void testAddBinary(String a, String b) {
        System.out.println("\nInput: a = " + a + ", b = " + b);

        long startTime = System.nanoTime();
        String answer = addBinary(a, b);
        long endTime = System.nanoTime();

        System.out.println("Answer: " + answer);
        System.out.printf("Execution time: %d ns\n", (endTime - startTime));
        System.out.printf("Execution time: %.5f ms\n", (endTime - startTime) / 1_000_000.00);
    }
}