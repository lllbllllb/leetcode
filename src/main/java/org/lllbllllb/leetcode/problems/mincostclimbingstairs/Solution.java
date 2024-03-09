package org.lllbllllb.leetcode.problems.mincostclimbingstairs;

/**
 * <a href="https://leetcode.com/problems/min-cost-climbing-stairs/">746. Min Cost Climbing Stairs</a>
 */
class Solution {

    // 0 ms, 42.8 MB | fine-tuning
    public int minCostClimbingStairs(int[] cost) {
        var n = cost.length;
        var one = cost[0];
        var two = cost[1];

        for (int i = 2; i < n; i++) {
            var next = cost[i] + Math.min(one, two);
            one = two;
            two = next;
        }

        return Math.min(one, two);
    }

    // 1 ms, 42.4 MB | bottom-up
    public int minCostClimbingStairs1(int[] cost) {
        var n = cost.length;
        var dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
