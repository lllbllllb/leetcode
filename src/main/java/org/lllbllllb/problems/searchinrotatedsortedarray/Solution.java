package org.lllbllllb.problems.searchinrotatedsortedarray;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">33. Search in Rotated Sorted Array</a>
 */
class Solution {

    public int search(int[] nums, int target) {
        var len = nums.length;
        var left = 0;
        var right = len - 1;

        while (left <= right) {
            var mid = (left + right) / 2;
            var midVal = nums[mid];
            var leftVal = nums[left];
            var rightVal = nums[right];

            if (midVal < target) {
                if (target <= rightVal || midVal >= leftVal) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (midVal > target) {
                if (target >= leftVal || midVal <= rightVal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                return mid; // key found
            }
        }

        return -1;
    }
}
