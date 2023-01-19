package org.lllbllllb.problems.dividetwointegers;

/**
 * <a href="https://leetcode.com/problems/divide-two-integers/">29. Divide Two Integers</a>
 */
class Solution {

    // 1ms;
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        var sign = (dividend > 0) == (divisor > 0) ? 1 : -1;

        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        var tmp = dividend;
        var count = 0;

        while (tmp < divisor) {
            var shift = 0;

            for (var pow = divisor; tmp < pow && pow < 0; pow = divisor << shift) {
                shift++;
            }

            shift--;

            tmp -= (divisor << shift);
            count -= 1 << shift;
        }

        if (tmp == divisor && (sign < 0 || count - 1 > Integer.MIN_VALUE)) {
            count--;
        }

        return -sign * count;
    }

    // 2295 ms
    public int divide1(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }

        if (divisor == 1) {
            return dividend;
        }

        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }

            return -dividend;
        }

        var sign = (dividend > 0) == (divisor > 0) ? 1 : -1;

        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;

        var tmp = dividend;
        var count = 0;

        while (tmp - divisor < 1) {
            tmp -= divisor;
            count++;
        }

        return sign * count;
    }
}
