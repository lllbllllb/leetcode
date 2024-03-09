package org.lllbllllb.leetcode.problems.wordsearchii;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/word-search-ii/">212. Word Search II</a>
 */
class Solution {

    // 166 ms, 42.6 MB
    public List<String> findWords(char[][] board, String[] words) {
        var trie = new Trie();

        for (var word : words) {
            trie.addWord(word);
        }

        var res = new ArrayList<String>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtracking(board, i, j, trie.root, res);
            }
        }

        return res;
    }

    private void backtracking(char[][] board, int i, int j, TrieNode parent, List<String> res) {
        if (i == -1 || j == -1 || i == board.length || j == board[i].length) {
            return;
        }

        var ch = board[i][j];
        var node = parent.getChild(ch);

        if (node == null) {
            return;
        }

        if (node.terminalWord != null) {
            res.add(node.terminalWord);
            node.terminalWord = null;
        }

        board[i][j] = 0;

        backtracking(board, i, j + 1, node, res);
        backtracking(board, i + 1, j, node, res);
        backtracking(board, i, j - 1, node, res);
        backtracking(board, i - 1, j, node, res);

        board[i][j] = ch;
    }

    private static class Trie {

        private final TrieNode root = new TrieNode();

        private void addWord(String word) {
            var node = root;

            for (int i = 0; i < word.length(); i++) {
                node = node.addChild(word.charAt(i));
            }

            node.terminalWord = word;
        }
    }

    private static class TrieNode {

        private static final char OFFSET = 'a';

        private final TrieNode[] children = new TrieNode[26];

        private String terminalWord;

        private TrieNode() {}

        private TrieNode addChild(char ch) {
            var idx = ch - OFFSET;

            if (children[idx] == null) {
                children[idx] = new TrieNode();
            }

            return children[idx];
        }

        private TrieNode getChild(char ch) {
            var idx = ch - OFFSET;

            if (idx < 0) {
                return null;
            }

            return children[idx];
        }
    }
}
