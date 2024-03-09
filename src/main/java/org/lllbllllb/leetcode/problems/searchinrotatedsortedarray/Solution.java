package org.lllbllllb.leetcode.problems.searchinrotatedsortedarray;

/**
 * <a href="https://leetcode.com/problems/search-in-rotated-sorted-array/">33. Search in Rotated Sorted Array</a>
 */
class Solution {

    // 0 ms, 41.9 MB
    public int search(int[] nums, int target) {
        var base = nums[0];
        var from = 0;
        var to = nums.length - 1;

        while (from <= to) {
            var idx = (from + to) / 2;
            var val = nums[idx];

            if (val < target) {
                if (target >= base && val < base) {
                    to = idx - 1;
                } else {
                    from = idx + 1;
                }
            } else if (val > target) {
                if (target < base && val >= base) {
                    from = idx + 1;
                } else {
                    to = idx - 1;
                }
            } else {
                return idx;
            }
        }

        return -1;
    }

    // 0 ms, 41.9 MB
    public int search1(int[] nums, int target) {
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
