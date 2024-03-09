package org.lllbllllb.leetcode.problems.editdistance;

/**
 * <a href="https://leetcode.com/problems/edit-distance/">72. Edit Distance</a>
 */
class Solution {

    // 2ms, 43.75MB
    public int minDistance(String word1, String word2) {
        return dfs(word1, 0, word2, 0, new Integer[word1.length()][word2.length()]);
    }


    private int dfs(String word1, int cursor1, String word2, int cursor2, Integer[][] mem) {
        if (word1.length() == cursor1 && word2.length() == cursor2) {
            return 0;
        }

        if (word1.length() == cursor1) {
            return word2.length() - cursor2;
        }

        if (word2.length() == cursor2) {
            return word1.length() - cursor1;
        }

        if (mem[cursor1][cursor2] != null) {
            return mem[cursor1][cursor2];
        }

        var c1 = word1.charAt(cursor1);
        var c2 = word2.charAt(cursor2);
        // c1 == c2
        var distance = dfs(word1, cursor1 + 1, word2, cursor2 + 1, mem);

        if (c1 != c2) {
            distance = 1 + Math.min(
                distance,
                Math.min(
                    dfs(word1, cursor1, word2, cursor2 + 1, mem),
                    dfs(word1, cursor1 + 1, word2, cursor2, mem)
                )
            );
        }

        return mem[cursor1][cursor2] = distance;
    }
}
