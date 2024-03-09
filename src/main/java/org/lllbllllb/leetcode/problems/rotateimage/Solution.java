package org.lllbllllb.leetcode.problems.rotateimage;

/**
 * <a href="https://leetcode.com/problems/rotate-image/">48. Rotate Image</a>
 */

class Solution {

    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;

        while ( l < r )
        {
            for(int i = 0; i < r - l; i++)
            {
                int top = l;
                int bottom = r;
                //save the topleft
                int topLeft = matrix[top][l + i];

                //move bottom left into top left
                matrix[top][l + i] = matrix[bottom - i][l];

                // move bottom right into bottom left
                matrix[bottom - i][l] = matrix[bottom][r - i];

                // move top right into bottom right
                matrix[bottom][r - i] = matrix[top + i][r];

                // move top left into top right
                matrix[top + i][r] = topLeft;

            }

            r -= 1;
            l += 1;
        }
    }
}

class Solution1 {

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
