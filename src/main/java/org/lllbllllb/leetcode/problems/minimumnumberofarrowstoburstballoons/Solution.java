package org.lllbllllb.leetcode.problems.minimumnumberofarrowstoburstballoons;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons">452. Minimum Number of Arrows to Burst Balloons</a>
 */
class Solution {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));

        var res = 1;
        var pos = points[0][1];

        for (var point : points) {
            if (point[0] > pos) {
                res++;
                pos = point[1];
            }
        }

        return res;
    }
}
