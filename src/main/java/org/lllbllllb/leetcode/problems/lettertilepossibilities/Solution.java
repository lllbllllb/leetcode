package org.lllbllllb.leetcode.problems.lettertilepossibilities;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/letter-tile-possibilities/">1079. Letter Tile Possibilities</a>
 */
class Solution {

    // 3 ms
    public int numTilePossibilities(String tiles) {
        var counter = new int[26];

        for (int i = 0; i < tiles.length(); i++) {
            var c = tiles.charAt(i);

            counter[c - 'A']++;
        }

        return backtracking(counter);
    }

    public int backtracking(int[] counter) {
        var count = 0;

        for (int i = 0; i < counter.length; i++) {
            var val = counter[i];

            if (val > 0) {
                counter[i]--;
                count = count + 1 + backtracking(counter); // current count + 1 for current letter + others count
                counter[i]++;
            }

        }

        return count;
    }

    // 59 ms
    public int numTilePossibilities2(String tiles) {
        var res = new HashSet<String>();

        backtracking(tiles, res, 0, "", new HashSet<>());

        return res.size();
    }

    public void backtracking(String tiles, Set<String> res, int cursor, String tmp, Set<Integer> visited) {
        if (cursor < tiles.length()) {
            for (int i = 0; i < tiles.length(); i++) {
                if (!visited.contains(i)) {
                    var val = tiles.charAt(i);
                    var tmp1 = tmp + val;
                    res.add(tmp1);
                    visited.add(i);
                    backtracking(tiles, res, cursor + 1, tmp1, visited);
                    visited.remove(i);
                }
            }
        }
    }
}
