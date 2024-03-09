package org.lllbllllb.leetcode.problems.reversebits;

/**
 * <a href="https://leetcode.com/problems/reverse-bits/description/">190. Reverse Bits</a>
 */
class Solution {

    // you need treat n as an unsigned value
    // 0ms, 40.15MB
    public int reverseBits(int x) {
        var res = 0;

        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res += (x & 1);
            x >>= 1;
        }

        return res;
    }
}

class Solution1 {

    // you need treat n as an unsigned value
    // 0ms, 40.15MB
    public int reverseBits(int n) {
        var res = 0;

        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= (n & 1);
            n >>= 1;
        }

        return res;
    }
}
