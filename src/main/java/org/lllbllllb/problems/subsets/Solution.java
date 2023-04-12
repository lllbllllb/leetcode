package org.lllbllllb.problems.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets/">78. Subsets</a>
 */
class Solution {

    // 1 ms, 42.9 MB
    public List<List<Integer>> subsets(int[] nums) {
        var res = new ArrayList<List<Integer>>();

        backtracking(nums, 0, new ArrayList<>(), res);

        return res;
    }

    private void backtracking(int[] nums, int cursor, List<Integer> sub, List<List<Integer>> res) {
        if (cursor == nums.length) {
            res.add(List.copyOf(sub));

            return;
        }

        sub.add(nums[cursor]);
        backtracking(nums, cursor + 1, sub, res);
        sub.remove(sub.size() - 1);
        backtracking(nums, cursor + 1, sub, res);
    }

    // 1 ms, 42.2 MB
    public List<List<Integer>> subsets2(int[] nums) {
        var res = new ArrayList<List<Integer>>();

        backtracking2(nums, 0, new ArrayList<>(), res);

        return res;
    }

    public void backtracking2(int[] nums, int cursor, List<Integer> tmp, List<List<Integer>> res) {
        res.add(List.copyOf(tmp));

        for (int i = cursor; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtracking2(nums, i + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

    // 1 ms, 43.7 MB
    public List<List<Integer>> subsets1(int[] nums) {
        var res = new ArrayList<List<Integer>>();

        backtracking1(nums, 0, res);

        return res;
    }

    public void backtracking1(int[] nums, int cursor, List<List<Integer>> res) {
        if (cursor == nums.length) {
            var sub = new ArrayList<Integer>();

            for (var i : nums) {
                if (i != Integer.MIN_VALUE) {
                    sub.add(i);
                }
            }

            res.add(sub);
        } else {
            var val = nums[cursor];
            nums[cursor] = Integer.MIN_VALUE;
            backtracking1(nums, cursor + 1, res);
            nums[cursor] = val;
            backtracking1(nums, cursor + 1, res);
        }
    }
}
