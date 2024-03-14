package org.lllbllllb.leetcode.problems.expressionaddoperators;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> addOperators(String num, int target) {
        var nums = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            var dig = (int) num.charAt(i) - '0';
            nums[i] = dig;
        }

        var results = new ArrayList<List<String>>();

        addOperators(nums, 1, nums[0], "+", nums[0], target, new ArrayList<>(), results);

        var res = new ArrayList<String>();

        for (var result : results) {
            var tmp = new ArrayList<String>();
            tmp.add(String.valueOf(num.charAt(0)));

            for (int i = 0; i < result.size() - 1; i++) {
                tmp.add(result.get(i) + num.charAt(i + 1));
            }

            res.add(String.join("", tmp));
        }

        return res;
    }

    private void addOperators(int[] nums, int cursor, int prevVal, String prevOp, int currVal, int target, List<String> tmp, List<List<String>> res) {
        if (cursor == nums.length && currVal == target) {
            res.add(List.copyOf(tmp));

            return;
        }

        if (cursor == nums.length || currVal == target) {
            return;
        }

        var num = nums[cursor];

        tmp.add("*");
        var mult = prevVal * num;
        addOperators(nums, cursor + 1, mult, prevOp, mult, target, tmp, res);
        tmp.remove(tmp.size() - 1);

        tmp.add("+");
        addOperators(nums, cursor + 1, num, prevOp, currVal + num, target, tmp, res);
        tmp.remove(tmp.size() - 1);

        tmp.add("-");
        addOperators(nums, cursor + 1, num, prevOp, currVal - num, target + num, tmp, res);
        tmp.remove(tmp.size() - 1);
    }

}
