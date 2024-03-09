package org.lllbllllb.leetcode.problems.regularexpressionmatching;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Disabled
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void isMatch1() {
        var res = solution.isMatch("aa", "a");

        assertFalse(res);
    }

    @Test
    void isMatch2() {
        var res = solution.isMatch("aa", "a*");

        assertTrue(res);
    }

    @Test
    void isMatch3() {
        var res = solution.isMatch("ab", ".*");

        assertTrue(res);
    }

    @Test
    void isMatch4() {
        var res = solution.isMatch("abcd", "abc.*");

        assertTrue(res);
    }

    @Test
    void isMatch5() {
        var res = solution.isMatch("abcd", "abcde*");

        assertTrue(res);
    }

    @Test
    void isMatch6() {
        var res = solution.isMatch("abcd", "abf*cde*");

        assertTrue(res);
    }

    @Test
    void isMatch7() {
        var res = solution.isMatch("abcd", "g*.*f*.*.*.*de*");

        assertTrue(res);
    }

    @Test
    void isMatch8() {
        var res = solution.isMatch("aab", "c*a*b");

        assertTrue(res);
    }

    @Test
    void isMatch9() {
        var res = solution.isMatch("mississippi", "mis*is*p*.");

        assertFalse(res);
    }

    @Test
    void isMatch10() {
        var res = solution.isMatch("aab", "c*a*b");

        assertTrue(res);
    }

    @Test
    void isMatch11() {
        var res = solution.isMatch("aaa", "aaaa");

        assertFalse(res);
    }
}
