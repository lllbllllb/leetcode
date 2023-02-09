package org.lllbllllb.problems.besttimetobuyandsellstock;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/">121. Best Time to Buy and Sell Stock</a>
 */
class Solution {

    public int maxProfit(int[] prices) {
        var min = prices[0];
        var max = prices[0];
        var profit = 0;

        for (var price : prices) {
            if (price > max) {
                max = price;
            }

            if (price < min) {
                min = price;
                max = price;
            }

            profit = Math.max(profit, max - min);
        }

        return profit;
    }
}
