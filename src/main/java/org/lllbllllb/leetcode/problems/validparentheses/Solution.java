package org.lllbllllb.leetcode.problems.validparentheses;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">20. Valid Parentheses</a>
 */
class Solution {

    public boolean isValid(String s) {
        var track = new char[s.length()];
        var cursor = 0;

        for (int i = 0; i < s.length(); i++) {
            var br = s.charAt(i);

            switch (br) {
                case '{' -> track[cursor++] = '}';
                case '[' -> track[cursor++] = ']';
                case '(' -> track[cursor++] = ')';
                default -> {
                    if (cursor == 0 || track[--cursor] != br) {
                        return false;
                    }
                }
            }
        }

        return cursor == 0;
    }
}
