import java.util.Arrays;

public class _121_BestTimetoBuyandSellStock {

    /*
    121. Best Time to Buy and Sell Stock
    You are given an array prices where prices[i] is
    the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to
    buy one stock and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction.
    If you cannot achieve any profit, return 0.

    Example 1:
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Example 2:
    Input: prices = [7,6,4,3,1]
    Output: 0

    Explanation: In this case, no transactions are done and the max profit = 0.

    Constraints:
    1 <= prices.length <= 10^5
    0 <= prices[i] <= 10^4
     */

    public static void main(String[] args) {

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        testMaxProfit(prices1);

        int[] prices2 = {7, 6, 4, 3, 1};
        testMaxProfit(prices2);

        int[] prices3 = {7, 6, 4, 3, 1, 5, 6, 7, 8, 9, 10};
        testMaxProfit(prices3);

        int[] prices4 = {7, 6, 4, 3, 1, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        testMaxProfit(prices4);

        int[] prices5 = {7, 6, 4, 3, 1, 5, 6, 7, 8, 9, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        testMaxProfit(prices5);
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {

            int price = prices[i];

            if (price < minPrice)
                minPrice = price;
            else
                maxProfit = Math.max(maxProfit, price - minPrice);

            System.out.println("price: " + price + ", minPrice: " + minPrice + ", maxProfit: " + maxProfit);
        }

        return maxProfit;
    }

    public static void testMaxProfit(int[] prices) {
        System.out.println("\n Input: prices = " + Arrays.toString(prices));

        long start = System.nanoTime();
        int result = maxProfit(prices);
        long end = System.nanoTime();

        System.out.println("Output: " + result);
        System.out.println("Execution Time: " + (end - start) + " ns\n");
    }
}