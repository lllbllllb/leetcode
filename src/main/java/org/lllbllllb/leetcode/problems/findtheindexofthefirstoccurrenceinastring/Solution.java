package org.lllbllllb.leetcode.problems.findtheindexofthefirstoccurrenceinastring;

/**
 * <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/">28. Find the Index of the First Occurrence in a String</a>
 */
class Solution {

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        for (int i = 0; i < haystack.length(); i++) {
            var cursor = 0;

            while ((i + cursor) < haystack.length() && haystack.charAt(i + cursor) == needle.charAt(cursor)) {
                cursor++;

                if (cursor == needle.length()) {
                    return i;
                }
            }
        }

        return -1;
    }
}
