package org.lllbllllb.problems.findtheindexofthefirstoccurrenceinastring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void strStr1() {
        var res = solution.strStr("sadbutsad", "sad");

        assertEquals(0, res);
    }

    @Test
    void strStr2() {
        var res = solution.strStr("leetcode", "leeto");

        assertEquals(-1, res);
    }

    @Test
    void strStr3() {
        var res = solution.strStr("mississippi", "issipi");

        assertEquals(-1, res);
    }
}
