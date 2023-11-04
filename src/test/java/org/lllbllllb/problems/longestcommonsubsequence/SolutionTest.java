package org.lllbllllb.problems.longestcommonsubsequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void shouldLongestCommonSubsequenceTest1() {
        var res = solution.longestCommonSubsequence("abcde", "ace");

        assertEquals(3, res);
    }

    @Test
    void shouldLongestCommonSubsequenceTest2() {
        var res = solution.longestCommonSubsequence("abc", "abc");

        assertEquals(3, res);
    }

    @Test
    void shouldLongestCommonSubsequenceTest3() {
        var res = solution.longestCommonSubsequence("abc", "def");

        assertEquals(0, res);
    }

    @Test
    void shouldLongestCommonSubsequenceTest4() {
        var res = solution.longestCommonSubsequence("bl", "yby");

        assertEquals(1, res);
    }

    @Test
    void shouldLongestCommonSubsequenceTest5() {
        var res = solution.longestCommonSubsequence("abcdef", "deg");

        assertEquals(2, res);
    }

    @Test
    void shouldLongestCommonSubsequenceTest6() {
        var res = solution.longestCommonSubsequence("abc", "cba");

        assertEquals(1, res);
    }

    @Test
    void shouldLongestCommonSubsequenceTest7() {
        var res = solution.longestCommonSubsequence("abcba", "abcbcba");

        assertEquals(5, res);
    }

    @Test
    void shouldLongestCommonSubsequenceTest8() {
        var res = solution.longestCommonSubsequence("abcde", "ace");

        assertEquals(3, res);
    }

    @Test
    void shouldLongestCommonSubsequenceTest9() {
        var res = solution.longestCommonSubsequence("abcd", "dabc");

        assertEquals(3, res);
    }

    @Test
    void shouldLongestCommonSubsequenceTest10() {
        var res = solution.longestCommonSubsequence("cabc", "caa");

        assertEquals(2, res);
    }

    @Test
    void shouldLongestCommonSubsequenceTest11() {
        var res = solution.longestCommonSubsequence("abc", "cabc");

        assertEquals(3, res);
    }

    @Test
    void shouldLongestCommonSubsequenceTest12() {
        var res = solution.longestCommonSubsequence("abc", "cab");

        assertEquals(2, res);
    }
}
