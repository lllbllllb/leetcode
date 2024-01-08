package org.lllbllllb.problems.burstballoons;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/burst-balloons/">312. Burst Balloons</a>
 */
// O(n^3)
// 109ms, 41.84MB
class Solution {

    public int maxCoins(int[] nums) {
        var mem = new int[nums.length][nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                mem[i][j] = -1;
            }
        }

        return dfs(nums, 0, nums.length - 1, mem);
    }

    private int dfs(int[] nums, int leftCursor, int rightCursor, int[][] mem) {
        var maxCoins = 0;

        if (leftCursor > rightCursor) {
            return maxCoins;
        }

        if (mem[leftCursor][rightCursor] != -1) {
            return mem[leftCursor][rightCursor];
        }

        for (int i = leftCursor; i <= rightCursor; i++) {
            var coins = nums[i];

            if (leftCursor != 0) {
                coins *= nums[leftCursor - 1];
            }

            if (rightCursor != nums.length - 1) {
                coins *= nums[rightCursor + 1];
            }

            maxCoins = Math.max(maxCoins, coins + dfs(nums, leftCursor, i - 1, mem) + dfs(nums, i + 1, rightCursor, mem));
        }

        return mem[leftCursor][rightCursor] = maxCoins;
    }


}

// O(2^n)
// Time Limit Exceeded
class Solution1 {

    public int maxCoins(int[] nums) {
        return dfs(nums, new HashMap<>());
    }

    private int dfs(int[] nums, Map<Integer, Integer> mem) {
        var key = Arrays.hashCode(nums);

        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        var maxCoins = 0;
        var cursor = 0;
        var prevCursor = -1;
        var nextCursor = nums.length;

        while (cursor < nums.length) {
            var num = nums[cursor];

            if (num != -1) {
                nums[cursor] = -1;

                // get next cursor
                for (int i = cursor + 1; i < nums.length && nextCursor == nums.length; i++) {
                    if (nums[i] != -1) {
                        nextCursor = i;
                    }
                }

                var nestedCoins = dfs(nums, mem);
                var prevCoins = prevCursor != -1 ? nums[prevCursor] : 1;
                var nextCoins = nextCursor != nums.length ? nums[nextCursor] : 1;

                maxCoins = Math.max(maxCoins, num * nextCoins * prevCoins + nestedCoins);

                nums[cursor] = num;

                prevCursor = cursor;
                cursor = nextCursor;
                nextCursor = nums.length;
            } else {
                cursor++;
            }
        }

        mem.put(key, maxCoins);

        return maxCoins;
    }
}