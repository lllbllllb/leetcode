package org.lllbllllb.problems.coinchange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/coin-change/">322. Coin Change</a>
 */
class Solution {

    public int coinChange(int[] coins, int amount) {
        var dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            for (var coin : coins) {
                var amountLeft = i - coin;

                if (amountLeft >= 0) {
                    dp[i] = Math.min(dp[i], dp[amountLeft] + 1);
                }
            }
        }

        return dp[amount] != amount + 1 ? dp[amount] : -1;
    }

    // Time Limit Exceeded (brute force)
    public int coinChange1(int[] coins, int amount) {
        var counts = new ArrayList<Integer>();

        dfsNoMem(coins, amount, 0, counts);

        var res = -1;

        for (var count : counts) {
            if (count < res) {
                res = count;
            }
        }

        return res;
    }

    private void dfsNoMem(int[] coins, int amount, int count, List<Integer> results) {
        if (amount == 0) {
            results.add(count);
        } else if (amount > 0) {
            for (var coin : coins) {
                dfsNoMem(coins, amount - coin, count + 1, results);
            }
        }
    }
}
