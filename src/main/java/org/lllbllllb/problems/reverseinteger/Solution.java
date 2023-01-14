package org.lllbllllb.problems.reverseinteger;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/reverse-integer/">7. Reverse Integer</a>
 */
class Solution {

    public int reverse(int x) {
        if (x > -1 && x < 10) {
            return x;
        }

        var digs = new ArrayList<Integer>();
        var exp = 0;

        for (int i = 0; ; i++) {
            var mod = x % (int) Math.pow(10, i + 1);

            if (i > 9) {
                break;
            }

            var div = (int) Math.pow(10, i);

            if (div > Math.abs(x)) {
                break;
            }

            var dig = mod / div;

            exp++;
            digs.add(dig);
        }

        var res = 0;

        for (int i = 0; i < exp; i++) {
            var mult = (long) digs.get(i) * (long) Math.pow(10, exp - i - 1);

            if (mult != (int) mult) {
                return 0;
            }

            var sum = res + (int) mult;

            if (((res ^ sum) & (mult ^ sum)) < 0) {
                return 0;
            }

            res = sum;
        }

        return res;
    }
}
