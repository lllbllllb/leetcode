package org.lllbllllb.problems.insertinterval;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/insert-interval/">57. Insert Interval</a>
 */
class Solution {

    // 2 ms, 45.3 MB
    public int[][] insert(int[][] intervals, int[] newInterval) {
        var res = new ArrayList<int[]>(intervals.length + 1);
        var i = 0;

        while (i < intervals.length && newInterval[0] > intervals[i][1]) {
            res.add(intervals[i]);
            i++;
        }

        while (i < intervals.length && newInterval[1] >= intervals[i][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);

            i++;
        }

        res.add(newInterval);

        while (i < intervals.length) {
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(int[][]::new);
    }

    // 2 ms, 45 MB
    public int[][] insert2(int[][] intervals, int[] newInterval) {
        var res = new ArrayList<int[]>(intervals.length + 1);

        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);

                for (int j = i; j < intervals.length; j++) {
                    res.add(intervals[j]);
                }

                return res.toArray(int[][]::new);
            }

            if (intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
            } else {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        res.add(newInterval);

        return res.toArray(int[][]::new);
    }

    // 2 ms, 45 MB
    public int[][] insert1(int[][] intervals, int[] newInterval) {
        var res = new ArrayList<int[]>(intervals.length + 1);
        res.add(newInterval);

        for (var interval : intervals) {
            var lastIntervalIdx = res.size() - 1;
            var lastInterval = res.get(lastIntervalIdx);

            if (interval[1] < lastInterval[0]) {
                res.set(lastIntervalIdx, interval);
                res.add(lastInterval);
            } else if (interval[0] > lastInterval[1]) {
                res.add(interval);
            } else {
                lastInterval[0] = Math.min(lastInterval[0], interval[0]);
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }

        return res.toArray(int[][]::new);
    }
}
