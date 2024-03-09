package org.lllbllllb.leetcode.problems.validsudoku;

/**
 * <a href="https://leetcode.com/problems/valid-sudoku/description/">36. Valid Sudoku</a>
 */
class Solution {

    public boolean isValidSudoku(char[][] board) {
        var columns = new int[10][10];
//        var diagonals = new int[2][10];
        var subBoxes = new int[10][10];

        for (int i = 0; i < board.length; i++) {
            var row = new int[10];

            for (int j = 0; j < board.length; j++) {
                var val = board[i][j] - '1';

                if (val >= 0) {
                    // row
                    row[val]++;
                    if (row[val] > 1) {
                        return false;
                    }

                    // col
                    columns[j][val]++;
                    if (columns[j][val] > 1) {
                        return false;
                    }

                    // diagonals
//                    if (i == j) {
//                        diagonals[0][val]++;
//                        if (diagonals[0][val] > 1) {
//                            return false;
//                        }
//                    } else if (i == -(board.length - 1 - j)) {
//                        diagonals[1][val]++;
//                        if (diagonals[1][val] > 1) {
//                            return false;
//                        }
//                    }

                    // sub boxes
                    var subBoxIdx = (i / 3) * 3 + j / 3;
                    subBoxes[subBoxIdx][val]++;
                    if (subBoxes[subBoxIdx][val] > 1) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
