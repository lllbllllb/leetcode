package org.lllbllllb.leetcode.problems.surroundedregions;

/**
 * <a href="https://leetcode.com/problems/surrounded-regions/">130. Surrounded Regions</a>
 */
class Solution {

    public void solve(char[][] board) {
        var rows = board.length;
        var cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') {
                dfs(board, r, 0);
            }

            if (board[r][cols - 1] == 'O') {
                dfs(board, r, cols - 1);
            }
        }

        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') {
                dfs(board, 0, c);
            }

            if (board[rows - 1][c] == 'O') {
                dfs(board, rows - 1, c);
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'C') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r == -1 || r == board.length
            || c == -1 || c == board[0].length
            || board[r][c] == 'X' || board[r][c] == 'C') {
            return;
        }

        board[r][c] = 'C';

        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r + 1, c);
        dfs(board, r, c - 1);
    }
}
