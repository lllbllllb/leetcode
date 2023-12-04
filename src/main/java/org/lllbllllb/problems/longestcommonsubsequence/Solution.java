package org.lllbllllb.problems.longestcommonsubsequence;

/**
 * <a href="https://leetcode.com/problems/longest-common-subsequence/">1143. Longest Common Subsequence</a>
 */
class Solution {

    // 20 ms, 47.7 MB
    public int longestCommonSubsequence(String text1, String text2) {
        var m = text1.length();
        var n = text2.length();
        var dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                var ch1 = text1.charAt(i);
                var ch2 = text2.charAt(j);

                if (ch1 == ch2) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }

        }

        return dp[m][n];
    }

    // 20 ms, 47.8 MB
    public int longestCommonSubsequence1(String text1, String text2) {
        text1 = "*" + text1;
        text2 = "*" + text2;
        var m = text1.length();
        var n = text2.length();
        var dp = new int[m][n];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                var ch1 = text1.charAt(i);
                var ch2 = text2.charAt(j);

                if (ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }

        }

        return dp[m - 1][n - 1];
    }

    // 32ms, 58.17MB
    public int longestCommonSubsequence2(String text1, String text2) {
        return dfs(text1, 0, text2, 0,  new Integer[text1.length()][text2.length()]);
    }

    private int dfs(String text1, int cursor1, String text2, int cursor2, Integer[][] mem) {
        if (cursor1 == text1.length() || cursor2 == text2.length()) {
            return 0;
        }

        if (mem[cursor1][cursor2] != null) {
            return mem[cursor1][cursor2];
        }

        var c1 = text1.charAt(cursor1);
        var c2 = text2.charAt(cursor2);

        if (c1 == c2) {
            mem[cursor1][cursor2] = 1 + dfs(text1, cursor1 + 1, text2, cursor2 + 1, mem);
        } else {
            mem[cursor1][cursor2] = Math.max(
                dfs(text1, cursor1 + 1, text2, cursor2, mem),
                dfs(text1, cursor1, text2, cursor2 + 1, mem)
            );
        }

        return mem[cursor1][cursor2];
    }
}
