package org.lllbllllb.leetcode.problems.twosum;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/two-sum/">1. Two Sum</a>
 */
class Solution {

    public int[] twoSum(int[] nums, int target) {
        var set = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            var left = nums[i];
            var right = target - left;
            var rightIdx = set.get(right);

            if (rightIdx != null) {
                return new int[]{i, rightIdx};
            }

            set.put(left, i);
        }

        throw new IllegalStateException("You may assume that each input would have exactly one solution");
    }
}
