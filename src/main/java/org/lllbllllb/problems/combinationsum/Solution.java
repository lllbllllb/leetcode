package org.lllbllllb.problems.combinationsum;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum/">39. Combination Sum</a>
 */
class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var res = new ArrayList<List<Integer>>();

        backtracking(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    // 2 ms, 42.8 MB
    private void backtracking(int[] candidates, int target, int cursor, List<Integer> sub, List<List<Integer>> res) {
        if (target == 0) {
            res.add(List.copyOf(sub));
            return;
        } else if (target < 0 || cursor == candidates.length) {
            return;
        }

        var candidate = candidates[cursor];
        sub.add(candidate);
        backtracking(candidates, target - candidate, cursor, sub, res);
        sub.remove(sub.size() - 1);
        backtracking(candidates, target, cursor + 1, sub, res);
    }

    // 2 ms, 43.1 MB
    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        var res = new ArrayList<List<Integer>>();

        backtracking1(candidates, target, 0, new ArrayList<>(), res);

        return res;
    }

    private void backtracking1(int[] candidates, int target, int cursor, List<Integer> sub, List<List<Integer>> res) {
        if (target == 0) {
            res.add(List.copyOf(sub));

            return;
        } else if (target < 0) {
            return;
        }

        for (int i = cursor; i < candidates.length; i++) {
            var candidate = candidates[i];

            sub.add(candidate);
            backtracking1(candidates, target - candidate, i, sub, res);
            sub.remove(sub.size() - 1);
        }
    }
}
