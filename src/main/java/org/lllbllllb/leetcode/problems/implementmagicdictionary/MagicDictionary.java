package org.lllbllllb.leetcode.problems.implementmagicdictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/implement-magic-dictionary/">676. Implement Magic Dictionary</a>
 */
// 23ms, 44.99MB
class MagicDictionary {

    private String[] dictionary;

    // O(1)
    public void buildDict(String... dictionary) {
        this.dictionary = dictionary;
    }

    // O(N_dictionary * L_searchWord)
    public boolean search(String searchWord) {
        for (var word : dictionary) {
            if (word.length() != searchWord.length()) {
                continue;
            }

            var missCount = 0;

            for (int i = 0; i < searchWord.length(); i++) {
                if (word.charAt(i) != searchWord.charAt(i)) {
                    if (missCount == 1) {
                        missCount = 0;
                        break;
                    } else {
                        missCount++;
                    }
                }
            }

            if (missCount == 1) {
                return true;
            }
        }

        return false;
    }

}

// 32ms, 46.18MB
class MagicDictionary1 {

    private final Map<Integer, TrieNode> sizeToTrieMap = new HashMap<>();

    public void buildDict(String[] dictionary) {
        for (var word : dictionary) {
            var root = sizeToTrieMap.computeIfAbsent(word.length(), wl -> new TrieNode());
            var trie = root.addChild(word.charAt(0));

            for (int i = 1; i < word.length(); i++) {
                trie = trie.addChild(word.charAt(i));
            }
        }
    }

    public boolean search(String searchWord) {
        var root = sizeToTrieMap.get(searchWord.length());

        return isMatch(searchWord, 0, root, 0);
    }

    private boolean isMatch(String word, int cursor, TrieNode parent, int missCount) {
        if (parent == null) {
            return false;
        }

        if (missCount == 2) {
            return false;
        }

        if (cursor == word.length()) {
            return missCount == 1;
        }

        var ch = word.charAt(cursor);

        cursor++;

        if (missCount == 1) {
            var child = parent.getChild(ch);

            return isMatch(word, cursor, child, missCount);
        }

        var chIdx = TrieNode.getChildrenIdx(ch);
        var children = parent.getChildren();

        for (int i = 0; i < children.length; i++) {
            if (isMatch(word, cursor, children[i], i == chIdx ? missCount : missCount + 1)) {
                return true;
            }
        }

        return false;
    }

    private static class TrieNode {

        private final TrieNode[] children = new TrieNode[26];

        public TrieNode addChild(char ch) {
            var idx = getChildrenIdx(ch);

            if (children[idx] == null) {
                children[idx] = new TrieNode();
            }

            return children[idx];
        }

        public TrieNode getChild(char ch) {
            var idx = getChildrenIdx(ch);

            return children[idx];
        }

        public TrieNode[] getChildren() {
            return children;
        }

        public static int getChildrenIdx(char ch) {
            return ch - 'a';
        }

    }

}

// 914ms, 46.18MB
class MagicDictionary2 {

    private final TrieNode root = new TrieNode();

    // O(L_avg * N_dict)
    public void buildDict(String... dictionary) {
        for (var word : dictionary) {
            var trie = root.addChild(word.charAt(0));

            for (int i = 1; i < word.length(); i++) {
                trie = trie.addChild(word.charAt(i));
            }

            trie.markAsFinish();
        }
    }

    // O(L_searchWord * 26)
    public boolean search(String searchWord) {
        return isMatch(searchWord, 0, root, 0);
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

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
