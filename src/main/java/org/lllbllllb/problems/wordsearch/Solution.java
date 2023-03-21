package org.lllbllllb.problems.wordsearch;

/**
 * <a href="https://leetcode.com/problems/word-search/">79. Word Search</a>
 */
class Solution {

    // 172 ms, 40.3 MB
    public boolean exist(char[][] board, String word) {
        var x = board.length;
        var y = board[0].length;

        if (word.length() > x * y) {
            return false;
        }

        var head = word.charAt(0);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == head) {
                    var exist = backtracking(board, i, j, word, 0);

                    if (exist) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    private boolean backtracking(char[][] board, int i, int j, String word, int wordCursor) {
        if (wordCursor == word.length()) {
            return true;
        }

        if (i == -1 || j == -1 || i == board.length || j == board[0].length || board[i][j] != word.charAt(wordCursor)) {
            return false;
        }

        var currentChar = board[i][j];
        var wordCursorNext = wordCursor + 1;

        board[i][j] = 0;

        var res = backtracking(board, i + 1, j, word, wordCursorNext)
            || backtracking(board, i, j + 1, word, wordCursorNext)
            || backtracking(board, i - 1, j, word, wordCursorNext)
            || backtracking(board, i, j - 1, word, wordCursorNext);

        board[i][j] = currentChar;

        return res;
    }

    // 131 ms, 43 MB
    public boolean exist1(char[][] board, String word) {
        var len = board.length;
        var hei = board[0].length;

        if (word.length() > len * hei) {
            return false;
        }

        var head = word.charAt(0);

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < hei; j++) {
                if (board[i][j] == head) {
                    var exist = dfs(board, i, j, word, 0);

                    if (exist) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int wordCursor) {
        var len = board.length;
        var hei = board[0].length;
        var iNext = i + 1;
        var iPrev = i - 1;
        var jNext = j + 1;
        var jPrev = j - 1;
        var nextWordCursor = wordCursor + 1;

        board[i][j] = '$';

        if (nextWordCursor == word.length()) {
            return true;
        }

        var currChar = word.charAt(wordCursor);
        var nextChar = word.charAt(nextWordCursor);
        var top = false;
        var right = false;
        var bottom = false;
        var left = false;

        if (i > 0 && nextChar == board[iPrev][j]) {
            top = dfs(board, iPrev, j, word, nextWordCursor);
        }

        if (jNext < hei && nextChar == board[i][jNext]) {
            right = dfs(board, i, jNext, word, nextWordCursor);
        }

        if (iNext < len && nextChar == board[iNext][j]) {
            bottom = dfs(board, iNext, j, word, nextWordCursor);
        }

        if (j > 0 && nextChar == board[i][jPrev]) {
            left = dfs(board, i, jPrev, word, nextWordCursor);
        }

        board[i][j] = currChar;

        return top || right || bottom || left;
    }
}
