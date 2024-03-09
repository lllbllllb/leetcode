package org.lllbllllb.leetcode.problems.jumpgame;

/**
 * <a href="https://leetcode.com/problems/jump-game/">55. Jump Game</a>
 */
class Solution {

    public boolean canJump(int[] nums) {
        var targetIdx = nums.length - 1;

        for (int i = targetIdx - 1; i >= 0; i--) {
            var currJump = nums[i];

            if (i + currJump >= targetIdx) {
                targetIdx = i;
            }
        }

        return targetIdx == 0;
    }
}
