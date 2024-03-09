package org.lllbllllb.leetcode.problems.searcha2dmatrix;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix/">74. Search a 2D Matrix</a>
 */
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        var from = 0;
        var to = matrix.length * matrix[0].length - 1;

        while (from <= to) {
            var idx = (from + to) / 2;
            var val = matrix[idx / matrix[0].length][idx % matrix[0].length];

            if (val > target) {
                to = idx - 1;
            } else if (val < target) {
                from = idx + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
