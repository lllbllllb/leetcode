package org.lllbllllb.problems.besttimetobuyandsellstockwithcooldown;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/">309. Best Time to Buy and Sell Stock with Cooldown</a>
 */
// 1 ms, 41.66MB
class Solution {

    public int maxProfit(int[] prices) {
        var mem = new Integer[prices.length][4];

        return dfs(prices, 0, 3, mem);
    }

    // 0 - buy; 1 - buy cooldown; 2 - sell; 3 - sell cooldown
    private int dfs(int[] prices, int cursor, int state, Integer[][] profits) {
        if (cursor == prices.length) {
            return 0;
        }

        var price = prices[cursor];

        if (profits[cursor][state] != null) {
            return profits[cursor][state];
        }

        var nextCursor = cursor + 1;

        if (state == 0 || state == 1) {
            var cooldown = dfs(prices, nextCursor, 1, profits);
            var sell = dfs(prices, nextCursor, 2, profits) + price;

            profits[cursor][state] = Math.max(cooldown, sell);
        } else if (state == 3) {
            var cooldown = dfs(prices, nextCursor, 3, profits);
            var buy = dfs(prices, nextCursor, 0, profits) - price;

            profits[cursor][state] = Math.max(cooldown, buy);
        } else {
            var cooldown = dfs(prices, nextCursor, 3, profits);

            profits[cursor][state] = cooldown;
        }

        return profits[cursor][state];
    }

}

// Time Limit Exceeded
class Solution1 {

    public int maxProfit(int[] prices) {
        return dfs(prices, 0, 0, -1, 0);
    }

    // -1 - buy;  1 - sell; 0 - cooldown
    private int dfs(int[] prices, int cursor, int currentState, int nextState, int profit) {
        if (cursor == prices.length) {

            return profit;
        }

        var cooldownProfit = dfs(prices, cursor + 1, 0, nextState, profit);

        if (currentState == 0 || currentState == -1) {
            var price = prices[cursor];
            var currProfit = profit + price * nextState;
            var buySellProfit = dfs(prices, cursor + 1, nextState, nextState * -1, currProfit);

            return Math.max(cooldownProfit, buySellProfit);
        }

        return cooldownProfit;
    }
}