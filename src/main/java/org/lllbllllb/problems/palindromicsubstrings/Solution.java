package org.lllbllllb.problems.palindromicsubstrings;

/**
 * <a href="https://leetcode.com/problems/palindromic-substrings/">647. Palindromic Substrings</a>
 */
class Solution {

    // 4 ms, 40.5 MB
    public int countSubstrings(String s) {
        var res = 0;
        var n = s.length();

        for (int i = 0; i < n; i++) {
            var left = i;
            var right = i;

            // odd
            while (left > -1 && right < n && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }

            left = i - 1;
            right = i;

            // even
            while (left > -1 && right < n && s.charAt(left) == s.charAt(right)) {
                res++;
                left--;
                right++;
            }
        }

        return res;
    }
}
