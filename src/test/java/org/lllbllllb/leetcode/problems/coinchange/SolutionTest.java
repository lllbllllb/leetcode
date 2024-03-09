package org.lllbllllb.leetcode.problems.coinchange;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void coinChange1() {
        var res = solution.coinChange(new int[]{1, 2, 5}, 11);

        assertEquals(3, res);
    }

    @Test
    void coinChange2() {
        var res = solution.coinChange(new int[]{2}, 3);

        assertEquals(-1, res);
    }

    @Test
    void coinChange3() {
        var res = solution.coinChange(new int[]{1}, 0);

        assertEquals(0, res);
    }

    @Test
    void coinChange4() {
        var res = solution.coinChange(new int[]{186, 419, 83, 408}, 6249);

        assertEquals(20, res);
    }

    @Test
    void coinChange5() {
        var res = solution.coinChange(new int[]{2, 3}, 4);

        assertEquals(2, res);
    }

    @Test
    void coinChange6() {
        var res = solution.coinChange(new int[]{1, 3, 4, 5}, 7);

        assertEquals(2, res);
    }
}
