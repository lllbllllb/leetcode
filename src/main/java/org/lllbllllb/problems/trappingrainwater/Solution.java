package org.lllbllllb.problems.trappingrainwater;

/**
 * <a href="https://leetcode.com/problems/trapping-rain-water/">42. Trapping Rain Water</a>
 */
class Solution {

    public int trap(int[] height) {
        var len = height.length;
        var left = new int[len];
        var right = new int[len];

        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i - 1]);
            var tailIdx = len - 1 - i;
            right[tailIdx] = Math.max(right[tailIdx + 1], height[tailIdx + 1]);
        }

        var res = 0;

        for (int i = 0; i < len; i++) {
            var vol = Math.min(left[i], right[i]);
            var h = height[i];
            var delta = vol - h;

            if (delta > 0) {
                res += delta;
            }
        }

        return res;
    }
}
