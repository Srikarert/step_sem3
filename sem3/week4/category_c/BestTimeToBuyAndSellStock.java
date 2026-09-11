/**
 * Program Name  : BestTimeToBuyAndSellStock
 * Class Name    : BestTimeToBuyAndSellStock
 * Description   : Category C - L2: Best Time to Buy and Sell Stock.
 *                 Single-pass tracking of minimum buy price and maximum profit.
 * Author        : Akula Srikar
 * Date          : 2026-09-10
 */

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];
            int currentProfit = currentPrice - minPrice;

            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }

            if (currentPrice < minPrice) {
                minPrice = currentPrice;
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   CATEGORY C - L2: BEST TIME TO BUY AND SELL STOCK   ");
        System.out.println("==================================================\n");

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int profit1 = maxProfit(prices1);
        System.out.println("Input: prices = " + Arrays.toString(prices1));
        System.out.println("Output: " + profit1 + " (buy at 1, sell at 6 => profit 5)");
        System.out.println("-------------------------------------------------");

        int[] prices2 = {7, 6, 4, 3, 1};
        int profit2 = maxProfit(prices2);
        System.out.println("Input: prices = " + Arrays.toString(prices2));
        System.out.println("Output: " + profit2 + " (prices only fall => profit 0)");
    }
}