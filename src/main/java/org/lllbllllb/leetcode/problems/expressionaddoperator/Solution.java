package org.lllbllllb.leetcode.problems.expressionaddoperator;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/expression-add-operators/">282. Expression Add Operators</a>
 */
class Solution {

    public List<String> addOperators(String num, int target) {
        var nums = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            nums[i] = num.charAt(i) - '0';
        }

        var results = new ArrayList<List<String>>();
        var firstNum = nums[0];
        var tmpResults = new ArrayList<Integer>();
        tmpResults.add(firstNum);

        addOperators(nums, 1, tmpResults, firstNum, target, new ArrayList<>(), results, new HashSet<>());

        var result = new ArrayList<String>();

        for (var res : results) {
            var tmp = new ArrayList<String>();
            tmp.add(String.valueOf(firstNum));

            for (int i = 0; i < res.size(); i++) {
                var operation = res.get(i);

                if (!"|".equals(operation)) {
                    tmp.add(res.get(i));
                }

                tmp.add(String.valueOf(nums[i + 1]));
            }

            result.add(String.join("", tmp));
        }

        return result;
    }

    private boolean addOperators(int[] nums, int cursor, List<Integer> tmpResults, int tmpVal, int target, List<String> tmp, List<List<String>> results, Set<Map.Entry<Integer, Integer>> failed) {
        if (cursor == nums.length && tmpVal == target) {
            results.add(List.copyOf(tmp));

            return true;
        }

        if (cursor == nums.length) {
            return false;
        }

        var num = nums[cursor];
        var prev = tmpResults.get(tmpResults.size() - 1);
        var mult = prev * num;

        tmp.add("*");
        tmpResults.set(tmpResults.size() - 1, mult);
        var multRes = addOperators(nums, cursor + 1, tmpResults, tmpVal - prev + mult, target, tmp, results, failed);
        tmp.remove(tmp.size() - 1);
        tmpResults.set(tmpResults.size() - 1, prev);

        tmp.add("+");
        tmpResults.add(num);
        var sumRes = addOperators(nums, cursor + 1, tmpResults, tmpVal + num, target, tmp, results, failed);
        tmp.remove(tmp.size() - 1);
        tmpResults.remove(tmpResults.size() - 1);

        tmp.add("-");
        tmpResults.add(-num);
        var sumSub = addOperators(nums, cursor + 1, tmpResults, tmpVal - num, target, tmp, results, failed);
        tmp.remove(tmp.size() - 1);
        tmpResults.remove(tmpResults.size() - 1);

        if (Math.abs(prev) == nums[cursor - 1] && prev != 0) {
            var shifted = prev * 10 + num;
            tmp.add("|");
            tmpResults.set(tmpResults.size() - 1, shifted);
            var sumShift = addOperators(nums, cursor + 1, tmpResults, tmpVal - prev + shifted, target, tmp, results, failed);
            tmp.remove(tmp.size() - 1);
            tmpResults.set(tmpResults.size() - 1, prev);
        }

        return false;
    }
}