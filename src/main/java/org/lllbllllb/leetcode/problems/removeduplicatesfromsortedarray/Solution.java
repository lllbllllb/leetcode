package org.lllbllllb.leetcode.problems.removeduplicatesfromsortedarray;

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/">26. Remove Duplicates from Sorted Array</a>
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        var k = 1;
        var curr = nums[0];

        for (int i = 1; i < nums.length; i++) {
            var val = nums[i];

            if (val != curr) {
                nums[k] = val;
                k++;
                curr = val;
            }
        }

        return k;
    }
}
