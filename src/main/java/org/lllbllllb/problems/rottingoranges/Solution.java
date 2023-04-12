package org.lllbllllb.problems.rottingoranges;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/rotting-oranges/">994. Rotting Oranges</a>
 */
class Solution {

    public int orangesRotting(int[][] grid) {
        var count = 0;
        var freshCount = 0;
        var queue = new LinkedList<int[]>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                var orange = grid[i][j];

                if (orange == 1) {
                    freshCount++;
                } else if (orange == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        var timer = queue.size();

        while (!queue.isEmpty()) {
            var cell = queue.poll();
            var i = cell[0];
            var j = cell[1];
            var iPrev = i - 1;
            var iNext = i + 1;
            var jPrev = j - 1;
            var jNext = j + 1;

            if (iPrev > -1) {
                if (grid[iPrev][j] == 1) {
                    grid[iPrev][j] = 2;
                    queue.offer(new int[]{iPrev, j});
                    freshCount--;
                }
            }

            if (iNext < grid.length) {
                if (grid[iNext][j] == 1) {
                    grid[iNext][j] = 2;
                    queue.offer(new int[]{iNext, j});
                    freshCount--;
                }
            }

            if (jPrev > -1) {
                if (grid[i][jPrev] == 1) {
                    grid[i][jPrev] = 2;
                    queue.offer(new int[]{i, jPrev});
                    freshCount--;
                }
            }

            if (jNext < grid[0].length) {
                if (grid[i][jNext] == 1) {
                    grid[i][jNext] = 2;
                    queue.offer(new int[]{i, jNext});
                    freshCount--;
                }
            }

            if (timer == 1) {
                timer = queue.size();

                if (queue.size() != 0) {
                    count++;
                }
            } else {
                timer--;
            }
        }

        return freshCount == 0 ? count : -1;
    }
}
