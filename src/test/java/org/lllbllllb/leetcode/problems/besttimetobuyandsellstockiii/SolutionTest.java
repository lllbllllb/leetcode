package org.lllbllllb.leetcode.problems.besttimetobuyandsellstockiii;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    @Disabled
    void maxProfit1() {
        var res = solution.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4});

        assertEquals(6, res);
    }

    @Test
    @Disabled
    void maxProfit2() {
        var res = solution.maxProfit(new int[]{1, 2, 3, 4, 5});

        assertEquals(4, res);
    }

    @Test
    @Disabled
    void maxProfit3() {
        var res = solution.maxProfit(new int[]{7, 6, 4, 3, 1});

        assertEquals(0, res);
    }
}
