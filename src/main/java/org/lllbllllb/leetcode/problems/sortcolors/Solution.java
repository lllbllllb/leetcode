package org.lllbllllb.leetcode.problems.sortcolors;

/**
 * <a href="https://leetcode.com/problems/sort-colors/">75. Sort Colors</a>
 */
class Solution {
    public void sortColors(int[] nums) {
        var rCount = 0;
        var wCount = 0;
        var bCount = 0;

        for (var col : nums) {
            if (col == 0) {
                rCount++;
            } else if (col == 1) {
                wCount++;
            } else if (col == 2) {
                bCount++;
            }
        }

        for (int i = 0; i < rCount; i++) {
            nums[i] = 0;
        }

        for (int i = rCount; i < rCount + wCount; i++) {
            nums[i] = 1;
        }

        for (int i = rCount + wCount; i < rCount + wCount + bCount; i++) {
            nums[i] = 2;
        }
    }
}
