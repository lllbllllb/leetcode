package org.lllbllllb.problems.mincosttoconnectallpoints;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void minCostConnectPoints1() {
        var res = solution.minCostConnectPoints(new int[][]{{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}});

        assertEquals(20, res);
    }

    @Test
    void minCostConnectPoints2() {
        var res = solution.minCostConnectPoints(new int[][]{{3, 12}, {-2, 5}, {-4, 1}});

        assertEquals(18, res);
    }

    @Test
    void minCostConnectPoints3() {
        var res = solution.minCostConnectPoints(new int[][]{{0, 0}, {1, 1}, {1, 0}, {-1, 1}});

        assertEquals(4, res);
    }
}
