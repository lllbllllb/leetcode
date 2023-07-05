package org.lllbllllb.problems.partitionlabels;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/partition-labels/">763. Partition Labels</a>
 */
class Solution {

    // 5 ms, 41.3 MB
    public List<Integer> partitionLabels(String s) {
        var charToLastIdx = new int[26];

        for (int i = 0; i < s.length(); i++) {
            var charIdx = s.charAt(i) - 'a';
            charToLastIdx[charIdx] = i;
        }

        var res = new ArrayList<Integer>();
        var from = 0;
        var to = 0;

        for (int i = 0; i < s.length(); i++) {
            var charIdx = s.charAt(i) - 'a';

            if (i <= to) {
                to = Math.max(to, charToLastIdx[charIdx]);
            } else {
                res.add(to - from + 1);
                from = i;
                to = charToLastIdx[charIdx];
            }
        }

        res.add(to - from + 1);

        return res;
    }

    // 7 ms, 42.1 MB
    public List<Integer> partitionLabels2(String s) {
        var intervals = new int[s.length()];
        var charToFromIdx = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            var letter = s.charAt(i);

            if (charToFromIdx.containsKey(letter)) {
                var fromIdx = charToFromIdx.get(letter);
                intervals[fromIdx] = i;
            } else {
                charToFromIdx.put(letter, i);
            }

            intervals[i] = i;
        }

        var res = new ArrayList<Integer>();
        var from = 0;
        var to = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (i <= to) {
                to = Math.max(to, intervals[i]);
            } else {
                res.add(to - from + 1);
                from = i;
                to = intervals[i];
            }
        }

        res.add(to - from + 1);

        return res;
    }

    // 8 ms, 41.8 MB
    public List<Integer> partitionLabels1(String s) {
        var charToInterval = new HashMap<Character, int[]>();

        for (int i = 0; i < s.length(); i++) {
            var letter = s.charAt(i);

            if (charToInterval.containsKey(letter)) {
                charToInterval.get(letter)[1] = i;
            } else {
                charToInterval.put(letter, new int[]{i, i});
            }
        }

        var intervals = new ArrayList<>(charToInterval.values());
        intervals.sort(Comparator.comparingInt(i -> i[0]));

        var res = new ArrayList<Integer>();
        var from = intervals.get(0)[0];
        var to = intervals.get(0)[1];

        for (int i = 1; i < intervals.size(); i++) {
            var interval = intervals.get(i);

            if (interval[0] <= to) {
                to = Math.max(to, interval[1]);
            } else {
                res.add(to - from + 1);
                from = interval[0];
                to = interval[1];
            }
        }

        res.add(to - from + 1);

        return res;
    }

}
