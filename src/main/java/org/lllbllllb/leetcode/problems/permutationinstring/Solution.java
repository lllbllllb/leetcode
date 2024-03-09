package org.lllbllllb.leetcode.problems.permutationinstring;

/**
 * <a href="https://leetcode.com/problems/permutation-in-string/">567. Permutation in String</a>
 */
class Solution {

    // 3 ms, 41.9 MB
    public boolean checkInclusion(String s1, String s2) {
        var s1CharCounter = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1CharCounter[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s1CharCounter.length; i++) {
            if (s1CharCounter[i] == 0) {
                s1CharCounter[i] = -1;
            }
        }

        var count = s1.length();
        var left = 0;

        for (int right = 0; right < s2.length(); right++) {
            var targetCh = s2.charAt(right);

            while (left < right && s1CharCounter[targetCh - 'a'] < 1) {
                var usedCh = s2.charAt(left);

                if (s1CharCounter[usedCh - 'a'] > -1) {
                    s1CharCounter[usedCh - 'a']++;
                    count++;
                }

                left++;
            }

            if (s1CharCounter[targetCh - 'a'] > 0) {
                s1CharCounter[targetCh - 'a']--;
                count--;

                if (count == 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
