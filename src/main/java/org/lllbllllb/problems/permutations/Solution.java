package org.lllbllllb.problems.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/permutations/description/">46. Permutations</a>
 */
class Solution {

    // 1 ms, 42.9 MB
    public List<List<Integer>> permute(int[] nums) {
        var res = new ArrayList<List<Integer>>();

        backtracking(nums, new boolean[nums.length], new ArrayList<>(nums.length), res);

        return res;
    }

    private void backtracking(int[] nums, boolean[] visited, List<Integer> sub, List<List<Integer>> res) {
        if (sub.size() == nums.length) {
            res.add(List.copyOf(sub));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    sub.add(nums[i]);
                    visited[i] = true;
                    backtracking(nums, visited, sub, res);
                    sub.remove(sub.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    // 1 ms, 43 MB
    public List<List<Integer>> permute2(int[] nums) {
        var res = new ArrayList<List<Integer>>();

        backtracking(nums, res, 0);

        return res;
    }

    private void backtracking(int[] nums, List<List<Integer>> res, int cursor) {
        if (cursor == nums.length) {
            var tmp = new ArrayList<Integer>(nums.length);

            for (var num : nums) {
                tmp.add(num);
            }

            res.add(tmp);
        } else {
            for (int i = cursor; i < nums.length; i++) {
                var ith = nums[i];
                var cth = nums[cursor];
                nums[i] = cth;
                nums[cursor] = ith;

                backtracking(nums, res, cursor + 1);

                nums[i] = ith;
                nums[cursor] = cth;
            }
        }
    }
}
