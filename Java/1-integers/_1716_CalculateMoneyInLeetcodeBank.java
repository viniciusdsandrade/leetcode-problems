public class _1716_CalculateMoneyInLeetcodeBank {

    /*
    1716. Calculate Money in Leetcode Bank

    Hercy wants to save money for his first car.
    He puts money in the Leetcode bank every day.

    He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday,
    he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
    Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.

    Example 1:
    Input: n = 4
    Output: 10
    Explanation: After the 4th day, the total is 1 + 2 + 3 + 4 = 10.

    Example 2:
    Input: n = 10
    Output: 37
    Explanation: After the 10th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37.
    Notice that on the 2nd Monday, Hercy only puts in $2.

    Example 3:
    Input: n = 20
    Output: 96
    Explanation: After the 20th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96.
     */

    public static void main(String[] args) {
        testTotalMoney(4);
        testTotalMoney(10);
        testTotalMoney(20);
    }

    /**
     * Calcula o total de dinheiro acumulado ao longo de n semanas, dado o número de dias n.
     * Cada semana aumenta o valor acumulado, com um valor adicional para cada dia na semana.
     *
     * @param n O número total de dias para os quais calcular o dinheiro acumulado.
     * @return O total de dinheiro acumulado ao longo de n dias.
     */
    public static int totalMoney(int n) {
        int total = 0;
        int week = 0;
        int day = 0;

        for (int i = 0; i < n; i++) {

            // Verifica se é o início de uma nova semana (a cada 7 dias)
            if (i % 7 == 0) {
                week++;
                day = 0; // Reinicia o contador de dias da semana
            }

            total += week + day;
            day++; // Incrementa o dia atual dentro da semana
        }

        return total; // Retorna o total acumulado de dinheiro
    }

    public static void testTotalMoney(int n) {
        System.out.println("Input: n = " + n);

        long startTime = System.nanoTime();
        int result = totalMoney(n);
        long endTime = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (endTime - startTime) + "ns\n");
    }
}
