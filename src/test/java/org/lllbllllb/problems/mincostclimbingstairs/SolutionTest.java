package org.lllbllllb.problems.mincostclimbingstairs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void minCostClimbingStairs1() {
        var res = solution.minCostClimbingStairs(new int[]{10, 15, 20});

        assertEquals(15, res);
    }

    @Test
    void minCostClimbingStairs2() {
        var res = solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});

        assertEquals(6, res);
    }
}
