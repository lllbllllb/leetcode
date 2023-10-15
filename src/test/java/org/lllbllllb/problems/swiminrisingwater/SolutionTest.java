package org.lllbllllb.problems.swiminrisingwater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    /*
     * 0 2
     * 1 3
     */
    @Test
    void shouldSwimInWaterTest1() {
        var res = solution.swimInWater(new int[][]{{0, 2}, {1, 3}});

        assertEquals(3, res);
    }

    /**
     * 0  1  2  3  4
     * 24 23 22 21 5
     * 12 13 14 15 16
     * 11 17 18 19 20
     * 10 9  8  7  6
     */
    @Test
    void shouldSwimInWaterTest2() {
        var res = solution.swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5}, {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}});

        assertEquals(16, res);
    }

    /**
     * 0  1  2  3  4
     * 24 23 1  21 5
     * 12 13 1  15 4
     * 11 17 18 19 3
     * 10 9  8  7  2
     */
    @Test
    void shouldSwimInWaterTest3() {
        var res = solution.swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 1, 21, 5}, {12, 13, 1, 15, 4}, {11, 17, 18, 19, 3}, {10, 9, 8, 7, 2}});

        assertEquals(5, res);
    }
}
