package org.lllbllllb.problems.numberof1bit;

class Solution {

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        var count = 0;

        while (n > 1) {
            if (n % 2 != 0) {
                count++;
            }

            n = n << 2;
        }

        return n == 1 ? count + 1 : count;
    }
}