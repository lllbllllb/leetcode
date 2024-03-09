package org.lllbllllb.leetcode.problems.findfirstandlastpositionofelementinsortedarray;

/**
 * <a href="https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/">34. Find First and Last Position of Element in Sorted Array</a>
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        var len = nums.length;
        var l = 0;
        var r = len - 1;
        var idx = -1;

        while (l <= r) {
            var mid = (r + l) / 2;
            var val = nums[mid];

            if (val > target) {
                r = mid - 1;
            } else if (val < target) {
                l = mid + 1;
            } else {
                idx = mid;
                break;
            }
        }

        if (idx == -1) {
            return new int[]{-1, -1};
        }

        var val = nums[idx];
        var res = new int[]{idx, idx};

        for (int i = res[0] - 1; i > -1 && nums[i] == val; i--) {
            res[0] = i;
        }

        for (int i = res[1] + 1; i < len && nums[i] == val; i++) {
            res[1] = i;
        }

        return res;
    }
}
