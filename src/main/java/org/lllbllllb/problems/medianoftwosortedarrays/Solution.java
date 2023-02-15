package org.lllbllllb.problems.medianoftwosortedarrays;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/median-of-two-sorted-arrays/description/">4. Median of Two Sorted Arrays</a>
 */
class Solution {

    // TODO
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }

    // 4 ms, 43.2 MB, O(m + n) - incorrect
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        var len1 = nums1.length;
        var len2 = nums2.length;
        var sum = new int[len1 + len2];

        System.arraycopy(nums1, 0, sum, 0, len1);
        System.arraycopy(nums2, 0, sum, len1, len2);
        Arrays.sort(sum);

        var right = (double) sum[sum.length / 2];

        return sum.length % 2 != 0 ? right : (right + sum[sum.length / 2 - 1]) / 2;
    }

    public double findMedianSortedArrays_(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return getMedian(nums2);
        }

        if (nums2.length == 0) {
            return getMedian(nums1);
        }

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
            return nums[len / 2];
        }
    }
}
