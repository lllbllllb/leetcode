package org.lllbllllb.problems.uniquepathsiii;

/**
 * @see <a href="https://leetcode.com/problems/unique-paths-iii/">980. Unique Paths III</a>
 */
class Solution {

    // 0-1 ms
    public int uniquePathsIII(int[][] grid) {
        var iStart = -1;
        var jStart = -1;
        var walls = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    iStart = i;
                    jStart = j;
                } else if (grid[i][j] == -1) {
                    walls++;
                }
            }
        }

        var visited = new boolean[grid.length][grid[0].length];
        visited[iStart][jStart] = true;

        return backtracking(grid, iStart, jStart, visited, 1, grid.length * grid[0].length - walls);
    }

    private int backtracking(int[][] grid, int i, int j, boolean[][] visited, int count, int target) {
        if (grid[i][j] == 2) {
            if (target == count) {
                return 1;
            } else {
                return 0;
            }
        }

        var res = 0;
        var iRight = i + 1;
        var iLeft = i - 1;
        var jDown = j + 1;
        var jUp = j - 1;

        if (iRight < grid.length && grid[iRight][j] != -1 && !visited[iRight][j]) {
            visited[iRight][j] = true;
            res += backtracking(grid, iRight, j, visited, count + 1, target);
            visited[iRight][j] = false;
        }

        if (iLeft > -1 && grid[iLeft][j] != -1 && !visited[iLeft][j]) {
            visited[iLeft][j] = true;
            res += backtracking(grid, iLeft, j, visited, count + 1, target);
            visited[iLeft][j] = false;
        }

        if (jDown < grid[0].length && grid[i][jDown] != -1 && !visited[i][jDown]) {

            visited[i][jDown] = true;
            res += backtracking(grid, i, jDown, visited, count + 1, target);
            visited[i][jDown] = false;
        }

        if (jUp > -1 && grid[i][jUp] != -1 && !visited[i][jUp]) {
            visited[i][jUp] = true;
            res += backtracking(grid, i, jUp, visited, count + 1, target);
            visited[i][jUp] = false;
        }

        return res;
    }
}
