package org.lllbllllb.problems.interleavingstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void shouldIsInterleaveTest1() {
        var res = solution.isInterleave("aabcc", "dbbca", "aadbbcbcac");

        assertTrue(res);
    }

    @Test
    void shouldIsInterleaveTest2() {
        var res = solution.isInterleave("aabcc", "dbbca", "aadbbbaccc");

        assertFalse(res);
    }

    @Test
    void shouldIsInterleaveTest3() {
        var res = solution.isInterleave("", "", "");

        assertTrue(res);
    }

    @Test
    void shouldIsInterleaveTest4() {
        var res = solution.isInterleave("", "", "a");

        assertFalse(res);
    }

    @Test
    void shouldIsInterleaveTest5() {
        var res = solution.isInterleave("ab", "bc", "bbac");

        assertFalse(res);
    }
}
