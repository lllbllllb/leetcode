package org.lllbllllb.problems.maximumsubarray;

class Solution {

    // 1ms, 51.9 MB
    public int maxSubArray(int[] nums) {
        var maxSum = nums[0];
        var currMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currMax = Math.max(nums[i], nums[i] + currMax);
            maxSum = Math.max(maxSum, currMax);
        }

        return maxSum;
    }

    // 2ms, 51.5 MB
    public int maxSubArray1(int[] nums) {
        var maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            maxSum = Math.max(maxSum, nums[i]);
        }

        return maxSum;
    }
}
