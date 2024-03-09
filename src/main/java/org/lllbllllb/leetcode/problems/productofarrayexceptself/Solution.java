package org.lllbllllb.leetcode.problems.productofarrayexceptself;

/**
 * <a href="https://leetcode.com/problems/product-of-array-except-self/">238. Product of Array Except Self</a>
 */
class Solution {

    // O(n), O(1)
    public int[] productExceptSelf(int[] nums) {
        var len = nums.length;
        var result = new int[len];
        result[0] = 1;

        // left to right
        for (int i = 1; i < len; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        var right = nums[len - 1]; // 'right to left' on a fly
        for (int i = result.length - 2; i > -1 ; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }

        return result;
    }

    // the main idea of the product of the array except 'i' means the product of the left side and right side from 'i':
    // arr=[1 2 3 4], i=2, so product except 2 [1 2 *i* 4] is product of the left side 1*2=2 and right side 4. So result is 2 * 4 = 8;
    // imagine, 1 on the left side of the first element and on the right side of the last element
    // arr=[1 2 3 4], leftToRight=[1 1 2 6], rightToLeft=[24 12 4 1], res=[1*24, 1*12, 2*4, 1*6]=[24, 12, 8, 6]
    // O(n), O(n)
    public int[] productExceptSelf1(int[] nums) {
        var len = nums.length;
        var leftToRight = new int[len];
        leftToRight[0] = 1;
        var rightToLeft = new int[len];
        rightToLeft[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            leftToRight[i] = leftToRight[i - 1] * nums[i - 1];
            rightToLeft[len - i - 1] = rightToLeft[len - i] * nums[len - i];
        }

        var res = new int[len];

        for (int i = 0; i < len; i++) {
            res[i] = leftToRight[i] * rightToLeft[i];
        }

        return res;
    }
}
