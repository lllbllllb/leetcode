package org.lllbllllb.problems.subsetsii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/subsets-ii/">90. Subsets II</a>
 */
class Solution {

    // 1 ms, 42.7 MB
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // I did not catch so far, why sort is allowed =(

        return backtracking(nums, 0, new ArrayList<>(), new ArrayList<>());
    }

    private List<List<Integer>> backtracking(int[] nums, int cursor, List<Integer> sub, List<List<Integer>> res) {
        res.add(List.copyOf(sub));

        var prev = nums[0] - 1;

        for (int i = cursor; i < nums.length; i++) {
            var num = nums[i];

            if (num != prev) {
                sub.add(num);
                backtracking(nums, i + 1, sub, res);
                prev = sub.remove(sub.size() - 1);
            }
        }

        return res;
    }

    // 3 ms, 42.6 MB
    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        Arrays.sort(nums); // I did not catch so far, why sort is allowed =(

        return backtracking(nums, 0, new ArrayList<>(), new ArrayList<>(), new HashSet<>());
    }

    private List<List<Integer>> backtracking(int[] nums, int cursor, List<Integer> sub, List<List<Integer>> res, Set<List<Integer>> saved) {
        var list = List.copyOf(sub);

        if (cursor == nums.length) {
            if (saved.add(list)) {
                res.add(List.copyOf(sub));
            }

            return res;
        }

        sub.add(nums[cursor]);
        backtracking(nums, cursor + 1, sub, res, saved);
        sub.remove(sub.size() - 1);
        backtracking(nums, cursor + 1, sub, res, saved);

        return res;
    }
}
