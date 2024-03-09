package org.lllbllllb.leetcode.problems.interleavingstring;

class Solution {

    // 0ms, 40.31MB
    public boolean isInterleave(String s1, String s2, String s3) {
        return dfs(s1, 0, s2, 0, s3, 0, new boolean[s1.length()][s2.length()]);
    }

    private boolean dfs(String s1, int s1Cursor, String s2, int s2Cursor, String s3, int s3Cursor, boolean[][] invalid) {
        if (s3Cursor == s3.length()) {
            return s1Cursor == s1.length() && s2Cursor == s2.length();
        }

        if (s1Cursor < s1.length() && s2Cursor < s2.length()) {
            var s1Char = s1.charAt(s1Cursor);
            var s2Char = s2.charAt(s2Cursor);

            if (invalid[s1Cursor][s2Cursor]) {
                return false;
            }

            var s3Char = s3.charAt(s3Cursor);
            var valid = s1Char == s3Char && dfs(s1, s1Cursor + 1, s2, s2Cursor, s3, s3Cursor + 1, invalid)
                || s2Char == s3Char && dfs(s1, s1Cursor, s2, s2Cursor + 1, s3, s3Cursor + 1, invalid);

            invalid[s1Cursor][s2Cursor] = !valid;

            return valid;
        } else if (s1Cursor < s1.length()) {
            return isStringsTailsSame(s1, s1Cursor, s3, s3Cursor);
        } else if (s2Cursor < s2.length()) {
            return isStringsTailsSame(s2, s2Cursor, s3, s3Cursor);
        } else {
            return false;
        }
    }

    // 2ms, 41.58MB
    public boolean isInterleave1(String s1, String s2, String s3) {
        return dfs(s1, 0, s2, 0, s3, 0, new Boolean[s3.length()][s1.length()], new Boolean[s3.length()][s2.length()]);
    }

    private boolean dfs(String s1, int s1Cursor, String s2, int s2Cursor, String s3, int s3Cursor, Boolean[][] mem1, Boolean[][] mem2) {
        if (s3Cursor == s3.length()) {
            return s1Cursor == s1.length() && s2Cursor == s2.length();
        }

        if (s1Cursor < s1.length() && s2Cursor < s2.length()) {
            var s1Char = s1.charAt(s1Cursor);
            var s2Char = s2.charAt(s2Cursor);
            var s3Char = s3.charAt(s3Cursor);

            if (mem1[s3Cursor][s1Cursor] == null) {
                mem1[s3Cursor][s1Cursor] = s1Char == s3Char && dfs(s1, s1Cursor + 1, s2, s2Cursor, s3, s3Cursor + 1, mem1, mem2);
            }
            if (mem2[s3Cursor][s2Cursor] == null) {
                mem2[s3Cursor][s2Cursor] = s2Char == s3Char && dfs(s1, s1Cursor, s2, s2Cursor + 1, s3, s3Cursor + 1, mem1, mem2);
            }

            return mem1[s3Cursor][s1Cursor] || mem2[s3Cursor][s2Cursor];
        } else if (s1Cursor < s1.length()) {
            return isStringsTailsSame(s1, s1Cursor, s3, s3Cursor);
        } else if (s2Cursor < s2.length()) {
            return isStringsTailsSame(s2, s2Cursor, s3, s3Cursor);
        } else {
            return false;
        }
    }

    private boolean isStringsTailsSame(String s, int s1Cursor, String s3, int s2Cursor) {
        while (s1Cursor < s.length() && s2Cursor < s3.length()) {
            var s1Char = s.charAt(s1Cursor);
            var s2Char = s3.charAt(s2Cursor);

            if (s1Char != s2Char) {
                return false;
            }

            s1Cursor++;
            s2Cursor++;
        }

        return s1Cursor == s.length() && s2Cursor == s3.length();
    }

    // 8ms, 40.38MB
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        var dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[s1.length()][s2.length()] = true;

        for (int i = s1.length(); i > -1; i--) {
            for (int j = s2.length(); j > -1; j--) {
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dp[i + 1][j]
                    || j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dp[i][j + 1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[0][0];
    }

    // 10ms, 40.42MB
    public boolean isInterleave3(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        s1 = "*" + s1;
        s2 = "*" + s2;
        s3 = "*" + s3;
        var dp = new boolean[s1.length()][s2.length()];
        dp[0][0] = true;

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (i > 0 && s1.charAt(i) == s3.charAt(i + j) && dp[i - 1][j]
                    || j > 0 && s2.charAt(j) == s3.charAt(i + j) && dp[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        return dp[s1.length() - 1][s2.length() - 1];
    }
}
