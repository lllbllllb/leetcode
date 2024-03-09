package org.lllbllllb.leetcode.problems.besttimetobuyandsellstock;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxProfit1() {
        var res = solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4});

        assertEquals(5, res);
    }

    @Test
    void maxProfit2() {
        var res = solution.maxProfit(new int[]{7, 6, 4, 3, 1});

        assertEquals(0, res);
    }
}
