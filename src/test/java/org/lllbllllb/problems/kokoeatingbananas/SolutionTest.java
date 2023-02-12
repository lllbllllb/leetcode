package org.lllbllllb.problems.kokoeatingbananas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void minEatingSpeed1() {
        var res = solution.minEatingSpeed(new int[]{3, 6, 7, 11}, 8); // 27

        assertEquals(4, res);
    }

    @Test
    void minEatingSpeed2() {
        var res = solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5); // 4 11 20 23 30 -> 88

        assertEquals(30, res);
    }

    @Test
    void minEatingSpeed3() {
        var res = solution.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6); // 4 11 20 23 30 -> 88

        assertEquals(23, res);
    }

    @Test
    void minEatingSpeed4() {
        var res = solution.minEatingSpeed(new int[]{312884470}, 312884469);

        assertEquals(2, res);
    }

    @Test
    void minEatingSpeed5() {
        var res = solution.minEatingSpeed(new int[]{332484035, 524908576, 855865114, 632922376, 222257295, 690155293, 112677673, 679580077, 337406589, 290818316, 877337160, 901728858, 679284947, 688210097, 692137887, 718203285, 629455728, 941802184}, 823855818);

        assertEquals(14, res);
    }
}
