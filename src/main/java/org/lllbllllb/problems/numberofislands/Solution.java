package org.lllbllllb.problems.numberofislands;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/">200. Number of Islands</a>
 */
class Solution {

    public int numIslands(char[][] grid) {
        var count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;

                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i == -1 || i == grid.length || j == -1 || j == grid[0].length || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
    }

    // Time Limit Exceeded
    public int numIslands2(char[][] grid) {
        var count = 0;
        var directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        var bfs = new LinkedList<Integer>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    System.out.println(i + "-" + j);
                    bfs.offer(i);
                    bfs.offer(j);

                    while (!bfs.isEmpty()) {
                        var i1 = bfs.poll();
                        var j1 = bfs.poll();
                        grid[i1][j1] = '0';

                        for (var direction : directions) {
                            var iNext = i1 + direction[0];
                            var jNext = j1 + direction[1];

                            if (iNext > -1 && iNext < grid.length && jNext > -1 && jNext < grid[0].length && grid[iNext][jNext] == '1') {
                                bfs.offer(iNext);
                                bfs.offer(jNext);
                            }
                        }
                    }

                    count++;
                }
            }
        }

        return count;
    }

    // 11 ms, 50.1 MB
    public int numIslands1(char[][] grid) {
        var numIslands = 0;
        var xStack = new LinkedList<Integer>();
        var yStack = new LinkedList<Integer>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    xStack.offer(i);
                    yStack.offer(j);

                    while (!xStack.isEmpty()) {
                        var x = xStack.pollLast();
                        var prevX = x - 1;
                        var nextX = x + 1;
                        var y = yStack.pollLast();
                        var prevY = y - 1;
                        var nextY = y + 1;

                        grid[x][y] = '0';

                        if (prevX > -1 && grid[prevX][y] == '1') {
                            xStack.offer(prevX);
                            yStack.offer(y);
                        }

                        if (nextX < grid.length && grid[nextX][y] == '1') {
                            xStack.offer(nextX);
                            yStack.offer(y);
                        }

                        if (prevY > -1 && grid[x][prevY] == '1') {
                            xStack.offer(x);
                            yStack.offer(prevY);
                        }

                        if (nextY < grid[0].length && grid[x][nextY] == '1') {
                            xStack.offer(x);
                            yStack.offer(nextY);
                        }

                    }
                }
            }
        }

        return numIslands;
    }
}
