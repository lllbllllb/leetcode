package org.lllbllllb.leetcode.problems.coinchangeii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void shouldChangeTest1() {
        var res = solution.change(5, new int[]{1, 2, 5});

        assertEquals(4, res);
    }

    @Test
    void shouldChangeTest2() {
        var res = solution.change(3, new int[]{2});

        assertEquals(0, res);
    }

    @Test
    void shouldChangeTest3() {
        var res = solution.change(10, new int[]{10});

        assertEquals(1, res);
    }

    @Test
    void shouldChangeTest4() {
        var res = solution.change(3, new int[]{1, 2});

        assertEquals(2, res);
    }

    @Test
    void shouldChangeTest5() {
        var res = solution.change(0, new int[]{10});

        assertEquals(1, res);
    }

    @Test
    void shouldChangeTest6() {
        var res = solution.change(500, new int[]{3,5,7,8,9,10,11});

        assertEquals(35502874, res);
    }
}
