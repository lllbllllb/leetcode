package org.lllbllllb.problems.longestincreasingsubsequence;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/longest-increasing-subsequence/">300. Longest Increasing Subsequence</a>
 */
class Solution {

    // 1 ms, 43 MB (NlogN)
    public int lengthOfLIS(int[] nums) {
        var tails = new int[nums.length];
        tails[0] = nums[0];
        var maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            var num = nums[i];
            var tailCursor = maxLength - 1;
            var tail = tails[tailCursor];

            if (num > tail) {
                tails[maxLength] = num;
                maxLength++;
            } else {
                var tmpTailCursor = tailCursor;

                while (tmpTailCursor != -1 && tails[tmpTailCursor] >= num) {
                    tmpTailCursor--;
                }

                if (tails[tmpTailCursor + 1] > num) {
                    tails[tmpTailCursor + 1] = num;
                }
            }
        }

        return maxLength;
    }

    // https://leetcode.com/problems/longest-increasing-subsequence/solutions/74824/java-python-binary-search-o-nlogn-time-with-explanation/
    // 3 ms, 42.1 MB (NlogN)
    public int lengthOfLIS3(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;

        for (int x : nums) {
            int i = 0, j = size;

            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }

            tails[i] = x;

            if (i == size) {
                ++size;
            }
        }

        return size;
    }

    // 68 ms, 42.2 MB (N^2)
    public int lengthOfLIS1(int[] nums) {
        var dp = new int[nums.length];
        dp[0] = 1;
        var res = 1;

        for (int i = 1; i < nums.length; i++) {
            var num = nums[i];
            var max = 0;

            for (int j = i - 1; j > -1; j--) {
                var prev = nums[j];
                var prevCount = dp[j];

                if (prev < num) {
                    max = Math.max(max, prevCount);
                }
            }

            dp[i] = max + 1;
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    // Time Limit Exceeded (2^N)
    public int lengthOfLIS2(int[] nums) {
        var res = new ArrayList<List<Integer>>();

        dfs1(nums, 0, new ArrayList<>(), res);

        var max = res.get(0).size();

        for (int i = 1; i < res.size(); i++) {
            max = Math.max(max, res.get(i).size());
        }

        return max;
    }

    private void dfs1(int[] nums, int cursor, List<Integer> sub, List<List<Integer>> subs) {
        if (cursor == nums.length) {
            if (sub.isEmpty()) {
                return;
            }

            var is = new ArrayList<Integer>();
            is.add(sub.get(0));
            var max = sub.get(0);

            for (int i = 1; i < sub.size(); i++) {
                var num = sub.get(i);

                if (num > max) {
                    is.add(num);
                    max = num;
                }
            }

            subs.add(is);

            return;
        }

        var num = nums[cursor];

        sub.add(num);
        dfs1(nums, cursor + 1, sub, subs);
        sub.remove(sub.size() - 1);
        dfs1(nums, cursor + 1, sub, subs);
    }


}
