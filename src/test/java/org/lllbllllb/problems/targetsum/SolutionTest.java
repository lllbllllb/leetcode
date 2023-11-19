package org.lllbllllb.problems.targetsum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void shouldFindTargetSumWaysTest1() {
        var res = solution.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);

        assertEquals(5, res);
    }

    @Test
    void shouldFindTargetSumWaysTest2() {
        var res = solution.findTargetSumWays(new int[]{1}, 1);

        assertEquals(1, res);
    }

    @Test
    void shouldFindTargetSumWaysTest3() {
        var res = solution.findTargetSumWays(new int[]{1, 0}, 1);

        assertEquals(2, res);
    }
}
