public class _70_ClimbingStairs {

    /*
    70. Climbing Stairs

    You are climbing a staircase.
    It takes n steps to reach the top.

    Each time you can either climb 1 or 2 steps.
    In how many distinct ways can
    you climb to the top?


    Example 1:
    Input: n = 2
    Output: 2
    Explanation: There are two ways to climb to the top.
    1. 1 step + 1 step
    2. 2 steps

    Example 2:
    Input: n = 3
    Output: 3
    Explanation: There are three ways to climb to the top.
    1. 1 step + 1 step + 1 step
    2. 1 step + 2 steps
    3. 2 steps + 1 step

    Constraints:
    1 <= n <= 45
     */

    /**
     * Calcula o número de maneiras distintas de subir uma escada de 'n' degraus,
     * onde a cada passo é possível subir 1 ou 2 degraus.
     *
     * @param n o número de degraus na escada
     * @return o número de maneiras distintas de subir a escada
     */
    public static int climbStairs(int n) {
        // Caso base: se houver apenas 1 degrau, há apenas 1 maneira de subir.
        if (n == 1) return 1;

        // Cria um array para armazenar o número de maneiras de alcançar cada degrau.
        int[] dp = new int[n + 1];

        // Define que há 1 maneira de alcançar o primeiro degrau.
        dp[1] = 1;

        // Define que há 2 maneiras de alcançar o segundo degrau.
        dp[2] = 2;

        // Preenche o array 'dp' com o número de maneiras de alcançar cada degrau
        // a partir do terceiro, usando a soma das maneiras de alcançar os dois
        // degraus anteriores.
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Retorna o número de maneiras de alcançar o último degrau.
        return dp[n];
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) testClimbStairs(i);
    }

    public static void testClimbStairs(int n) {
        System.out.println("Input: n = " + n);

        long start = System.nanoTime();
        int output = climbStairs(n);
        long end = System.nanoTime();

        long runtime = end - start;
        long ms = runtime / 1_000_000;

        System.out.println("Output: " + output);
        System.out.println("Runtime: " + runtime + "ns\n");
        System.out.println("Runtime: " + ms + "ms\n");
    }
}
