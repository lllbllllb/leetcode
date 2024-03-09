package org.lllbllllb.leetcode.problems.countnumberofmaximumbitwiseorsubsets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    Solution solution = new Solution();

    @Test
    void countMaxOrSubsets1() {
        var res = solution.countMaxOrSubsets(new int[]{3, 1});

        assertEquals(2, res);
    }

    @Test
    void countMaxOrSubsets2() {
        var res = solution.countMaxOrSubsets(new int[]{2, 2, 2});

        assertEquals(7, res);
    }

    @Test
    void countMaxOrSubsets7() {
        var res = solution.countMaxOrSubsets(new int[]{3, 2, 1, 5});

        assertEquals(6, res);
    }
}
