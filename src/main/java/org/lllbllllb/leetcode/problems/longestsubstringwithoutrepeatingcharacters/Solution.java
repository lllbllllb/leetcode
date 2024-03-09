package org.lllbllllb.leetcode.problems.longestsubstringwithoutrepeatingcharacters;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">3. Longest Substring Without Repeating Characters</a>
 */
class Solution {

    public int lengthOfLongestSubstring(String s) {
        var res = 0;
        var prev = new HashSet<Character>();
        var l = 0;
        var r = 0;

        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);

            while (prev.contains(c)) {
                prev.remove(s.charAt(l));
                l++;
            }

            var len = r - l + 1;

            if (len > res) {
                res = len;
            }

            prev.add(c);
            r++;
        }

        return res;
    }
}
