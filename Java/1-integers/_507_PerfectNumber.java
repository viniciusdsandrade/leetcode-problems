public class _507_PerfectNumber {

    public static void main(String[] args) {
        testCheckPerfectNumber(28);
        testCheckPerfectNumber(7);
        testCheckPerfectNumber(6);
    }

    /**
     * Verifica se um número é perfeito.
     *
     * <p>Um número perfeito é um número positivo que é igual à soma de seus
     * divisores positivos, excluindo ele mesmo. Por exemplo, 6 é um número perfeito
     * porque 1, 2 e 3 são divisores de 6, e 1 + 2 + 3 = 6.</p>
     *
     * @param num o número a ser verificado
     * @return {@code true} se o número for perfeito, {@code false} caso contrário
     */
    public static boolean checkPerfectNumber(int num) {
        if (num <= 0) return false;

        int sum = 0;
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        return sum == num;
    }


    public static void testCheckPerfectNumber(int num) {
        System.out.println("\nInput: num = " + num);

        long startTime = System.nanoTime();
        boolean result = checkPerfectNumber(num);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (endTime - startTime) + "ns");
    }
}
