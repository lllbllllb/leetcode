package org.lllbllllb.problems.containsduplicate;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/contains-duplicate/">217. Contains Duplicate</a>
 */
class Solution {
    public boolean containsDuplicate(int[] nums) {
        var set = new HashSet<Integer>();

        for (var num : nums) {
            var isNew = set.add(num);

            if (!isNew) {
                return true;
            }
        }

        return false;
    }
}
