package org.lllbllllb.problems.stringtointegeratoi;

/**
 * <a href="https://leetcode.com/problems/string-to-integer-atoi">8. String to Integer (atoi)</a>
 */
class Solution {
    public int myAtoi(String s) {
        var from = 0;
        var trimmed = s.trim();

        if (trimmed.length() == 0) {
            return 0;
        }

        var to = Math.min(11, trimmed.length());
        var sign = 1;
        var head = trimmed.charAt(0);

        if (head == '+' || head == '-') {
            from++;
            to++;

            if (head == '-') {
                sign = -1;
            }
        }

        to = Math.min(to, trimmed.length());

        for (int i = from; i < trimmed.length(); i++) {
            if (trimmed.charAt(i) != '0') {
                to += i;
                break;
            }
        }

        to = Math.min(to, trimmed.length());

        for (int i = from; i < to; i++) {
            if (!Character.isDigit(trimmed.charAt(i))) {
                to = i;
                break;
            }
        }

        if (from == to) {
            return 0;
        }

        var l = sign * Long.parseLong(trimmed.substring(from, to));

        if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return (int) l;
    }
}
