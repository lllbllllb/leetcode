package org.lllbllllb.problems.removekdigits;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/remove-k-digits/">402. Remove K Digits</a>
 */
class Solution {

    // 10 ms, 44.6 MB
    public String removeKdigits1(String num, int k) {
        var stack = new LinkedList<Character>();

        // make increased monotonic stack
        for (int i = 0; i < num.length(); i++) {
            var charI = num.charAt(i);

            // k keeps track how many characters we can remove
            while (!stack.isEmpty() && k > 0 && charI < stack.getFirst()) {
                stack.pop();
                k--;
            }

            stack.push(charI);
        }

        var res = new StringBuilder();
        var leadingZero = true;

        // if monotonic stack was build but not
        while (k > 0) {
            stack.pollFirst();
            k--;
        }

        while (!stack.isEmpty()) {
            var val = stack.pollLast();

            if (leadingZero && val != '0') {
                leadingZero = false;
            }

            if (!leadingZero) {
                res.append(val);
            }
        }

        if (res.isEmpty()) {
            return "0";
        }

        return res.toString();
    }

    // 3 ms, 42.1 MB
    public String removeKdigits(String num, int k) {
        var len = num.length();
        var stack = new char[len];
        var stackCursor = 0;

        for (int i = 0; i < len; i++) {
            var charI = num.charAt(i);

            while (stackCursor > 0 && k > 0 && charI < stack[stackCursor - 1]) {
                stackCursor--;
                stack[stackCursor] = Character.MIN_VALUE;
                k--;
            }

            stack[stackCursor] = charI;
            stackCursor++;
        }

        var firstNumIdx = 0;

        while (stack[firstNumIdx] == '0') {
            firstNumIdx++;
        }

        var resLen = stackCursor - k - firstNumIdx;

        if (resLen < 1) {
            return "0";
        }

        return new String(stack, firstNumIdx, resLen);
    }
}
