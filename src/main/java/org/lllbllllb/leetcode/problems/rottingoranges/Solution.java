package org.lllbllllb.leetcode.problems.rottingoranges;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/rotting-oranges/">994. Rotting Oranges</a>
 */
class Solution {

    // 1 ms, 41.7 MB
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

    // 2 ms, 42.2 MB
    public int orangesRotting1(int[][] grid) {
        var rows = grid.length;
        var cols = grid[0].length;
        var rottensQueue = new LinkedList<int[]>();
        var freshCount = 0;
        var minutes = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1) {
                    freshCount++;
                } else if (grid[r][c] == 2) {
                    rottensQueue.offer(new int[]{r, c});
                }
            }
        }

        while (!rottensQueue.isEmpty()) {
            var rottens = rottensQueue.size();

            for (int i = 0; i < rottens; i++) {
                var rotten = rottensQueue.poll();

                var prevR = rotten[0] - 1;
                if (rotten[0] != 0 && grid[prevR][rotten[1]] == 1) {
                    rottensQueue.offer(new int[]{prevR, rotten[1]});
                    grid[prevR][rotten[1]] = 2;
                    freshCount--;
                }

                var nextR = rotten[0] + 1;
                if (rotten[0] != rows - 1 && grid[nextR][rotten[1]] == 1) {
                    rottensQueue.offer(new int[]{nextR, rotten[1]});
                    grid[nextR][rotten[1]] = 2;
                    freshCount--;
                }

                var prevC = rotten[1] - 1;
                if (rotten[1] != 0 && grid[rotten[0]][prevC] == 1) {
                    rottensQueue.offer(new int[]{rotten[0], prevC});
                    grid[rotten[0]][prevC] = 2;
                    freshCount--;
                }


                var nextC = rotten[1] + 1;
                if (rotten[1] != cols - 1 && grid[rotten[0]][nextC] == 1) {
                    rottensQueue.offer(new int[]{rotten[0], nextC});
                    grid[rotten[0]][nextC] = 2;
                    freshCount--;
                }

            }

            if (!rottensQueue.isEmpty()) {
                minutes++;
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}
