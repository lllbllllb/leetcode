package org.lllbllllb.problems.maximumproductsubarray;

/**
 * <a href="https://leetcode.com/problems/maximum-product-subarray/">152. Maximum Product Subarray</a>
 */
class Solution {

    // 0 ms, 42.7 MB
    public int maxProduct(int[] nums) {
        var res = nums[0];
        var product = 1;

        for (int i = 0; i < nums.length; i++) {
            var num = nums[i];
            product *= num;
            res = Math.max(res, product);

            if (num == 0) {
                product = 1;
            }
        }

        product = 1;

        for (int i = nums.length - 1; i > -1; i--) {
            var num = nums[i];
            product *= num;
            res = Math.max(res, product);

            if (num == 0) {
                product = 1;
            }
        }

        return res;
    }

    // 2 ms, 43.0 MB
    public int maxProduct3(int[] nums) {
        var res = nums[0];
        var max = 1;
        var min = 1;

        for (var num : nums) {
            var tmp = max * num;
            max = Math.max(num, Math.max(tmp, min * num));
            min = Math.min(num, Math.min(tmp, min * num));
            res = Math.max(res, max);
        }

        return res;
    }

    // 2 ms, 43.1 MB
    public int maxProduct2(int[] nums) {
        var max = nums[0];
        var dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < dp.length; i++) {
            var prev = dp[i - 1];

            if (prev == 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = prev * nums[i];
            }
            max = Math.max(dp[i], max);
        }

        max = Math.max(max, nums[nums.length - 1]);
        dp[0] = nums[nums.length - 1];

        for (int i = 1; i < dp.length; i++) {
            var prev = dp[i - 1];

            if (prev == 0) {
                dp[i] = nums[dp.length - 1 - i];
            } else {
                dp[i] = prev * nums[dp.length - 1 - i];
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }

    // 282 ms, 43 MB (brute force)
    public int maxProduct1(int[] nums) {
        var max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            var tmp = 1;

            for (int j = i; j < nums.length; j++) {
                tmp *= nums[j];
                max = Math.max(tmp, max);
            }
        }

        return max;
    }
}
