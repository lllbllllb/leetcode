package org.lllbllllb.problems.containerwithmostwater;

/**
 * <a href="https://leetcode.com/problems/container-with-most-water">11. Container With Most Water</a>
 */
class Solution {

    public int maxArea(int[] height) {
        var res = 0;
        var len = height.length;
        var left = 0;
        var right = len - 1;

        while (left < right) {
            var lH = height[left];
            var rH = height[right];
            var dist = right - left;

            if (lH < rH) {
                res = Math.max(res, dist * lH);

                while (left < right && height[left] <= lH) {
                    left++;
                }
            } else {
                res = Math.max(res, dist * rH);

                while (left < right && height[right] <= rH) {
                    right--;
                }
            }
        }

        return res;
    }
}
