package org.lllbllllb.problems.nonoverlappingintervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/non-overlapping-intervals/">435. Non-overlapping Intervals</a>
 */
class Solution {

    // 6 ms, 86.3 MB
    public int eraseOverlapIntervals(int[][] intervals) {
        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;

        for (var interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[0]);
        }

        var flatIntervals = new int[max - min + 1];
        Arrays.fill(flatIntervals, Integer.MAX_VALUE);

        var count = 0;

        for (var interval : intervals) {
            var flatIntervalIdx = interval[0] - min;

            if (flatIntervals[flatIntervalIdx] != Integer.MAX_VALUE) {
                flatIntervals[flatIntervalIdx] = Math.min(flatIntervals[flatIntervalIdx], interval[1]);
                count++;
            } else {
                flatIntervals[flatIntervalIdx] = interval[1];
            }
        }

        var rightCursor = flatIntervals[0];

        for (int i = 1; i < flatIntervals.length; i++) {
            if (flatIntervals[i] != Integer.MAX_VALUE) {
                if (flatIntervals[i] != Integer.MAX_VALUE) {
                    if (i + min < rightCursor) {
                        rightCursor = Math.min(rightCursor, flatIntervals[i]);
                        count++;
                    } else {
                        rightCursor = flatIntervals[i];
                    }
                }
            }
        }

        return count;
    }

    // 85 ms, 100.8 MB
    public int eraseOverlapIntervals1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        var count = 0;
        var rightCursor = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (rightCursor > intervals[i][0]) {
                count++;
                rightCursor = Math.min(rightCursor, intervals[i][1]);
            } else {
                rightCursor = intervals[i][1];
            }
        }

        return count;
    }
}
