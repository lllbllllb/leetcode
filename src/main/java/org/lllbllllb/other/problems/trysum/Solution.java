package org.lllbllllb.other.problems.trysum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a list of numbers <strong>nums</strong> and a number <strong>target</strong>.
 * <br>
 * Using only the <strong>+</strong> (addition) and <strong>-</strong> (subtraction) operations between all <strong>nums</strong>
 * return <strong>true</strong> if target reachable or <strong>false</strong> otherwise.
 * <br>
 * Follow-up: return a string of result numbers with operators like <strong>1+2-3+4</strong> or empty string.
 */
class Solution {

    public String trySum(int[] nums, int target) {
        var res = new ArrayList<String>(nums.length * 2);

        backtracking(nums, 0, target, 0, res, new HashSet<>());

        if (res.isEmpty()) {
            return "";
        }

        var formula = new StringBuilder();
        var i = "+".equals(res.get(0)) ? 1 : 0;

        for (; i < res.size(); i++) {
            formula.append(res.get(i));
        }

        return formula.toString();
    }

    private boolean backtracking(int[] nums, int cursor, int target, int current, List<String> res, Set<List<String>> unreacheble) {
        if (cursor == nums.length) {
            return current == target;
        }

        var num = nums[cursor];

        cursor++;

        if (unreacheble.contains(res)) {
            return false;
        }

        res.add("+");
        res.add(String.valueOf(num));

        var resSum = backtracking(nums, cursor, target, current + num, res, unreacheble);

        if (resSum) {
            return true;
        }

        res.remove(res.size() - 1);
        res.remove(res.size() - 1);

        res.add("-");
        res.add(String.valueOf(num));

        var resSub = backtracking(nums, cursor, target, current - num, res, unreacheble);

        if (resSub) {
            return true;
        }

        res.remove(res.size() - 1);
        res.remove(res.size() - 1);

        unreacheble.add(List.copyOf(res));

        return false;
    }

}
