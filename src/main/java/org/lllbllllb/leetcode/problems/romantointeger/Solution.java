package org.lllbllllb.leetcode.problems.romantointeger;

import java.util.Map;
import java.util.Objects;

/**
 * <a href="https://leetcode.com/problems/roman-to-integer">13. Roman to Integer</a>
 */
class Solution {

    private static final Map<Character, Integer> ROMAN_BASE = Map.of(
        'I', 1,
        'V', 5,
        'X', 10,
        'L', 50,
        'C', 100,
        'D', 500,
        'M', 1000
    );

    private static final Map<Character, Character> ROMAN_REDUCER = Map.of(
        'V', 'I',
        'X', 'I',
        'L', 'X',
        'C', 'X',
        'D', 'C',
        'M', 'C'
    );


    public int romanToInt(String s) {
        var prev = s.charAt(0);
        var res = ROMAN_BASE.get(prev);

        for (int i = 1; i < s.length(); i++) {
            var curr = s.charAt(i);
            res += ROMAN_BASE.get(curr);
            var reducer = ROMAN_REDUCER.get(curr);

            if (Objects.equals(prev, reducer)) {
                res -= 2 * ROMAN_BASE.get(reducer);
            }

            prev = curr;
        }

        return res;
    }
}
