package org.lllbllllb.problems.uniquepaths;

/**
 * <a href="https://leetcode.com/problems/unique-paths/">62. Unique Paths</a>
 */
class Solution {

    public int uniquePaths(int m, int n) {
        var dp = new int[m][n];
        dp[0][0] = 1;

        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }
}
