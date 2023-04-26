package org.lllbllllb.problems.palindromepartitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/palindrome-partitioning/">131. Palindrome Partitioning</a>
 */
class Solution {

    // 12 ms, 54.9 MB
    public List<List<String>> partition(String s) {
        var res = new ArrayList<List<String>>();

        backtracking(s, 0, new ArrayList<>(), res, new boolean[s.length()][s.length()]);

        return res;
    }

    private void backtracking(String s, int left, List<String> partitions, List<List<String>> res, boolean[][] palindromeDp) {
        if (left == s.length()) {
            res.add(List.copyOf(partitions));
        }

        for (int right = left; right < s.length(); right++) {
            if (s.charAt(left) == s.charAt(right) && (right - left < 2 || palindromeDp[left + 1][right - 1])) {
                palindromeDp[left][right] = true;
                var partition = s.substring(left, right + 1);
                partitions.add(partition);
                backtracking(s, right + 1, partitions, res, palindromeDp);
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    // 12 ms, 55.2 MB
    public List<List<String>> partition2(String s) {
        var res = new ArrayList<List<String>>();

        backtracking2(s, 0, new ArrayList<>(), res);

        return res;
    }

    private void backtracking2(String s, int cursor, List<String> partitions, List<List<String>> res) {
        if (cursor == s.length()) {
            res.add(List.copyOf(partitions));
            return;
        }

        for (int i = cursor; i < s.length(); i++) {
            if (isPalindrome2(s, cursor, i)) {
                var partition = s.substring(cursor, i + 1);
                partitions.add(partition);
                backtracking2(s, i + 1, partitions, res);
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    private boolean isPalindrome2(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }


    // 12 ms, 55.3 MB
    public List<List<String>> partition1(String s) {
        var res = new ArrayList<List<String>>();

        backtracking(s, 0, 1, new ArrayList<>(), res);

        return res;
    }

    private void backtracking(String s, int left, int right, List<String> partitions, List<List<String>> res) {
        if (right == s.length()) {
            res.add(List.copyOf(partitions));

            return;
        }

        if (right > s.length()) {
            return;
        }

        if (isPalindrome1(s, left, right - 1)) {
            var part = s.substring(left, right);
            partitions.add(part);
            backtracking(s, right, right + 1, partitions, res);
            partitions.remove(partitions.size() - 1);
        }

        backtracking(s, left, right + 1, partitions, res);
    }

    private boolean isPalindrome1(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
