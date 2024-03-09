package org.lllbllllb.leetcode.problems.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/merge-intervals/">56. Merge Intervals</a>
 */
class Solution {

    // 12 ms, 47.6 MB
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        var res = new ArrayList<int[]>();
        res.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            var prevInterval = res.get(res.size() - 1);
            var interval = intervals[i];

            if (prevInterval[1] < interval[0]) {
                res.add(interval);
            } else {
                prevInterval[1] = Math.max(prevInterval[1], interval[1]);
            }
        }

        return res.toArray(int[][]::new);
    }

    // 12 ms, 47.7 MB
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        var res = new ArrayList<int[]>();
        var prevInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            var interval = intervals[i];

            if (interval[0] > prevInterval[1]) {
                res.add(prevInterval);

                prevInterval = interval;
            } else {
                prevInterval[1] = Math.max(prevInterval[1], interval[1]);
            }
        }

        res.add(prevInterval);

        return res.toArray(int[][]::new);
    }
}
