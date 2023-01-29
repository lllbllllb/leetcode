package org.lllbllllb.problems.sumofallsubsetxortotals;

/**
 * @see <a href="https://leetcode.com/problems/sum-of-all-subset-xor-totals/">1863. Sum of All Subset XOR Totals</a>
 * @see <a href="https://leetcode.com/problems/sum-of-all-subset-xor-totals/solutions/1242073/java-backtracking-approach-with-explanation/">Backtracking approach with explanation</a>
 */
class Solution {

    // 1ms
    public int subsetXORSum(int[] nums) {
        return backtracking(nums, 0);
    }

    private int backtracking(int[] nums, int cursor) {
        if (cursor == nums.length) {
            var xor = 0;

            for (var num : nums) {
                xor ^= num;
            }

            return xor;
        } else {
            var val = nums[cursor];
            nums[cursor] = 0;
            var without = backtracking(nums, cursor + 1);
            nums[cursor] = val;
            var with = backtracking(nums, cursor + 1);

            return without + with;
        }
    }


    // 1ms
    public int subsetXORSum1(int[] nums) {
        return backtracking(nums, 0, 0);
    }

    private int backtracking(int[] nums, int cursor, int currentXor) {
        if (cursor == nums.length) {
            return currentXor;
        } else {
            var without = backtracking(nums, cursor + 1, currentXor);
            var with = backtracking(nums, cursor + 1, currentXor ^ nums[cursor]);

            return without + with;
        }
    }


}
