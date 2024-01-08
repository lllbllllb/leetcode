package org.lllbllllb.problems.binarywatch;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-watch/">401. Binary Watch</a>
 */
// backtracking
// 0-1 ms
class Solution {

    private static final int[] BITS = new int[]{8, 4, 2, 1, 32, 16, 8, 4, 2, 1};

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn > 8) {
            return List.of();
        }

        var res = new ArrayList<String>();

        backtracking(res, 0, 0, 0, turnedOn);

        return res;
    }

    public void backtracking(List<String> res, int h, int m, int cursor, int count) {
        if (count == 0) {
            var time = new StringBuilder()
                .append(h)
                .append(":");

            if (m < 10) {
                time.append(0);
            }

            time.append(m);
            res.add(time.toString());
        } else {
            for (int i = cursor; i < BITS.length; i++) {
                var val = BITS[i];

                if (i < 4) { // hours
                    h += val;
                } else {
                    m += val;
                }

                if (h < 12 && m < 60) {
                    backtracking(res, h, m, i + 1, count - 1);
                }

                if (i < 4) { // hours
                    h -= val;
                } else {
                    m -= val;
                }
            }
        }
    }

}

// no backtracking, bruteforce
// 1 ms
class Solution1 {

    public List<String> readBinaryWatch(int turnedOn) {
        if (turnedOn > 8) {
            return List.of();
        }

        var res = new ArrayList<String>();

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    var time = new StringBuilder()
                            .append(h)
                            .append(":");

                    if (m < 10) {
                        time.append(0);
                    }

                    time.append(m);
                    res.add(time.toString());
                }
            }
        }

        return res;
    }
}