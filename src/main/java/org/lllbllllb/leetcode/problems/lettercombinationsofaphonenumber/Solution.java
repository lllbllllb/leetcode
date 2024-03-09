package org.lllbllllb.leetcode.problems.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number/">17. Letter Combinations of a Phone Number</a>
 */
class Solution {

    private static final Map<Character, List<String>> NUM_TO_LETTERS_MAP = Map.of(
        '2', List.of("a", "b", "c"),
        '3', List.of("d", "e", "f"),
        '4', List.of("g", "h", "i"),
        '5', List.of("j", "k", "l"),
        '6', List.of("m", "n", "o"),
        '7', List.of("p", "q", "r", "s"),
        '8', List.of("t", "u", "v"),
        '9', List.of("w", "x", "y", "z")
    );

    public List<String> letterCombinations(String digits) {
        var res = new ArrayList<String>();

        backTracking(digits, 0, res, "");

        return res;
    }

    private void backTracking(String digits, int cursorDigits, List<String> results, String tmp) {
        if (cursorDigits == digits.length()) {
            if (!tmp.isEmpty()) {
                results.add(tmp);
            }
        } else {
            var letters = NUM_TO_LETTERS_MAP.get(digits.charAt(cursorDigits));

            for (String letter : letters) {
                backTracking(digits, cursorDigits + 1, results, tmp + letter);
            }
        }
    }


    public List<String> letterCombinations1(String digits) {
        var res = new ArrayList<String>();

        backTracking1(digits, 0, res, new StringBuilder());

        return res;
    }

    private void backTracking1(String digits, int cursorDigits, List<String> results, StringBuilder tmp) {
        if (cursorDigits == digits.length()) {
            if (!tmp.isEmpty()) {
                results.add(tmp.toString());
            }
        } else {
            var letters = NUM_TO_LETTERS_MAP.get(digits.charAt(cursorDigits));

            for (String letter : letters) {
                tmp.append(letter);

                backTracking1(digits, cursorDigits + 1, results, tmp);

                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }
}
