package org.lllbllllb.problems.uniquepathsii;

/**
 * <a href="https://leetcode.com/problems/unique-paths-ii/description/">63. Unique Paths II</a>
 */
class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        var matrix = new int[obstacleGrid.length][obstacleGrid[0].length];
        matrix[0][0] = 1;

        for (int i = 1; i < matrix.length; i++) {
            if (obstacleGrid[i][0] != 1) {
                matrix[i][0] = matrix[i - 1][0];
            } else {
                matrix[i][0] = 0;
            }
        }

        for (int i = 1; i < matrix[0].length; i++) {
            if (obstacleGrid[0][i] != 1) {
                matrix[0][i] = matrix[0][i - 1];
            } else {
                matrix[0][i] = 0;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (obstacleGrid[i][j] != 1) {
                    matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
