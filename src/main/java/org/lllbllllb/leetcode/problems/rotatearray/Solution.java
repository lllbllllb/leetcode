package org.lllbllllb.leetcode.problems.rotatearray;

/**
 * <a href="https://leetcode.com/problems/rotate-array/">189. Rotate Array</a>
 */
// 0ms
// O(k) mem
class Solution {

    public void rotate(int[] nums, int k) {
        var len = nums.length;

        if (k > len) {
            k = k % len;
        }

        var buff = new int[k];
        System.arraycopy(nums, len - k, buff, 0, k);
        System.arraycopy(nums, 0, nums, k, len - k);
        System.arraycopy(buff, 0, nums, 0, k);
    }

}

// Time Limit Exceeded
// O(1) mem
class Solution1 {

    public void rotate(int[] nums, int k) {
        var len = nums.length;

        if (k > len) {
            k = k % len;
        }

        for (int i = 0; i < k; i++) {
            var num = nums[len - 1];
            System.arraycopy(nums, 0, nums, 1, len - 1);
            nums[0] = num;
        }
    }
}