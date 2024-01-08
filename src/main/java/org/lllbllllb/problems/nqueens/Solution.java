package org.lllbllllb.problems.nqueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/n-queens/">51. N-Queens</a>
 */
class Solution {

    private static final char QUEEN = 'Q';

    private static final char EMPTY = '.';

    // 5 ms, 43.4 MB
    public List<List<String>> solveNQueens(int n) {
        var combinations = new ArrayList<List<String>>();
        var board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], EMPTY);
        }

        backtracking(n, 0, new HashSet<>(), new HashSet<>(), new HashSet<>(), board, combinations);

        return combinations;
    }

    private void backtracking(
            int n,
            int row,
            Set<Integer> occupiedCols,
            Set<Integer> negativeDiags,
            Set<Integer> positiveDiags,
            char[][] board,
            List<List<String>> combinations
    ) {
        if (n == 0) {
            var combination = new ArrayList<String>();

            for (var r : board) {
                combination.add(new String(r));
            }

            combinations.add(combination);

            return;
        }

        for (var col = 0; col < board.length; col++) {
            var neg = row - col;
            var pos = row + col;

            if (!occupiedCols.contains(col) && !negativeDiags.contains(neg) && !positiveDiags.contains(pos)) {
                board[row][col] = QUEEN;
                occupiedCols.add(col);
                negativeDiags.add(neg);
                positiveDiags.add(pos);

                backtracking(n - 1, row + 1, occupiedCols, negativeDiags, positiveDiags, board, combinations);

                board[row][col] = EMPTY;
                occupiedCols.remove(col);
                negativeDiags.remove(neg);
                positiveDiags.remove(pos);
            }
        }
    }
}

// 8 ms, 42.9 MB
class Solution1 {

    private static final char QUEEN = 'Q';

    private static final char EMPTY = '.';

    public List<List<String>> solveNQueens(int n) {
        var combinations = new ArrayList<List<Integer>>();

        backtracking(n, n, 0, new ArrayList<>(), combinations);

        var res = new ArrayList<List<String>>();

        for (var comb : combinations) {
            var combination = new ArrayList<String>();

            for (int row = 0; row < comb.size(); row++) {
                var rowStr = new StringBuilder();
                var col = comb.get(row);

                for (int i = 0; i < n; i++) {
                    rowStr.append(i == col ? QUEEN : EMPTY);
                }

                combination.add(rowStr.toString());
            }

            res.add(combination);
        }

        return res;
    }

    private void backtracking(int n, int count, int row, List<Integer> quinnCols, List<List<Integer>> combinations) {
        if (count == 0) {
            combinations.add(List.copyOf(quinnCols));

            return;
        }

        for (var col = 0; col < n; col++) {
            if (isPlaceFree(row, col, quinnCols)) {
                quinnCols.add(col);
                backtracking(n, count - 1, row + 1, quinnCols, combinations);
                quinnCols.remove(quinnCols.size() - 1);
            }
        }
    }

    private boolean isPlaceFree(int row, int col, List<Integer> quinCols) {
        for (int quinRow = 0; quinRow < quinCols.size(); quinRow++) {
            var quinCol = quinCols.get(quinRow);

            if (row == quinRow || quinCol == col || Math.abs(quinRow - row) == Math.abs(col - quinCol)) {
                return false;
            }
        }

        return true;
    }
}

// 7 ms, 43.5 MB
class Solution2 {

    private static final char QUEEN = 'Q';

    private static final char EMPTY = '.';

    public List<List<String>> solveNQueens(int n) {
        var res = new ArrayList<List<String>>();

        backtracking(n, 0, res, new boolean[n][n], new ArrayList<>());

        return res;
    }

    private void backtracking(int n, int row, List<List<String>> res, boolean[][] board, List<QueenPos> queens) {
        if (n == 0) {
            res.add(saveBoard(board));

            return;
        }

        for (int col = 0; col < board[0].length; col++) {
            if (isPlaceFree(row, col, queens)) {
                board[row][col] = true;
                queens.add(new QueenPos(row, col));
                backtracking(n - 1, row + 1, res, board, queens);
                board[row][col] = false;
                queens.remove(queens.size() - 1);
            }
        }

    }

    private boolean isPlaceFree(int row, int col, List<QueenPos> queens) {
        for (var queenPos : queens) {
            var i = queenPos.row();
            var j = queenPos.col();

            if (i == row || j == col || Math.abs(row - i) == Math.abs(col - j)) {
                return false;
            }
        }

        return true;
    }

    private List<String> saveBoard(boolean[][] board) {
        var res = new ArrayList<String>();

        for (var cell : board) {
            var row = new StringBuilder();

            for (int j = 0; j < board[0].length; j++) {
                if (cell[j]) {
                    row.append(QUEEN);
                } else {
                    row.append(EMPTY);
                }
            }

            res.add(row.toString());
        }

        return res;
    }

    private record QueenPos(int row, int col) {}
}