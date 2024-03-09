package org.lllbllllb.leetcode.problems.numberof1bit;

/**
 * <a href="https://leetcode.com/problems/number-of-1-bits/description/">191. Number of 1 Bits`</a>
 */
class Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        var count = 0;

        while (n != 0) {
            count++;
            n &= n - 1;
        }

        return count;
    }

}

class Solution1 {

    public int hammingWeight(int n) {
        var count = 0;

        for (int i = 0; i < 32; i++) {
            count += n & 1;
            n >>= 1;
        }

        return count;
    }
}