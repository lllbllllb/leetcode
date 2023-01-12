package org.lllbllllb.problems.reversestring;

/**
 * <a href="https://leetcode.com/problems/reverse-string/">344. Reverse String</a>
 */
class Solution {

    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            var left = s[i];

            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = left;
        }
    }
}
