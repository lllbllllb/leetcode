package org.lllbllllb.leetcode.problems.longestincreasingpathinamatrix;

class Solution {

    // 7ms, 43.95MB
    public int longestIncreasingPath(int[][] matrix) {
        var max = 0;
        var mem = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, dfs(matrix, i, j, -1, mem));
            }
        }

        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int prev, int[][] mem) {
        if (i < 0 || j < 0 || i == matrix.length || j == matrix[0].length) {
            return 0;
        }

        var curr = matrix[i][j];

        if (curr <= prev) {
            return 0;
        }

        if (mem[i][j] > 0) {
            return mem[i][j];
        }

        var max = Math.max(
            Math.max(dfs(matrix, i - 1, j, curr, mem), dfs(matrix, i + 1, j, curr, mem)),
            Math.max(dfs(matrix, i, j - 1, curr, mem), dfs(matrix, i, j + 1, curr, mem))
        );

        mem[i][j] = max + 1;

        return mem[i][j];
    }
}
