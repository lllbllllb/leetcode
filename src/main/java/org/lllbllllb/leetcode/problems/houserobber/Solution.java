package org.lllbllllb.leetcode.problems.houserobber;

/**
 * <a href="https://leetcode.com/problems/house-robber/">198. House Robber</a>
 */
class Solution {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        var availableToNext = nums[0];
        var forbiddenToNext = nums[1];

        for (int i = 2; i < nums.length; i++) {
            var next = nums[i];
            var tmp = forbiddenToNext;
            forbiddenToNext = Math.max(availableToNext + next, forbiddenToNext);
            availableToNext = Math.max(availableToNext, tmp);
        }

        return Math.max(availableToNext, forbiddenToNext);
    }
}
