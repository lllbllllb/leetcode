package org.lllbllllb.leetcode.problems.validpalindrome;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome/">125. Valid Palindrome</a>
 */
class Solution {

    public boolean isPalindrome(String s) {
        var left = 0;
        var right = s.length() - 1;

        while (left < right) {
            var leftChar = Character.toLowerCase(s.charAt(left));
            var rightChar = Character.toLowerCase(s.charAt(right));

            if (Character.isLetterOrDigit(leftChar) && Character.isLetterOrDigit(rightChar)) {
                if (leftChar != rightChar) {
                    return false;
                }
                left++;
                right--;
            } else if (Character.isLetterOrDigit(leftChar)) {
                right--;
            } else {
                left++;
            }
        }

        return true;
    }
}
