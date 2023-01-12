package org.lllbllllb.problems.longestpalindromicsubstring;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring">...</a>
 */
class Solution {

    public String longestPalindrome(String s) {
        var len = s.length();
        var field = new boolean[len][len];
        var iMax = 0;
        var jMax = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                var x = j - i;
                var y = j;

                if (x == y) {
                    field[x][y] = true;
                } else {
                    field[x][y] = s.charAt(x) == s.charAt(y) && ((y - x) == 1 || field[x + 1][y - 1]);
                }

                if (field[x][y] && y - x > jMax - iMax) {
                    jMax = y;
                    iMax = x;
                }
            }
        }

        return s.substring(iMax, jMax + 1);
    }
}
