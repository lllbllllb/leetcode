package org.lllbllllb.problems.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/subsets/">78. Subsets</a>
 */
class Solution {

    // 1 ms
    public List<List<Integer>> subsets(int[] nums) {
        var res = new ArrayList<List<Integer>>();

        backtracking(nums, 0, new ArrayList<>(), res);

        return res;
    }

    public void backtracking(int[] nums, int cursor, List<Integer> tmp, List<List<Integer>> res) {
        res.add(List.copyOf(tmp));
        System.out.println(tmp);

        for (int i = cursor; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(nums, i + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

    // 1 ms
    public List<List<Integer>> subsets1(int[] nums) {
        var res = new ArrayList<List<Integer>>();

        backtracking(nums, 0, res);

        return res;
    }

    public void backtracking(int[] nums, int cursor, List<List<Integer>> res) {
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
            backtracking(nums, cursor + 1, res);
            nums[cursor] = val;
            backtracking(nums, cursor + 1, res);
        }
    }
}
