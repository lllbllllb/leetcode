package org.lllbllllb.problems.jumpgameii;

/**
 * <a href="https://leetcode.com/problems/jump-game-ii/">45. Jump Game II</a>
 */
class Solution {

    // 1 ms, 44.9 MB
    public int jump(int[] nums) {
        var count = 0;
        var idx = 0;
        var target = 0;

        while (target < nums.length - 1) {
            var nextTarget = target;

            for (int i = idx; i <= target; i++) {
                nextTarget = Math.max(nextTarget, i + nums[i]);
            }

            idx = target;

            if (nextTarget > target) {
                count++;
                target = nextTarget;
            }
        }

        return count;
    }

    // 23 ms, 44.5 MB
    public int jump2(int[] nums) {
        var to = nums.length - 1;
        var counts = new int[nums.length];
        counts[to] = 0;

        for (int i = to - 1; i >= 0; i--) {
            var jump = nums[i];

            if (i + jump >= to) {
                counts[i] = 1;
            } else if (jump == 0) {
                counts[i] = 10_000;
            } else {
                var jumpTo = i + jump;
                var min = counts[jumpTo];

                for (int j = i + 1; j < jumpTo; j++) {
                    min = Math.min(min, counts[j]);
                }

                counts[i] = min + 1;
            }
        }

        return counts[0];
    }
}
