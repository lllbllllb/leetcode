package org.lllbllllb.problems.nextgreaterelementii;

/**
 * <a href="https://leetcode.com/problems/next-greater-element-ii/">503. Next Greater Element II</a>
 */
class Solution {

    public int[] nextGreaterElements(int[] nums) {
        var len = nums.length;
        var res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = -1;
        }

        var stack = new int[len * 2];
        var stackCursor = 0;

        for (int i = 0; i < len * 2; i++) {
            var idx = i % len;
            var val = nums[idx];

            while (stackCursor > 0 && nums[stack[stackCursor - 1]] < val) {
                res[stack[stackCursor - 1]] = val;
                stackCursor--;
            }

            stack[stackCursor] = idx;
            stackCursor++;
        }

        return res;
    }
}
