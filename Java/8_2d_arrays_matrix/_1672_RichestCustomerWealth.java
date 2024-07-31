import java.util.Arrays;

public class _1672_RichestCustomerWealth {

    /*
    1672. Richest Customer Wealth
    You are given an m x n integer grid accounts where accounts[i][j] is the amount of money
    the ith customer has in the jth bank.
    Return the wealth that the richest customer has.

    A customer's wealth is the amount of money they have in all their bank accounts.
    The richest customer is the customer that has the maximum wealth.

    Example 1:
    Input: accounts = [[1,2,3],[3,2,1]]
    Output: 6
    Explanation:
    1st customer has wealth = 1 + 2 + 3 = 6
    2nd customer has wealth = 3 + 2 + 1 = 6
    Both customers are considered the richest with a wealth of 6 each, so return 6.

    Example 2:
    Input: accounts = [[1,5],[7,3],[3,5]]
    Output: 10
    Explanation:
    1st customer has wealth = 6
    2nd customers have wealth = 10
    3rd customers have wealth = 8
    The 2nd customer is the richest with a wealth of 10.

    Example 3:
    Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
    Output: 17

    Constraints:
    m == accounts.length
    n == accounts[i].length
    1 <= m, n <= 50
    1 <= accounts[i][j] <= 100
     */

    public static void main(String[] args) {
        int[][] accounts1 = {
                {1, 2, 3},
                {3, 2, 1}
        };
        testMaximumWealth(accounts1);

        int[][] accounts2 = {
                {1, 5},
                {7, 3},
                {3, 5}
        };
        testMaximumWealth(accounts2);

        int[][] accounts3 = {
                {2, 8, 7},
                {7, 1, 3},
                {1, 9, 5}
        };
        testMaximumWealth(accounts3);
    }

    /**
     * Calcula a maior riqueza entre uma lista de clientes.
     * A riqueza de um cliente é definida como a soma de todas as suas contas bancárias.
     *
     * @param accounts uma matriz onde cada linha representa as contas de um cliente, e cada coluna representa
     *                 o saldo de uma conta específica.
     * @return o valor da maior riqueza encontrada entre os clientes.
     */
    public static int maximumWealth(int[][] accounts) {
        int maxWealth = 0;

        for (int[] customer : accounts) {
            int wealth = 0;
            for (int money : customer) wealth += money; // Soma o saldo de cada conta do cliente
            maxWealth = Math.max(maxWealth, wealth);    // Atualiza a maior riqueza encontrada
        }

        return maxWealth;
    }

    public static void testMaximumWealth(int[][] accounts) {
        System.out.println("accounts = " + Arrays.deepToString(accounts));

        long start = System.nanoTime();
        int result = maximumWealth(accounts);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution time: " + (end - start) + "ns\n");
    }
}
