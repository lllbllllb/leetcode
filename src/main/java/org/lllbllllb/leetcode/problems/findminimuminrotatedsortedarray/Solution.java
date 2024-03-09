package org.lllbllllb.leetcode.problems.findminimuminrotatedsortedarray;

/**
 * <a href="https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/">153. Find Minimum in Rotated Sorted Array</a>
 */
class Solution {

    public int findMin(int[] nums) {
        var min = nums[0];
        var from = 1;
        var to = nums.length - 1;

        while (from <= to) {
            var idx = (from + to) / 2;
            var val = nums[idx];

            if (val > min) {
                from = idx + 1;
            } else if (val < min) {
                min = val;
                to = idx - 1;
            }
        }

        return min;
    }
}
