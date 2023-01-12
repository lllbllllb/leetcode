package org.lllbllllb.problems.trappingrainwater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void trap1() {
        var res = solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});

        assertEquals(6, res);
    }

    /*
         . . . . . #
         # . . . . #
         # . . # . #
         # # . # # #
         # # . # # #
     */
    @Test
    void trap2() {
        var res = solution.trap(new int[]{4, 2, 0, 3, 2, 5});

        assertEquals(9, res);
    }

    @Test
    void trap3() {
        var res = solution.trap(new int[]{1, 2, 3, 4, 3, 2, 1});

        assertEquals(0, res);
    }

    @Test
    void trap4() {
        var res = solution.trap(new int[]{1, 2, 3, 4});

        assertEquals(0, res);
    }

    @Test
    void trap5() {
        var res = solution.trap(new int[]{4, 3, 2, 1});

        assertEquals(0, res);
    }

    @Test
    void trap6() {
        var res = solution.trap(new int[]{1, 1, 1, 1});

        assertEquals(0, res);
    }

    @Test
    void trap7() {
        var res = solution.trap(new int[]{3, 2, 1, 2, 1, 2, 3});

        assertEquals(7, res);
    }

    @Test
    void trap8() {
        var res = solution.trap(new int[]{2, 1, 3, 1, 2});

        assertEquals(2, res);
    }

    @Test
    void trap9() {
        var res = solution.trap(new int[]{2});

        assertEquals(0, res);
    }

    /*
         # . . .
         # # . .
         # # . .
         # # + #
         # # # #
     */
    @Test
    void trap10() {
        var res = solution.trap(new int[]{5, 4, 1, 2});

        assertEquals(1, res);
    }

    /*
         # . . . . . .
         # # . . . . .
         # # # . . . .
         # # # + + # .
         # # # # # # #
     */
    @Test
    void trap11() {
        var res = solution.trap(new int[]{5, 4, 3, 1, 1, 2, 1});

        assertEquals(2, res);
    }

}
