package org.lllbllllb.problems.searcha2dmatrixii;

/**
 * <a href="https://leetcode.com/problems/search-a-2d-matrix-ii/">240. Search a 2D Matrix II</a>
 */
class Solution {

    // 5 ms, 48.5 MB
    public boolean searchMatrix(int[][] matrix, int target) {
        var row = 0;
        var col = matrix[0].length - 1;

        while (row < matrix.length && col > -1) {
            var val = matrix[row][col];

            if (val == target) {
                return true;
            }

            if (val > target) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }

    // NlogM
    // 7 ms, 48.2 MB
    public boolean searchMatrix1(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }

        for (int i = 0; i < matrix.length; i++) {
            var row = matrix[i];

            if (row[0] <= target && row[row.length - 1] >= target) {
                if (binary(row, target) >= 0) {
                    return true;
                }
            }
        }

        return false;
    }

    private int binary(int[] arr, int target) {
        var from = 0;
        var to = arr.length - 1;

        while (from <= to) {
            var mid = from + (to - from) / 2;
            var midVal = arr[mid];

            if (midVal > target) {
                to = mid - 1;
            } else if (midVal < target) {
                from = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
