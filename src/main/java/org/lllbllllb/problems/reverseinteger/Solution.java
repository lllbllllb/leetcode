package org.lllbllllb.problems.reverseinteger;

/**
 * <a href="https://leetcode.com/problems/reverse-integer/">7. Reverse Integer</a>
 */
// 1ms, 39.96MB
class Solution {

    public int reverse(int x) {
        var positive = x > 0;
        x = Math.abs(x);
        var res = 0;

        while (x > 0) {
            if (Integer.MAX_VALUE / 10 < res) {
                return 0;
            }

            res = res * 10 + x % 10;
            x /= 10;
        }

        return positive ? res : -res;
    }
}

// 1ms, 39.55MB
class Solution1 {

    public int reverse(int x) {
        if (x > -10 && x < 10) {
            return x;
        }

        var res = x % 10;
        x /= 10;

        while (x != 0) {
            var prev = res;
            res = res * 10 + x % 10;
            x /= 10;

            if (prev != 0 && res / prev < 10) {
                return 0;
            }
        }

        return res;
    }
}
