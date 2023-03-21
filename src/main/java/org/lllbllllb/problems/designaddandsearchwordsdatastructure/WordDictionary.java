package org.lllbllllb.problems.designaddandsearchwordsdatastructure;

/**
 * <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure/">211. Design Add and Search Words Data Structure</a>
 */
// 509 ms, 100.4 MB
class WordDictionary {

    private static final char ANY = '.';

    private final TrieNode trie = new TrieNode();

    public WordDictionary() {

    }

    public void addWord(String word) {
        var next = trie;

        for (int i = 0; i < word.length(); i++) {
            var ch = word.charAt(i);
            next = next.addChild(ch);
        }

        next.terminal = true;
    }

    public boolean search(String word) {
        return search(word, 0, trie);
    }

    private boolean search(String word, int idx, TrieNode node) {
        if (node == null) {
            return false;
        }

        if (idx == word.length()) {
            return node.terminal;
        }

        var ch = word.charAt(idx);

        if (ch != ANY) {
            return search(word, idx + 1, node.getChild(ch));
        }

        for (var child : node.children) {
            if (search(word, idx + 1, child)) {
                return true;
            }
        }

        return false;
    }

    private static class TrieNode {

        private static final char OFFSET = 'a';

        private final TrieNode[] children = new TrieNode[27]; // a-z

        private boolean terminal;

        private TrieNode getChild(char ch) {
            return children[ch - OFFSET];
        }

        private TrieNode addChild(char ch) {
            if (children[ch - OFFSET] == null) {
                children[ch - OFFSET] = new TrieNode();
            }

            return children[ch - OFFSET];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
