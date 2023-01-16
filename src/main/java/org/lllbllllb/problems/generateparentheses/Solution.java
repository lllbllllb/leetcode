package org.lllbllllb.problems.generateparentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/generate-parentheses/">22. Generate Parentheses</a>
 */
class Solution {

    public List<String> generateParenthesis(int n) {
        var res = new ArrayList<String>();

        backTracking(n, n, "", res);

        return res;
    }

    private void backTracking(int openLeft, int closeLeft, String current, List<String> res) {
        if (openLeft == 0 && closeLeft == 0) {
            res.add(current);
        }

        if (openLeft > 0) {
            backTracking(openLeft - 1, closeLeft, current + "(", res);
        }

        if (closeLeft > 0 && closeLeft > openLeft) {
            backTracking(openLeft, closeLeft - 1, current + ")", res);
        }
    }
}
