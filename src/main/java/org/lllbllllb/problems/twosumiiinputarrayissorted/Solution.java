package org.lllbllllb.problems.twosumiiinputarrayissorted;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">167. Two Sum II - Input Array Is Sorted</a>
 */
class Solution {

    // 1 ms, 45.3 MB
    public int[] twoSum(int[] numbers, int target) {
        var left = 0;
        var right = numbers.length - 1;

        while (left < right) {
            var s1 = numbers[left];
            var s2 = numbers[right];

            if (s1 + s2 > target) {
                right--;
            } else if (s1 + s2 < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }

        return new int[0];
    }

    // 6 ms, 45.2 MB
    public int[] twoSum2(int[] numbers, int target) {
        var right = numbers.length - 1;

        for (int i = 0; i < numbers.length; i++) {
            var j = binarySearch(numbers, i + 1, right, target - numbers[i]);

            if (numbers[j] + numbers[i] == target) {
                return new int[]{i + 1, j + 1};
            } else {
                right = j;
            }
        }

        return new int[0];
    }

    private int binarySearch(int[] numbers, int fromIndex, int toIndex, int target) {
        if (fromIndex + 1 == toIndex || fromIndex == toIndex) {
            if (numbers[fromIndex] == target) {
                return fromIndex;
            } else {
                return toIndex;
            }
        }

        var pos = (fromIndex + toIndex) / 2;

        if (numbers[pos] > target) {
            return binarySearch(numbers, fromIndex, pos, target);
        } else if (numbers[pos] < target) {
            return binarySearch(numbers, pos, toIndex, target);
        }

        return pos;
    }

    // 2 ms, 45.2 MB
    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            var j = Arrays.binarySearch(numbers, i + 1, numbers.length, target - numbers[i]);

            if (j > -1) {
                return new int[]{i + 1, j + 1};
            }
        }

        return new int[0];
    }
}
