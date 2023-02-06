package org.lllbllllb.problems.medianoftwosortedarrays;

/**
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/description/">4. Median of Two Sorted Arrays</a>
 */
class Solution {

    // TODO
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var len1 = nums1.length;
        var len2 = nums2.length;

        if (len1 == 0) {
            return getMedian(nums2);
        }

        if (len2 == 0) {
            return getMedian(nums1);
        }

        var totalLength = len1 + len2;

        var m1 = getMedian(nums1);
        var m2 = getMedian(nums2);

        return (m1 + m2) / 2;
    }

    private double getMedian(int[] nums) {
        var len = nums.length;

        if (len == 0) {
            return 0;
        }

        if (len % 2 == 0) {
            return ((double) (nums[len / 2] + nums[len / 2 - 1])) / 2;
        } else {
            return (double) nums[len / 2];
        }
    }
}
