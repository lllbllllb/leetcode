package org.lllbllllb.problems.houserobberii;

/**
 * <a href="https://leetcode.com/problems/house-robber-ii/">213. House Robber II</a>
 */
class Solution {

    // 0 ms, 40.3 MB
    public int rob(int[] nums) {
        var n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        var first = robHelper(nums, 0, n - 1);
        var second = robHelper(nums, 1, n);

        return Math.max(first, second);
    }

    private int robHelper(int[] nums, int from, int to) {
        var one = 0;
        var two = 0;

        for (int i = from; i < to; i++) {
            var next = nums[i];
            var tmp = two;
            two = Math.max(one + next, two);
            one = Math.max(one, tmp);
        }

        return Math.max(one, two);
    }

    // 0 ms, 40.3 MB
    public int rob1(int[] nums) {
        var n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        var one = nums[0];
        var two = nums[1];
        var endOne = nums[n - 1];
        var endTwo = nums[n - 2];

        for (int i = 2; i < n - 1; i++) {
            var next = nums[i];
            var tmp = two;
            two = Math.max(next + one, two);
            one = Math.max(one, tmp);

            var endNext = nums[n - i - 1];
            var endTmp = endTwo;
            endTwo = Math.max(endNext + endOne, endTwo);
            endOne = Math.max(endTmp, endOne);
        }

        return Math.max(Math.max(one, two), Math.max(endOne, endTwo));
    }
}
