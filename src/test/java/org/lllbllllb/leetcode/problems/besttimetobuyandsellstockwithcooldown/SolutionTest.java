package org.lllbllllb.leetcode.problems.besttimetobuyandsellstockwithcooldown;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void shouldMaxProfitTest1() {
        var res = solution.maxProfit(new int[]{1, 2, 3, 0, 2});

        assertEquals(3, res);
    }

    @Test
    void shouldMaxProfitTest2() {
        var res = solution.maxProfit(new int[]{1});

        assertEquals(0, res);
    }

    @Test
    void shouldMaxProfitTest3() {
        var res = solution.maxProfit(new int[]{1, 2, 4});

        assertEquals(3, res);
    }

    @Test
    void shouldMaxProfitTest4() {
        var res = solution.maxProfit(new int[]{1, 2});

        assertEquals(1, res);
    }

    @Test
    void shouldMaxProfitTest5() {
        var res = solution.maxProfit(new int[]{2, 1});

        assertEquals(0, res);
    }
}
