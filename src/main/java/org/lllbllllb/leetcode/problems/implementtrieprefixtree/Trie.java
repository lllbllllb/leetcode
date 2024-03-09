package org.lllbllllb.leetcode.problems.implementtrieprefixtree;

/**
 * <a href="https://leetcode.com/problems/implement-trie-prefix-tree/">208. Implement Trie (Prefix Tree)</a>
 */
// 40 ms, 51 MB
class Trie {
    private final TrieNode trie = new TrieNode();

    public Trie() {}

    public void insert(String word) {
        var parent = trie;

        for (int i = 0; i < word.length(); i++) {
            var ch = word.charAt(i);
            parent.addChild(ch);
            parent = parent.getChild(ch);
        }

        parent.terminal = true;
    }

    public boolean search(String word) {
        var last = getLast(word);

        return last != null && last.terminal;
    }

    public boolean startsWith(String prefix) {
        return getLast(prefix) != null;
    }

    private TrieNode getLast(String word) {
        var parent = trie;

        for (int i = 0; i < word.length() && parent != null; i++) {
            var ch = word.charAt(i);
            parent = parent.getChild(ch);
        }

        return parent;
    }

    private static class TrieNode {
        private static final char OFFSET = 'a';
        private final Character val;
        private final TrieNode[] childs = new TrieNode[26];
        private boolean terminal;

        public TrieNode() {
            this.val = null;
        }

        public TrieNode(char val) {
            this.val = val;
        }

        private TrieNode getChild(char ch) {
            return childs[ch - OFFSET];
        }

        private TrieNode addChild(char ch) {
            if (childs[ch - OFFSET] == null) {
                childs[ch - OFFSET] = new TrieNode(ch);
            }

            return childs[ch - OFFSET];
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
