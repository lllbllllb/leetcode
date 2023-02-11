package org.lllbllllb.problems.minimumwindowsubstring;

/**
 * <a href="https://leetcode.com/problems/minimum-window-substring/">76. Minimum Window Substring</a>
 */
class Solution {

    // 3 ms, 42.3 MB
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        var charCounter = new int[128];
        var counter = t.length();

        for (int i = 0; i < t.length(); i++) {
            charCounter[t.charAt(i)]++;
        }

        var minWindow = "";
        var left = 0;

        for (int right = 0; right < s.length(); right++) {
            var charRightIdx = s.charAt(right);

            if (charCounter[charRightIdx] > 0) {
                counter--;
            }

            charCounter[charRightIdx]--;

            while (counter == 0) {
                var charLeftIdx = s.charAt(left);

                charCounter[charLeftIdx]++;

                if (charCounter[charLeftIdx] > 0) {
                    counter++;

                    if (minWindow.length() == 0 || minWindow.length() > right + 1 - left) {
                        minWindow = s.substring(left, right + 1); // fixme: can be speed-up with saving just indices and will substring at once in the end
                    }
                }

                left++;
            }
        }

        return minWindow;
    }
}







