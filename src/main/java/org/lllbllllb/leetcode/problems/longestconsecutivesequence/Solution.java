package org.lllbllllb.leetcode.problems.longestconsecutivesequence;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/longest-consecutive-sequence/">128. Longest Consecutive Sequence</a>
 */
class Solution {

    // 11 ms, 52.2 MB
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        var maxLen = 0;
        var len = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                len++;

                if (len > maxLen) {
                    maxLen = len;
                }
            } else if (nums[i] - nums[i - 1] != 0) {
                len = 1;
            }
        }

        if (len > maxLen) {
            maxLen = len;
        }

        return maxLen;
    }

    // 66 ms, 64 MB
    public int longestConsecutive1(int[] nums) {
        var minToSeqMap = new HashMap<Integer, Deque<Integer>>(); // [6]->[6| 7 8 9]
        var maxToSeqMap = new HashMap<Integer, Deque<Integer>>(); // [4]->[1 2 3 |4]

        for (var num : nums) {
            if (!maxToSeqMap.containsKey(num) && !minToSeqMap.containsKey(num)) {
                var min = minToSeqMap.remove(num + 1);
                var max = maxToSeqMap.remove(num - 1);

                if (max != null && min != null) {
                    max.add(num);
                    max.addAll(min);
                    minToSeqMap.put(max.peekFirst(), max);
                    maxToSeqMap.put(max.peekLast(), max);
                } else if (max != null) {
                    max.add(num);
                    maxToSeqMap.put(num, max);
                } else if (min != null) {
                    min.push(num);
                    minToSeqMap.put(num, min);
                } else {
                    var list = new LinkedList<Integer>();
                    list.add(num);
                    minToSeqMap.put(num, list);
                    maxToSeqMap.put(num, list);
                }
            }
        }

        var max = 0;

        for (var list : minToSeqMap.values()) {
            var size = list.size();

            if (size > max) {
                max = size;
            }
        }

        return max;
    }

    // 393 ms, 59.2 MB
    public int longestConsecutive2(int[] nums) {
        var set = new HashSet<Integer>();

        for (var num : nums) {
            set.add(num);
        }

        var max = 0;

        for (var num : nums) {

            if (!set.contains(num - 1)) {
                var len = 0;
                var current = num;

                while (set.contains(current)) {
                    len++;
                    current++;
                }

                if (len > max) {
                    max = len;
                }
            }
        }

        return max;
    }
}
