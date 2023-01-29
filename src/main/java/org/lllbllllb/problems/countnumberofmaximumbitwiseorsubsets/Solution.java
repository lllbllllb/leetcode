package org.lllbllllb.problems.countnumberofmaximumbitwiseorsubsets;

/**
 * @see <a href="https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/">2044. Count Number of Maximum Bitwise-OR Subsets</a>
 */
class Solution {

    // 9 ms
    public int countMaxOrSubsets(int[] nums) {
        var or = 0;

        for (int x : nums) {
            or |= x;
        }

        return backtracking(nums, 0, 0, or);
    }

    public int backtracking(int[] nums, int cursor, int currOr, int targetOr) {
        if (cursor == nums.length) {
            if (currOr == targetOr) {
                return 1;
            }

            return 0;
        } else {
            var with = backtracking(nums, cursor + 1, currOr | nums[cursor], targetOr);
            var without = backtracking(nums, cursor + 1, currOr, targetOr);

            return with + without;
        }
    }

    // 3 ms
    public int countMaxOrSubsets0(int[] nums) {
        var dp = new int[1 << (nums.length)];
        var benchmark = 0;

        for (int x : nums) {
            benchmark |= x;
        }

        var res = 0;

        for (int i = 0; i < nums.length; i++) {
            dp[(1 << i)] = nums[i];
        }

        for (int i = 1; i < dp.length; i++) {
            var lastBitOffed = (i & (i - 1));
            var lastBitVal = i - lastBitOffed;

            dp[i] = dp[lastBitOffed] | dp[lastBitVal];

            if (dp[i] == benchmark)
                res++;
        }

        return res;
    }

    // 17 ms
    private int or, count;

    public int countMaxOrSubsets1(int[] nums) {
        backtracking(nums, 0, 0);

        return count;
    }

    public void backtracking(int[] nums, int cursor, int currOr) {
        if (cursor == nums.length) {
            if (currOr == or) {
                count++;
            } else if (currOr > or) {
                or = currOr;
                count = 1;
            }
        } else {
            backtracking(nums, cursor + 1, currOr | nums[cursor]);
            backtracking(nums, cursor + 1, currOr);
        }
    }

    // 26-30 ms
    public int countMaxOrSubsets2(int[] nums) {
        var holder = new int[2];

        backtracking(nums, 0, holder);

        return holder[1];
    }

    public void backtracking(int[] nums, int cursor, int[] holder) {
        if (cursor == nums.length) {
            var currXor = 0;

            for (var num : nums) {
                currXor |= num;
            }

            var xor = holder[0];

            if (currXor == xor) {
                holder[1]++;
            } else if (currXor > xor) {
                holder[0] = currXor;
                holder[1] = 1;
            }
        } else {
            var val = nums[cursor];

            nums[cursor] = 0;
            backtracking(nums, cursor + 1, holder);
            nums[cursor] = val;

            backtracking(nums, cursor + 1, holder);
        }
    }
}
