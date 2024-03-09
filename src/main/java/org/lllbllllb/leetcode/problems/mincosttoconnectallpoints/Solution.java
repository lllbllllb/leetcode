package org.lllbllllb.leetcode.problems.mincosttoconnectallpoints;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/min-cost-to-connect-all-points/">1584. Min Cost to Connect All Points</a>
 */
class Solution {

    // 27 ms, 43.1 MB
    public int minCostConnectPoints(int[][] points) {
        var numberOfPoints = points.length;
        var minCosts = new int[numberOfPoints];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        var visited = new boolean[numberOfPoints];
        var cost = 0;
        var cursor = 0;

        for (int edge = 0; edge < numberOfPoints - 1; edge++) {
            visited[cursor] = true;

            var nextPoint = 0;
            var minPath = Integer.MAX_VALUE;

            for (int point = 0; point < numberOfPoints; point++) {
                if (!visited[point]) {
                    var firstPoint = points[cursor];
                    var secondPoint = points[point];
                    var path = Math.abs(firstPoint[0] - secondPoint[0]) + Math.abs(firstPoint[1] - secondPoint[1]);
                    minCosts[point] = Math.min(minCosts[point], path);

                    if (minCosts[point] < minPath) {
                        minPath = minCosts[point];
                        nextPoint = point;
                    }
                }
            }

            cost += minPath;
            cursor = nextPoint;
        }

        return cost;
    }

    // 177 ms, 60.7 MB
    public int minCostConnectPoints1(int[][] points) {
        var visited = new HashSet<Integer>();
        var frontier = new PriorityQueue<int[]>(Comparator.comparingInt(pathToIdx -> pathToIdx[0])); // min heap
        frontier.offer(new int[]{0, 0});
        var cost = 0;

        while (!frontier.isEmpty() && visited.size() < points.length) {
            var nextPath = frontier.poll();
            var pointIdx = nextPath[1];

            if (!visited.contains(pointIdx)) {
                cost += nextPath[0];

                for (int i = 0; i < points.length; i++) {
                    if (i != pointIdx && !visited.contains(i)) {
                        var firstPoint = points[pointIdx];
                        var secondPoint = points[i];
                        var path = Math.abs(firstPoint[0] - secondPoint[0]) + Math.abs(firstPoint[1] - secondPoint[1]);
                        var pathToIdx = new int[]{path, i};
                        frontier.offer(pathToIdx);
                    }
                }
            }

            visited.add(pointIdx);
        }

        return cost;
    }
}
