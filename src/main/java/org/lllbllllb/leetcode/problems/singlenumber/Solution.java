package org.lllbllllb.leetcode.problems.singlenumber;

/**
 * <a href="https://leetcode.com/problems/single-number/">136. Single Number</a>
 */
class Solution {

    public int singleNumber(int[] nums) {
        var res = 0;

        for (var num : nums) {
            res ^= num;
        }

        return res;
    }
}
