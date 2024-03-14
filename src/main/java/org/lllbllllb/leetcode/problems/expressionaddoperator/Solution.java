package org.lllbllllb.leetcode.problems.expressionaddoperator;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/expression-add-operators/">282. Expression Add Operators</a>
 */
class Solution {

    private static final String SHIFT = "<";
    private static final String ADD = "+";
    private static final String SUB = "-";
    private static final String MULT = "*";

    private static final List<String> DEBUG = List.of(MULT, MULT);

    public List<String> addOperators(String num, int target) {
        var nums = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            nums[i] = num.charAt(i) - '0';
        }

        var results = new ArrayList<List<String>>();
        var firstNum = nums[0];
        var tmpResults = new ArrayList<Integer>();
        tmpResults.add(firstNum);

        addOperators(nums, 1, tmpResults, target, new ArrayList<>(), results, new HashSet<>());

        var result = new ArrayList<String>();

        for (var res : results) {
            var tmp = new ArrayList<String>();
            tmp.add(String.valueOf(firstNum));

            for (int i = 0; i < res.size(); i++) {
                var operation = res.get(i);

                if (!SHIFT.equals(operation)) {
                    tmp.add(res.get(i));
                }

                tmp.add(String.valueOf(nums[i + 1]));
            }

            result.add(String.join("", tmp));
        }

        return result;
    }

    private boolean addOperators(int[] nums, int cursor, List<Integer> tmpResults, int target, List<String> tmp, List<List<String>> results, Set<String> failed) {
        var currentResult = 0;

        for (var res : tmpResults) {
            currentResult += res;
        }

        var cachedKey = cursor + "-" + currentResult;

        if (failed.contains(cachedKey)) {
            return false;
        }

        if (cursor == nums.length) {

            if (currentResult != target) {
                return false;
            }

            results.add(List.copyOf(tmp));

            return true;
        }

        var success = false;

        var num = nums[cursor];
        var lastTmpResult = tmpResults.get(tmpResults.size() - 1);
        var mult = lastTmpResult * num;

        tmp.add(MULT);
        tmpResults.set(tmpResults.size() - 1, mult);
        success |= addOperators(nums, cursor + 1, tmpResults, target, tmp, results, failed);
        tmpResults.set(tmpResults.size() - 1, lastTmpResult);
        tmp.remove(tmp.size() - 1);

        tmp.add(ADD);
        tmpResults.add(num);
        success |= addOperators(nums, cursor + 1, tmpResults, target, tmp, results, failed);
        tmpResults.remove(tmpResults.size() - 1);
        tmp.remove(tmp.size() - 1);

        tmp.add(SUB);
        tmpResults.add(-num);
        success |= addOperators(nums, cursor + 1, tmpResults, target, tmp, results, failed);
        tmpResults.remove(tmpResults.size() - 1);
        tmp.remove(tmp.size() - 1);

        var prevNum = nums[cursor - 1];

        if (prevNum != 0) {
            tmp.add(SHIFT);

            if (Math.abs(lastTmpResult) == prevNum) { //
                var appender = (lastTmpResult < 0 ? -num : num);
                var shifted = lastTmpResult * 10 + appender;
                tmpResults.set(tmpResults.size() - 1, shifted);
                success |= addOperators(nums, cursor + 1, tmpResults, target, tmp, results, failed);
                tmpResults.set(tmpResults.size() - 1, lastTmpResult);
            } else {
                tmpResults.set(tmpResults.size() - 1, lastTmpResult / prevNum);
                var shifted = prevNum * 10 + num;
                tmpResults.add(shifted);
                success |= addOperators(nums, cursor + 1, tmpResults, target, tmp, results, failed);
                tmpResults.remove(tmpResults.size() - 1);
                tmpResults.set(tmpResults.size() - 1, lastTmpResult);
            }

            tmp.remove(tmp.size() - 1);
        }

//        if (!success) {
//            failed.add(cachedKey);
//        }

        return success;
    }

    private boolean addOperators1(int[] nums, int cursor, List<Integer> tmpResults, int tmpVal, int target, List<String> tmp, List<List<String>> results, Set<Map.Entry<Integer, Integer>> failed) {
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

        tmp.add(MULT);
        tmpResults.set(tmpResults.size() - 1, mult);
        var multRes = addOperators1(nums, cursor + 1, tmpResults, tmpVal - prev + mult, target, tmp, results, failed);
        tmp.remove(tmp.size() - 1);
        tmpResults.set(tmpResults.size() - 1, prev);

        tmp.add(ADD);
        tmpResults.add(num);
        var sumRes = addOperators1(nums, cursor + 1, tmpResults, tmpVal + num, target, tmp, results, failed);
        tmp.remove(tmp.size() - 1);
        tmpResults.remove(tmpResults.size() - 1);

        tmp.add(SUB);
        tmpResults.add(-num);
        var subRes = addOperators1(nums, cursor + 1, tmpResults, tmpVal - num, target, tmp, results, failed);
        tmp.remove(tmp.size() - 1);
        tmpResults.remove(tmpResults.size() - 1);

        var prevNum = nums[cursor - 1];

        if (Math.abs(prev) == prevNum && prev != 0) {
            var appender = (prev < 0 ? -num : num);
            var shifted = prev * 10 + appender;
            tmp.add(SHIFT);
            tmpResults.set(tmpResults.size() - 1, shifted);
            var shiftRes = addOperators1(nums, cursor + 1, tmpResults, tmpVal - prev + shifted, target, tmp, results, failed);
            tmp.remove(tmp.size() - 1);
            tmpResults.set(tmpResults.size() - 1, prev);
        } else if (prevNum != 0) {
            var shifted = prev * 10 + num;
            tmp.add(SHIFT);
            tmpResults.set(tmpResults.size() - 1, tmpVal / prevNum);
            tmpResults.add(tmpVal / prevNum);
            var shiftRes = addOperators1(nums, cursor + 1, tmpResults, tmpVal / prevNum + shifted, target, tmp, results, failed);
            tmp.remove(tmp.size() - 1);
            tmpResults.set(tmpResults.size() - 1, prev);
        }

        return false;
    }
}
