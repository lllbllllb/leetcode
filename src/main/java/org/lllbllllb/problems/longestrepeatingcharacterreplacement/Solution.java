package org.lllbllllb.problems.longestrepeatingcharacterreplacement;

/**
 * <a href="https://leetcode.com/problems/longest-repeating-character-replacement/">424. Longest Repeating Character Replacement</a>
 */
class Solution {

    // 5 ms, 42.4 MB
    public int characterReplacement(String s, int k) {
        var charCounter = new int[26];
        var maxLength = 0;
        var left = 0;
        var mostFrequent = 0;

        for (int i = 0; i < s.length(); i++) {
            mostFrequent = Math.max(mostFrequent, ++charCounter[s.charAt(i) - 'A']);

            if (i - left + 1 - mostFrequent > k) {
                charCounter[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(i - left + 1, maxLength);
        }

        return maxLength;
    }

    // 10 ms, 42.4 MB
    public int characterReplacement1(String s, int k) {
        var charCounter = new int[26];
        var maxLength = 0;
        var left = 0;

        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);
            var charCounterIdx = convertCharToIdx(ch);
            charCounter[charCounterIdx]++;

            var mostPopularCharacterCount = getMostFrequentChar(charCounter);
            var length = i + 1 - left;

            if (length <= mostPopularCharacterCount + k) {
                maxLength = Math.max(length, maxLength);
            } else {
                var toRemove = s.charAt(left);
                charCounter[convertCharToIdx(toRemove)]--;
                left++;
            }
        }

        return maxLength;
    }

    private int getMostFrequentChar(int[] charCounter) {
        var max = 0;

        for (var count : charCounter) {
            max = Math.max(max, count);
        }

        return max;
    }

    private int convertCharToIdx(char ch) {
        return ch - 'A';
    }
}
