package org.lllbllllb.problems.rotatearray;

/**
 * @see <a href="https://leetcode.com/problems/rotate-array/">189. Rotate Array</a>
 */
class Solution {

    // 0ms
    // O(k) mem
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

    // Time Limit Exceeded
    // O(1) mem
    public void rotate1(int[] nums, int k) {
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
