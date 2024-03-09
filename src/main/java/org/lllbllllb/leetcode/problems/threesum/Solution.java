package org.lllbllllb.leetcode.problems.threesum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/3sum/">15. 3Sum</a>
 */
class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        var len = nums.length;

        if (nums[0] > 0 || nums[len - 1] < 0) {
            return List.of();
        }

        var res = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 1 && nums[i] < 1; i++) {
            var iTh = nums[i];

            if (i < 1 || iTh != nums[i - 1]) {
                var j = i + 1;
                var k = len - 1;

                while (j < k) {
                    var jTh = nums[j];
                    var kTh = nums[k];
                    var sum = iTh + jTh + kTh;

                    if(sum > 0) {
                        k--;
                    } else if (sum < 0) {
                        j++;
                    } else {
                        res.add(List.of(iTh, jTh, kTh));

                        while (j < k && jTh == nums[j]) {
                            j++;
                        }

                        while (j < k & kTh == nums[k]) {
                            k--;
                        }
                    }
                }
            }
        }

        return res;
    }
}
