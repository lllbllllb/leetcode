package org.lllbllllb.problems.firstmissingpositive;

/**
 * <a href="https://leetcode.com/problems/first-missing-positive/description/">41. First Missing Positive</a>
 */
class Solution {

    // 1 ms, 50.7 MB
    public int firstMissingPositive(int[] nums) {
        var len = nums.length;
        var mark = len + 1;

        if (len == 1 && nums[0] != 1) {
            return 1;
        }

        for (var num : nums) {
            var next = num;

            while (next > 0 && next < mark) {
                var idx = next - 1;
                var tmp = nums[idx];
                nums[idx] = Integer.MAX_VALUE;
                next = tmp;
            }
        }

        for (int i = 0; i < len; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                return i + 1;
            }
        }

        return mark;
    }

    // 1 ms, 50.7 MB
    public int firstMissingPositive2(int[] nums) {
        var mark = new boolean[nums.length + 1]; // cheat - not constant memory

        for (var num : nums) {
            if (num > 0 && num < mark.length) {
                mark[num] = true;
            }
        }

        for (int i = 1; i < mark.length; i++) {
            if (!mark[i]) {
                return i;
            }
        }

        return mark.length;
    }

    // 2 ms, 58.2 MB
    public int firstMissingPositive1(int[] nums) {
        var len = nums.length;

        for (int i = 0; i < len; i++) {
            var val = nums[i];

            if (val < 1 || val > len) {
                nums[i] = -1;
            }
        }

        for (int i = 0; i < len; i++) {
            var val = nums[i];

            while (val > 0) {
                var tmp = nums[val - 1];
                nums[val - 1] = 0;
                val = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                return i + 1;
            }
        }

        return len + 1;
    }
}
