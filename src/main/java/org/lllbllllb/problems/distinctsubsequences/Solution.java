package org.lllbllllb.problems.distinctsubsequences;

/**
 * <a href="https://leetcode.com/problems/distinct-subsequences/description/">115. Distinct Subsequences</a>
 */
class Solution {

    // 19ms, 50.34MB
    public int numDistinct(String s, String t) {
        return dfs(s, 0, t, 0, new Integer[s.length()][t.length()]);
    }

    private int dfs(String s, int sCursor, String t, int tCursor, Integer[][] mem) {
        if (tCursor == t.length()) {
            return 1;
        }

        if (s.length() - sCursor < t.length() - tCursor) {
            return 0;
        }

        if (mem[sCursor][tCursor] != null) {
            return mem[sCursor][tCursor];
        }

        var sC = s.charAt(sCursor);
        var tC = t.charAt(tCursor);

        mem[sCursor][tCursor] = 0;

        if (sC == tC) {
            mem[sCursor][tCursor] += dfs(s, sCursor + 1, t, tCursor + 1, mem);
        }

        mem[sCursor][tCursor] += dfs(s, sCursor + 1, t, tCursor, mem);

        return mem[sCursor][tCursor];
    }
}
