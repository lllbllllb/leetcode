package org.lllbllllb.leetcode.problems.validanagram;

/**
 * <a href="https://leetcode.com/problems/valid-anagram/description/">242. Valid Anagram</a>
 */
class Solution {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (var count : counter) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
