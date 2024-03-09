package org.lllbllllb.leetcode.problems.binarysearch;

/**
 * <a href="https://leetcode.com/problems/binary-search/">704. Binary Search</a>
 */
class Solution {

    public int search(int[] nums, int target) {
        var from = 0;
        var to = nums.length - 1;

        while (from <= to) {
            var idx = (from + to) / 2;
            var val = nums[idx];

            if (val > target) {
                to = idx - 1;
            } else if (val < target) {
                from = idx + 1;
            } else {
                return idx;
            }
        }

        return -1;
    }
}
