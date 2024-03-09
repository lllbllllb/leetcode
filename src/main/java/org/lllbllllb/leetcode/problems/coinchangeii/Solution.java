package org.lllbllllb.leetcode.problems.coinchangeii;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/coin-change-ii/description/">518. Coin Change II</a>
 */
// 2ms, 40.48MB
class Solution {

    public int change(int amount, int[] coins) {
        var dp = new int[amount + 1];
        dp[0] = 1;

        for (var coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[amount];
    }

}

// 9ms, 44.52MB
class Solution1 {

    public int change1(int amount, int[] coins) {
        Arrays.sort(coins);

        var dp = new int[amount + 1][coins.length + 1];

        Arrays.fill(dp[0], 1);

        for (int i = 1; i < amount + 1; i++) {
            for (int j = coins.length - 1; j > -1; j--) {
                var coin = coins[j];
                var rem = i - coin;

                if (rem < 0) {
                    continue;
                }

                dp[i][j] = dp[rem][j] + dp[i][j + 1];
            }
        }

        return dp[amount][0];
    }
}

// 145ms, 52.27MB
class Solution2 {

    public int change(int amount, int[] coins) {
        return dfs(amount, coins, 0, new Integer[amount + 1][coins.length]);
    }

    private int dfs(int amount, int[] coins, int threshold, Integer[][] mem) {
        if (amount < 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        var changes = 0;

        for (int i = 0; i < coins.length; i++) {
            var coin = coins[i];

            if (coin >= threshold) {
                if (mem[amount][i] == null) {
                    mem[amount][i] = dfs(amount - coin, coins, coin, mem);
                }

                changes += mem[amount][i];
            }
        }

        return changes;
    }
}

// Time Limit Exceeded
class Solution3 {

    public int change(int amount, int[] coins) {
        return dfs(amount, coins, 0);
    }

    private int dfs(int amount, int[] coins, int threshold) {
        if (amount < 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        var changes = 0;

        for (var coin : coins) {
            if (coin >= threshold) {
                changes += dfs(amount - coin, coins, coin);
            }
        }

        return changes;
    }
}