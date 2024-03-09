package org.lllbllllb.leetcode.problems.swiminrisingwater;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/swim-in-rising-water/">778. Swim in Rising Water</a>
 */
class Solution {

    // 13 ms, 44 MB
    public int swimInWater(int[][] grid) {
        var n = grid.length;
        var minHeap = new PriorityQueue<int[]>(Comparator.comparingInt(pos -> grid[pos[0]][pos[1]]));
        minHeap.offer(new int[]{0, 0});
        var visited = new boolean[n][n];
        visited[0][0] = true;
        var time = -1;

        while (!minHeap.isEmpty()) {
            var current = minHeap.poll();
            var i = current[0];
            var j = current[1];

            time = Math.max(time, grid[i][j]);

            if (i == n - 1 && j == n - 1) {
                return time;
            }

            for (var direction : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) {
                var iNext = i + direction[0];
                var jNext = j + direction[1];

                if (iNext <= -1 || iNext >= n || jNext <= -1 || jNext >= n || visited[iNext][jNext]) {
                    continue;
                }

                minHeap.offer(new int[]{iNext, jNext});
                visited[iNext][jNext] = true;
            }
        }

        return -1;
    }
}
