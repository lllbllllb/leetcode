package org.lllbllllb.other.problems.almostidentical;

import java.util.List;

/**
 * Design a data structure that is initialized with a list of different words.
 * Provided a string, you should determine if you can change exactly one character
 * in this string to natch any word the data structure
 */
class WordMatcher {

    private final TrieNode root = new TrieNode();

    public WordMatcher(List<String> initialWords) {
        for (var word : initialWords) {
            var trie = root.addChild(word.charAt(0));

            for (int i = 1; i < word.length(); i++) {
                trie = trie.addChild(word.charAt(i));
            }

            trie.markAsFinish();
        }
    }

    public boolean isMatch(String word) {
        return isMatch(word, 0, root, 0);
    }

    private boolean isMatch(String word, int cursor, TrieNode parent, int missCount) {
        if (parent == null) {
            return false;
        }

        if (cursor == word.length()) {
            return parent.isFinish() && missCount == 1;
        }

        var chIdx = TrieNode.getChildrenIdx(word.charAt(cursor));
        var children = parent.getChildren();

        for (int i = 0; i < children.length; i++) {
            var child = children[i];

            if (isMatch(word, cursor + 1, child, chIdx == i ? missCount : missCount + 1)) {
                return true;
            }
        }

        return false;
    }

    private static class TrieNode {

        private boolean finish;

        private final TrieNode[] children = new TrieNode[26];

        public TrieNode addChild(char ch) {
            var idx = getChildrenIdx(ch);

            if (children[idx] == null) {
                children[idx] = new TrieNode();
            }

            return children[idx];
        }

        public TrieNode[] getChildren() {
            return children;
        }

        public boolean isFinish() {
            return finish;
        }

        public void markAsFinish() {
            finish = true;
        }

        public static int getChildrenIdx(char ch) {
            return ch - 'a';
        }
    }

}
