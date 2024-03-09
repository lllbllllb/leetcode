package org.lllbllllb.leetcode.problems.kokoeatingbananas;

class Solution {

    // 22 ms, 43.2 MB
    public int minEatingSpeed(int[] piles, int h) {
        var max = 0;

        for (var pile : piles) {
            max = Math.max(max, pile);
        }

        var from = 1;
        var to = max;
        var k = max;

        while (from <= to) {
            var kTmp = (from + to) / 2;
            var h1 = 0L;

            for (var j = 0; j < piles.length; j++) {
                var pile = piles[j];
                h1 += pile % kTmp == 0 ? pile / kTmp : pile / kTmp + 1;

                if (h1 <= h && j == piles.length - 1) {
                    k = Math.min(k, kTmp);
                    to = kTmp - 1;
                } else if (h1 > h) {
                    from = kTmp + 1;
                }
            }
        }

        return k;
    }

    // Time Limit Exceeded
    public int minEatingSpeed11(int[] piles, int h) {
        var max = 0;

        for (var pile : piles) {
            max = Math.max(max, pile);
        }

        for (int k = 1; k < max + 1; k++) {
            var h1 = 0L;

            for (var j = 0; j < piles.length; j++) {
                var pile = piles[j];
                h1 += pile % k == 0 ? pile / k : pile / k + 1;

                if (h1 <= h && j == piles.length - 1) {
                    return k;
                }
            }
        }

        return -1;
    }
}
