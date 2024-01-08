package org.lllbllllb.problems.plusone;

/**
 * <a href="https://leetcode.com/problems/plus-one/">66. Plus One</a>
 */
// 0 ms, 43 MB
class Solution {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i > -1; i--) {
            if (digits[i] < 9) {
                digits[i]++;

                return digits;
            }

            digits[i] = 0;
        }

        var res = new int[digits.length + 1];
        res[0] = 1;

        return res;
    }

}

// 0 ms, 42.8 MB
class Solution1 {

    public int[] plusOne(int[] digits) {
        var len = digits.length;

        if (digits[len - 1] != 9) {
            digits[len - 1]++;

            return digits;
        } else {
            for (int i = len - 1; i > -1; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    break;
                }
            }
        }

        if (digits[0] == 0) {
            var res = new int[len + 1];
            res[0] = 1;

            System.arraycopy(digits, 0, res, 1, len);

            return res;
        } else {
            return digits;
        }
    }
}