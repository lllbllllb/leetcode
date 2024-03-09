package org.lllbllllb.leetcode.problems.happynumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void isHappy1() {
        var res = solution.isHappy(19);

        assertTrue(res);
    }

    @Test
    void isHappy2() {
        var res = solution.isHappy(2);

        assertFalse(res);
    }
}