package org.lllbllllb.problems.minimumwindowsubstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void minWindow1() {
        var res = solution.minWindow("ADOBECODEBANC", "ABC");

        assertEquals("BANC", res);
    }

    @Test
    void minWindow2() {
        var res = solution.minWindow("a", "a");

        assertEquals("a", res);
    }

    @Test
    void minWindow3() {
        var res = solution.minWindow("a", "aa");

        assertEquals("", res);
    }

    @Test
    void minWindow4() {
        var res = solution.minWindow("LAADOBECODEBANC", "ABC");

        assertEquals("BANC", res);
    }

    @Test
    void minWindow5() {
        var res = solution.minWindow("ab", "a");

        assertEquals("a", res);
    }

    @Test
    void minWindow6() {
        var res = solution.minWindow("aa", "aa");

        assertEquals("aa", res);
    }

    @Test
    void minWindow7() {
        var res = solution.minWindow("AA", "AA");

        assertEquals("AA", res);
    }

    @Test
    void minWindow8() {
        var res = solution.minWindow("BABA", "AA");

        assertEquals("ABA", res);
    }

    @Test
    void minWindow9() {
        var res = solution.minWindow("cabeca", "cae");

        assertEquals("eca", res);
    }

    @Test
    void minWindow10() {
        var res = solution.minWindow("CABECA", "CAE");

        assertEquals("ECA", res);
    }

    @Test
    void minWindow11() {
        var res = solution.minWindow("cgklivwehljxrdzpfdqsapogwvjtvbzahjnsejwnuhmomlfsrvmrnczjzjevkdvroiluthhpqtffhlzyglrvorgnalk", "mqfff");

        assertEquals("fsrvmrnczjzjevkdvroiluthhpqtff", res);
    }
}
