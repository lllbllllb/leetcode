package org.lllbllllb.leetcode.problems.wordbreak;

import java.util.List;

/**
 * <a href="https://leetcode.com/problems/word-break/">139. Word Break</a>
 */
class Solution {

    // 4 ms, 42.8 MB
    public boolean wordBreak(String s, List<String> wordDict) {
        var dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for (int i = s.length(); i > -1; i--) {
            for (var word : wordDict) {
                if (i + word.length() < dp.length && word.equals(s.substring(i, i + word.length()))) {
                    dp[i] = dp[i + word.length()];

                    if (dp[i]) {
                        break;
                    }
                }
            }
        }

        return dp[0];
    }

    // Time Limit Exceeded
    public boolean wordBreak1(String s, List<String> wordDict) {
        var trie = new Trie();

        for (var word : wordDict) {
            trie.add(word);
        }

        return dfs(s, 0, trie.root, trie.root);
    }

    private boolean dfs(String s, int cursor, TrieNode root, TrieNode node) {
        if (cursor == s.length()) {
            return node == root;
        }

        var ch = s.charAt(cursor);
        var child = node.getChild(ch);

        if (child == null) {
            return false;
        }

        if (child.terminal) {
            return dfs(s, cursor + 1, root, root) || dfs(s, cursor + 1, root, child);
        }

        return dfs(s, cursor + 1, root, child);
    }

    private static class Trie {

        public final TrieNode root = new TrieNode();

        public void add(String str) {
            var node = root;

            for (int i = 0; i < str.length(); i++) {
                node = node.addChild(str.charAt(i));
            }

            node.terminal = true;
        }
    }

    private static class TrieNode {

        private static final char OFFSET = 'a';

        private final TrieNode[] children = new TrieNode[26];

        public boolean terminal;

        public TrieNode addChild(char ch) {
            var idx = ch - OFFSET;

            if (children[idx] == null) {
                children[idx] = new TrieNode();
            }

            return children[idx];
        }

        public TrieNode getChild(char ch) {
            return children[ch - OFFSET];
        }
    }
}
