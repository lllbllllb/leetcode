package org.lllbllllb.leetcode.problems.targetsum;

import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/target-sum/">494. Target Sum</a>
 */
class Solution {

    // 7ms, 43.76MB
    public int findTargetSumWays(int[] nums, int target) {
        var rangeFrom = 0;
        var rangeTo = 0;

        for (var num : nums) {
            if (num > 0) {
                rangeFrom -= num;
                rangeTo += num;
            } else {
                rangeFrom += num;
                rangeTo -= num;
            }
        }

        return dfs(nums, 0, 0, target, new Integer[nums.length][rangeTo - rangeFrom + 1], -rangeFrom);
    }

    private int dfs(int[] nums, int cursor, int sum, int target, Integer[][] mem, int shift) {
        if (cursor == nums.length) {
            if (sum == target) {
                return 1;
            }

            return 0;
        }

        var idx = sum + shift;

        if (mem[cursor][idx] != null) {
            return mem[cursor][idx];
        }

        var nextCursor = cursor + 1;
        mem[cursor][idx] = dfs(nums, nextCursor, sum - nums[cursor], target, mem, shift) + dfs(nums, nextCursor, sum + nums[cursor], target, mem, shift);

        return mem[cursor][idx];
    }

    // 317ms, 44.33MB
    public int findTargetSumWays1(int[] nums, int target) {
        return dfs1(nums, 0, 0, target, new HashMap<>());
    }

    private int dfs1(int[] nums, int cursor, int sum, int target, HashMap<String, Integer> mem) {
        if (cursor == nums.length) {
            if (sum == target) {
                return 1;
            }

            return 0;
        }

        var memKey = "%s-%s".formatted(cursor, sum);

        if (mem.containsKey(memKey)) {
            return mem.get(memKey);
        }

        var nextCursor = cursor + 1;
        var res = dfs1(nums, nextCursor, sum - nums[cursor], target, mem) + dfs1(nums, nextCursor, sum + nums[cursor], target, mem);
        mem.put(memKey, res);

        return mem.get(memKey);
    }

    // 521ms, 39.30MB
    public int findTargetSumWays2(int[] nums, int target) {
        return dfs2(nums, 0, target);
    }

    private int dfs2(int[] nums, int cursor, int target) {
        if (cursor == nums.length) {
            if (target == 0) {
                return 1;
            }

            return 0;
        }

        var nextCursor = cursor + 1;

        return dfs2(nums, nextCursor, target - nums[cursor]) + dfs2(nums, nextCursor, target + nums[cursor]);
    }
}
