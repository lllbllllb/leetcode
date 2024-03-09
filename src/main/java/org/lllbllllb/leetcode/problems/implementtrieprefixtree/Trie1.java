package org.lllbllllb.leetcode.problems.implementtrieprefixtree;

import java.util.HashMap;
import java.util.Map;

// 52 ms, 54.8 MB
class Trie1 {
    private final TrieNode trie = new TrieNode();

    public Trie1() {}

    public void insert(String word) {
        var parent = trie;

        for (int i = 0; i < word.length(); i++) {
            var ch = word.charAt(i);

            if (!parent.childs.containsKey(ch)) {
                var newNode = new TrieNode(ch);
                parent.childs.put(ch, newNode);
            }

            parent = parent.childs.get(ch);
        }

        parent.terminal = true;
    }

    public boolean search(String word) {
        var parent = trie;

        for (int i = 0; i < word.length(); i++) {
            var ch = word.charAt(i);
            parent = parent.childs.get(ch);

            if (parent == null) {
                return false;
            }
        }

        return parent.terminal;
    }

    public boolean startsWith(String prefix) {
        var parent = trie;

        for (int i = 0; i < prefix.length(); i++) {
            var ch = prefix.charAt(i);
            parent = parent.childs.get(ch);

            if (parent == null) {
                return false;
            }
        }

        return true;
    }

    private static class TrieNode {
        private final Character val;
        private final Map<Character, TrieNode> childs = new HashMap<>();
        private boolean terminal;

        public TrieNode() {
            this.val = null;
        }

        public TrieNode(char val) {
            this.val = val;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
