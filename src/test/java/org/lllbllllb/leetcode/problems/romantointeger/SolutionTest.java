package org.lllbllllb.leetcode.problems.romantointeger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void romanToInt1() {
        var res = solution.romanToInt("III");

        assertEquals(3, res);
    }

    @Test
    void romanToInt2() {
        var res = solution.romanToInt("LVIII");

        assertEquals(58, res);
    }

    @Test
    void romanToInt3() {
        var res = solution.romanToInt("MCMXCIV");

        assertEquals(1994, res);
    }
}
