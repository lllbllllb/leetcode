package org.lllbllllb.leetcode.problems.spiralmatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix/description/">54. Spiral Matrix</a>
 */
class Solution {

    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        var res = new ArrayList<Integer>(matrix.length * matrix[0].length);

        backtracking(matrix, 0, 0, 0, res);

        return res;
    }

    private boolean backtracking(int[][] matrix, int i, int j, int directionCursor, List<Integer> res) {
        if (i == matrix.length || i == -1
                || j == matrix[0].length || j == -1
                || matrix[i][j] == Integer.MAX_VALUE) {
            return false;
        }

        var val = matrix[i][j];
        res.add(val);
        matrix[i][j] = Integer.MAX_VALUE;

        var direction = DIRECTIONS[directionCursor % 4];
        var stepResult = backtracking(matrix, i + direction[0], j + direction[1], directionCursor, res);

        if (!stepResult && res.size() != matrix.length * matrix[0].length) {
            var nextDirectionCursor = directionCursor + 1;
            var nextDirection = DIRECTIONS[nextDirectionCursor % 4];

            backtracking(matrix, i + nextDirection[0], j + nextDirection[1], directionCursor + 1, res);
        }

        matrix[i][j] = val;

        return true;
    }
}