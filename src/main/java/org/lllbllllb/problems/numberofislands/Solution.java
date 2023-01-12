package org.lllbllllb.problems.numberofislands;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/number-of-islands/">200. Number of Islands</a>
 */
class Solution {

    public int numIslands(char[][] grid) {
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
