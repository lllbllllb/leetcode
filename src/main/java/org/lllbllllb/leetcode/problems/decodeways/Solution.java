package org.lllbllllb.leetcode.problems.decodeways;

/**
 * <a href="https://leetcode.com/problems/decode-ways/">91. Decode Ways</a>
 */
class Solution {

    public int numDecodings(String s) {
        return dfs(s, 0, new Integer[s.length()]);
    }

    // dp[i] = dp[i + 1] + dp[i + 2]
    private int dfs(String s, int i, Integer[] mem) {
        var n = s.length();

        if (i == n) {
            return 1;
        }

        var cached = mem[i];

        if (cached != null) {
            return cached;
        }

        var num = s.charAt(i);

        if (num == '0') {
            return 0;
        }

        var res = dfs(s, i + 1, mem); // dp[i + 1]

        if (i < n - 1 && (num == '1' || num == '2' && s.charAt(i + 1) < '7')) {
            res += dfs(s, i + 2, mem); // dp[i + 2]
        }

        mem[i] = res;

        return res;
    }
}
