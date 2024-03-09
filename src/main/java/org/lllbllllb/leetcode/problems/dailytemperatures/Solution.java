package org.lllbllllb.leetcode.problems.dailytemperatures;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/daily-temperatures/">739. Daily Temperatures</a>
 */
class Solution {

    // monotonic (decreasing) stack
    // 9 ms, 53 MB
    public int[] dailyTemperatures(int[] temperatures) {
        var res = new int[temperatures.length];
        var stack = new int[temperatures.length];
        var stackCursor = 1;

        for (int i = 1; i < temperatures.length; i++) {
            while (stackCursor > 0 && temperatures[i] > temperatures[stack[stackCursor - 1]]) {

                res[stack[stackCursor - 1]] = i - stack[stackCursor - 1];
                stackCursor--;
            }

            stack[stackCursor] = i;
            stackCursor++;
        }

        return res;
    }

    // monotonic (decreasing) stack
    // 23 ms, 58.2 MB
    public int[] dailyTemperatures1(int[] temperatures) {
        var res = new int[temperatures.length];
        var stack = new LinkedList<Integer>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.getFirst()]) {
                var last = stack.pop();
                res[last] = i - last;
            }

            stack.push(i);
        }

        return res;
    }

}
