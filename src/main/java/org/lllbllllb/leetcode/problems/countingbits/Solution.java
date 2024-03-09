package org.lllbllllb.leetcode.problems.countingbits;

/**
 * <a href="https://leetcode.com/problems/counting-bits/description/">338. Counting Bits</a>
 */
class Solution {

    // 2ms, 46.65MB
    public int[] countBits(int n) {
        var res = new int[n + 1];

        for (int i = 1; i < res.length; i++) {
            var prev = res[i / 2];
            res[i] = prev + i % 2;
        }

        return res;
    }
}