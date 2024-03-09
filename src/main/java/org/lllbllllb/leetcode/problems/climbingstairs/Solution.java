package org.lllbllllb.leetcode.problems.climbingstairs;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/">70. Climbing Stairs</a>
 */
// 0 ms, 39 MB | fine-tuning
class Solution {

    public int climbStairs(int n) {
        var one = 1;
        var two = 1;

        for (int i = 0; i < n - 1; i++) {
            var next = one + two;
            one = two;
            two = next;
        }

        return two;
    }

}

// 0 ms, 39 MB | bottom up
class Solution1 {

    public int climbStairs(int n) {
        // [1, 1, 2, 3, 5, 8, 13, ..., m]
        var res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;

        for (int i = 2; i < res.length; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }

        return res[n];
    }
}