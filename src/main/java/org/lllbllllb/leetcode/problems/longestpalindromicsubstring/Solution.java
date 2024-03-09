package org.lllbllllb.leetcode.problems.longestpalindromicsubstring;

/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring">5. Longest Palindromic Substring</a>
 */
class Solution {

    // 21 ms, 42.1 MB
    public String longestPalindrome(String s) {
        var n = s.length();
        var resStart = 0;
        var resEnd = 0;

        for (int i = 0; i < n; i++) {
            // odd
            var left = i;
            var right = i;

            while (left > -1 && right < n && s.charAt(left) == s.charAt(right)) {
                if (resEnd - resStart < right - left) {
                    resStart = left;
                    resEnd = right;
                }

                left--;
                right++;
            }

            // even
            left = i - 1;
            right = i;

            while (left > -1 && right < n && s.charAt(left) == s.charAt(right)) {
                if (resEnd - resStart < right - left) {
                    resStart = left;
                    resEnd = right;
                }

                left--;
                right++;
            }
        }

        return s.substring(resStart, resEnd + 1);
    }

    // 243 ms, 45.3 MB
    public String longestPalindrome1(String s) {
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
