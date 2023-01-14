package org.lllbllllb.problems.besttimetobuyandsellstockii;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">122. Best Time to Buy and Sell Stock II</a>
 */
class Solution {

    // 0ms
    public int maxProfit(int[] prices) {
        var profit = 0;
        var stockCount = 0;

        for (int i = 0; i < prices.length; i++) {
            var today = prices[i];

            if (stockCount > 0) {
                profit += today;
                stockCount--;
            }

            if (i < prices.length - 1) {
                var tomorrow = prices[i + 1];

                if (tomorrow > today) {
                    profit -= today;
                    stockCount++;
                }
            }
        }

        return profit;
    }

    // 1ms
    public int maxProfit1(int[] prices) {
        var profit = 0;

        for (int i = 1; i < prices.length; i++) {
            var yesterday = prices[i - 1];
            var today = prices[i];

            if (today > yesterday) {
                profit += (today - yesterday);
            }
        }

        return profit;
    }
}
