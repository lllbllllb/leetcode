package org.lllbllllb.problems.rotateimage;

/**
 * <a href="https://leetcode.com/problems/rotate-image/">48. Rotate Image</a>
 */
class Solution {

    public void rotate(int[][] matrix) {
        transpose(matrix); // https://wiki.loginom.ru/articles/transpose.html
        reflect(matrix);
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                if (i != j) {
                    var val = matrix[i][j];
                    var val1 = matrix[j][i];
                    matrix[j][i] = val;
                    matrix[i][j] = val1;
                }
            }
        }
    }

    private void reflect(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                var val = matrix[i][j];
                var val1 = matrix[i][matrix.length - j - 1];
                matrix[i][matrix.length - j - 1] = val;
                matrix[i][j] = val1;
            }
        }
    }
}
