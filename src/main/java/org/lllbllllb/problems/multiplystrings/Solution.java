package org.lllbllllb.problems.multiplystrings;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/multiply-strings/">43. Multiply Strings</a>
 */
// 3ms, 42.27MB
class Solution {

    public String multiply(String num1, String num2) {
        var product = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i != -1; i--) {
            var pCursor = product.length - num1.length() + i;
            var n1 = num1.charAt(i) - '0';

            for (int j = num2.length() - 1; j != -1 ; j--) {
                var n2 = num2.charAt(j) - '0';
                var tmp = (n1 * n2) + product[pCursor];
                product[pCursor] = tmp % 10;

                if (tmp > 9) {
                    product[pCursor - 1] += (tmp / 10);
                }

                pCursor--;
            }
        }

        var offset = 0;

        for (offset = 0; offset < product.length; offset++) {
            if (product[offset] != 0) {
                break;
            }
        }

        var res = new StringBuilder();

        for (int i = offset; i < product.length; i++) {
            res.append(product[i]);;
        }

        return res.isEmpty() ? "0" : res.toString();
    }
}

// 49ms, 45.13MB
class Solution1 {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        if (num2.length() > num1.length()) {
            var tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        var levels = new ArrayList<String>();

        for (int i = num2.length() - 1; i != -1; i--) {
            var ch2 = num2.charAt(i);
            var level = multiply(num1, ch2);

            levels.add(level);
        }

        var res = levels.get(0);

        for (int i = 1; i < levels.size(); i++) {
            res = sum(res, levels.get(i), i);
        }

        return res;
    }

    private String multiply(String str, char ch) {
        var rem = 0;
        var level = new StringBuilder(12);

        for (int j = str.length() - 1; j != -1; j--) {
            var ch1 = str.charAt(j);
            var tmp = (ch1 - '0') * (ch - '0') + rem;
            rem = tmp / 10;
            tmp %= 10;

            level.insert(0, tmp);
        }

        if (rem != 0) {
            level.insert(0, rem);
        }

        return level.toString();
    }

    private String sum(String num1, String num2, int shift) {
        var from = num1.length() - shift;
        var res = new StringBuilder(num1.substring(from));
        var cursor2 = num2.length() - 1;
        var rem = 0;

        for (int i = from - 1; i != -1; i--) {
            var ch1 = num1.charAt(i);
            var ch2 = num2.charAt(cursor2);
            var sum = (ch1 - '0') + (ch2 - '0') + rem;
            rem = sum / 10;
            sum %= 10;

            res.insert(0, sum);
            cursor2--;
        }

        while (rem != 0 && cursor2 != -1) {
            var ch2 = num2.charAt(cursor2);
            var sum = (ch2 - '0') + rem;

            rem = sum / 10;
            sum %= 10;
            res.insert(0, sum);
            cursor2--;
        }

        if (rem != 0) {
            res.insert(0, rem);
        } else {
            res.insert(0, num2.substring(0, cursor2 + 1));
        }

        return res.toString();
    }

}