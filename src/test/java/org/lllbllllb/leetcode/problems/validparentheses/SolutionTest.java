package org.lllbllllb.leetcode.problems.validparentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void isValid1() {
        var res = solution.isValid("()");

        assertTrue(res);
    }

    @Test
    void isValid2() {
        var res = solution.isValid("()[]{}");

        assertTrue(res);
    }

    @Test
    void isValid3() {
        var res = solution.isValid("(]");

        assertFalse(res);
    }

    @Test
    void isValid4() {
        var res = solution.isValid("([)]");

        assertFalse(res);
    }
}
