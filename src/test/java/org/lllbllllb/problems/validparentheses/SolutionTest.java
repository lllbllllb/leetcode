package org.lllbllllb.problems.validparentheses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
