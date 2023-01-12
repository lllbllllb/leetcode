package org.lllbllllb.problems.findtheduplicatenumber;

/**
 * <a href="https://leetcode.com/problems/find-the-duplicate-number/">287. Find the Duplicate Number</a>
 */
class Solution {

    public int findDuplicate(int[] nums) {
        var res = -1;

        for (var val : nums) {
            var idx = Math.abs(val);

            if (nums[idx] < 0) {
                res = Math.abs(val);
                break;
            } else {
                nums[idx] = -nums[idx];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return res;
    }
}
