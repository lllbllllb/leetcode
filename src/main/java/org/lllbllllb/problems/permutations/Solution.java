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

}

// 1 ms, 43 MB
class Solution1 {

    public List<List<Integer>> permute(int[] nums) {
        var res = new ArrayList<List<Integer>>();

        backtracking(nums, res, 0);

        return res;
    }

    private void backtracking(int[] nums, List<List<Integer>> res, int cursor) {
        if (cursor == nums.length) {
            res.add(toList(nums));
            return;
        }

        for (int i = cursor; i < nums.length; i++) {
            swap(nums, i, cursor);
            backtracking(nums, res, cursor + 1);
            swap(nums, i, cursor);
        }
    }

    private List<Integer> toList(int[] nums) {
        var list = new ArrayList<Integer>(nums.length);

        for (var num : nums) {
            list.add(num);
        }

        return list;
    }

    private void swap(int[] nums, int x, int y) {
        var tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}