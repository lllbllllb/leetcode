package org.lllbllllb.problems.palindromicsubstrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void countSubstrings1() {
        var res = solution.countSubstrings("abc");

        assertEquals(3, res);
    }

    @Test
    void countSubstrings2() {
        var res = solution.countSubstrings("aaa");

        assertEquals(6, res);
    }
}
