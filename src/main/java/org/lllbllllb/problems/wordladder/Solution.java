package org.lllbllllb.problems.wordladder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/word-ladder/">127. Word Ladder</a>
 */
class Solution {

    // 33 ms, 47.9 MB
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        var maskedWordToMatches = new HashMap<String, List<String>>();

        for (var word : wordList) {
            var chars = word.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                var maskedWord = maskByIdx(chars, i);
                var matches = maskedWordToMatches.computeIfAbsent(maskedWord, mw -> new ArrayList<>());
                matches.add(word);
            }
        }

        var bfs = new LinkedList<LevelRegistrar>();
        bfs.add(new LevelRegistrar(beginWord, 1));
        var visited = new HashSet<String>();

        while (!bfs.isEmpty()) {
            var levelRegistrar = bfs.poll();
            var word = levelRegistrar.word().toCharArray();
            var level = levelRegistrar.level();

            for (int i = 0; i < word.length; i++) {
                var maskedWord = maskByIdx(word, i);

                if (maskedWordToMatches.containsKey(maskedWord)) {
                    for (var match : maskedWordToMatches.get(maskedWord)) {
                        if (endWord.equals(match)) {
                            return level + 1;
                        }

                        if (!visited.contains(match)) {
                            bfs.offer(new LevelRegistrar(match, level + 1));
                            visited.add(match);
                        }
                    }
                }
            }
        }

        return 0;
    }

    private record LevelRegistrar(String word, int level) {}

    private String maskByIdx(char[] array, int idx) {
        var tmp = array[idx];
        array[idx] = '*';
        var maskedWord = new String(array);
        array[idx] = tmp;

        return maskedWord;
    }

    // 101 ms, 45.4 MB
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        var wordSet = new HashSet<>(wordList);
        var bfs = new LinkedList<List<String>>();
        bfs.add(List.of(beginWord));
        var visited = new HashSet<String>();

        while (!bfs.isEmpty()) {
            var levelSize = bfs.size();

            for (int i = 0; i < levelSize; i++) {
                var path = bfs.poll();
                var lastWord = path.get(path.size() - 1).toCharArray();

                for (int j = 0; j < lastWord.length; j++) {
                    var original = lastWord[j];

                    for (var c = 'a'; c <= 'z'; c++) {
                        if (c != original) {
                            lastWord[j] = c;
                            var step = new String(lastWord);

                            if (!visited.contains(step)) {
                                if (wordSet.contains(step)) {
                                    visited.add(step);
                                    var extPath = new ArrayList<>(path);
                                    extPath.add(step);

                                    if (step.equals(endWord)) {
                                        return extPath.size();
                                    }

                                    bfs.add(extPath);
                                }
                            }
                        }
                    }

                    lastWord[j] = original;
                }
            }
        }

        return 0;
    }

    // 100 ms, 45.4 MB
    public int ladderLength4(String beginWord, String endWord, List<String> wordList) {
        var wordSet = new HashSet<>(wordList);
        var bfs = new LinkedList<String>();
        bfs.add(beginWord);
        int level = 1;
        var visited = new HashSet<String>();
        visited.add(beginWord);

        while (!bfs.isEmpty()) {
            level++;
            var levelSize = bfs.size();

            for (int i = 0; i < levelSize; i++) {
                var lastWord = bfs.poll().toCharArray();

                for (int j = 0; j < lastWord.length; j++) {
                    var original = lastWord[j];

                    for (var c = 'a'; c <= 'z'; c++) {
                        if (c != original) {
                            lastWord[j] = c;
                            var step = new String(lastWord);

                            if (!visited.contains(step)) {
                                if (wordSet.contains(step)) {
                                    if (step.equals(endWord)) {
                                        return level;
                                    }

                                    visited.add(step);
                                    bfs.add(step);
                                }
                            }
                        }
                    }

                    lastWord[j] = original;
                }
            }
        }

        return 0;
    }

    // Time Limit Exceeded
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        var wordHash = new HashSet<>(wordList);
        var bfs = new LinkedList<Path>();
        bfs.add(new Path(beginWord));

        while (!bfs.isEmpty()) {
            var path = bfs.poll();
            var head = path.getLastWord().toCharArray();

            for (int i = 0; i < head.length; i++) {
                var originalC = head[i];

                for (var c = 'a'; c <= 'z'; c++) {
                    if (c == originalC) {
                        continue;
                    }

                    head[i] = c;

                    var tmpWord = new String(head);
                    if (path.isVisited(tmpWord) || !wordHash.contains(tmpWord)) {
                        continue;
                    }

                    var fork = path.fork(tmpWord);
                    bfs.offer(fork);

                    if (endWord.equals(tmpWord)) {
                        return fork.path.size();
                    }
                }

                head[i] = originalC;
            }
        }

        return 0;
    }

    private static final class Path {

        private final Set<String> visited = new HashSet<>();

        private final List<String> path = new ArrayList<>();

        Path(String word) {
            visited.add(word);
            path.add(word);
        }

        Path(Path path) {
            this.visited.addAll(path.visited);
            this.path.addAll(path.path);
        }

        Path fork(String word) {
            var newPath = new Path(this);
            newPath.visited.add(word);
            newPath.path.add(word);

            return newPath;
        }

        boolean isVisited(String word) {
            return visited.contains(word);
        }

        String getLastWord() {
            return path.get(path.size() - 1);
        }
    }

    // Time Limit Exceeded
    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        var res = new ArrayList<List<String>>();
        var initPath = new ArrayList<String>();
        initPath.add(beginWord);

        dfs(beginWord.toCharArray(), endWord, new HashSet<>(wordList), new HashSet<>(), initPath, res);

        if (res.size() == 0) {
            return 0;
        }

        var min = res.get(0).size();

        for (var path : res) {
            min = Math.min(min, path.size());
        }

        return min;
    }

    private void dfs(char[] wordArray, String endWord, HashSet<String> wordHash, Set<String> used, List<String> seq, List<List<String>> res) {
        var targetWord = new String(wordArray);

        if (targetWord.equals(endWord)) {
            res.add(List.copyOf(seq));

            return;
        }

        if (used.size() == wordHash.size()) {
            return;
        }

        for (int i = 0; i < wordArray.length; i++) {
            var tmp = wordArray[i];

            for (var c = 'a'; c <= 'z'; c++) {
                wordArray[i] = c;
                var nextWord = new String(wordArray);

                if (wordHash.contains(nextWord) && !used.contains(nextWord)) {
                    seq.add(nextWord);
                    used.add(nextWord);
                    dfs(wordArray, endWord, wordHash, used, seq, res);
                    seq.remove(seq.size() - 1);
                    used.remove(nextWord);
                }

                wordArray[i] = tmp;
            }
        }
    }

}
