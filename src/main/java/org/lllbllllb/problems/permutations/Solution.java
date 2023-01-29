package org.lllbllllb.problems.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @see <a href="https://leetcode.com/problems/permutations/description/">46. Permutations</a>
 */
class Solution {

    // 1 ms
    public List<List<Integer>> permute(int[] nums) {
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

    // 1 ms
    public List<List<Integer>> permute1(int[] nums) {
        var res = new ArrayList<List<Integer>>();

        backtracking(nums, res, new ArrayList<>());

        return res;
    }

    private void backtracking(int[] nums, List<List<Integer>> res, List<Integer> curr) {
        if (curr.size() == nums.length) {
            res.add(List.copyOf(curr));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != Integer.MIN_VALUE) {
                    var val = nums[i];
                    curr.add(val);
                    nums[i] = Integer.MIN_VALUE;
                    backtracking(nums, res, curr);
                    curr.remove(curr.size() - 1);
                    nums[i] = val;
                }
            }
        }
    }
}
