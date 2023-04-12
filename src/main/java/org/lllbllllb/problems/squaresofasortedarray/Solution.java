package org.lllbllllb.problems.squaresofasortedarray;

/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array">977. Squares of a Sorted Array</a>
 */
class Solution {

    public int[] sortedSquares(int[] nums) {
        var res = new int[nums.length];
        var left = 0;
        var right = nums.length - 1;
        var resCursor = nums.length - 1;

        while (left <= right) {
            var leftVal = Math.abs(nums[left]);
            var rightVal = Math.abs(nums[right]);

            if (leftVal > rightVal) {
                res[resCursor] = leftVal * leftVal;
                left++;
            } else {
                res[resCursor] = rightVal * rightVal;
                right--;
            }

            resCursor--;
        }

        return res;
    }
}
