package org.lllbllllb.problems.combinationsumii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/combination-sum-ii/">40. Combination Sum II</a>
 */
// 2 ms, 43.1 MB
class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        return backtracking(candidates, 0, target, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> backtracking(int[] candidates, int cursor, int target, List<Integer> sub, List<List<Integer>> result) {
        if (target == 0) {
            result.add(List.copyOf(sub));

            return result;
        }

        var prevCandidate = 0; // 1 <= candidates[i] <= 50

        for (int i = cursor; i < candidates.length; i++) {
            var candidate = candidates[i];
            var rem = target - candidate;

            if (rem < 0 || rem == 0 && prevCandidate == candidate) {
                return result;
            }

            if (prevCandidate != candidate) {
                sub.add(candidate);
                backtracking(candidates, i + 1, rem, sub, result);
                prevCandidate = sub.remove(sub.size() - 1);
            }
        }

        return result;
    }

}

// 4 ms, 43.2 MB
class Solution1 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        return backtracking(candidates, 0, target, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> backtracking(int[] candidates, int cursor, int target, List<Integer> sub, List<List<Integer>> result) {
        if (target == 0) {
            result.add(List.copyOf(sub));

            return result;
        }

        if (target < 0 || cursor == candidates.length) {
            return result;
        }

        var prevCandidate = candidates[cursor] - 1;

        for (int i = cursor; i < candidates.length; i++) {
            var candidate = candidates[i];

            if (prevCandidate != candidate) {
                sub.add(candidate);
                backtracking(candidates, i + 1, target - candidate, sub, result);
                prevCandidate = sub.remove(sub.size() - 1);
            }
        }

        return result;
    }
}