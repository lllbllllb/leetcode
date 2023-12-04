package org.lllbllllb.problems.burstballoons;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void shouldMaxCoinsTest1() {
        var res = solution.maxCoins(new int[]{3, 1, 5, 8});

        assertEquals(167, res);
    }

    @Test
    void shouldMaxCoinsTest2() {
        var res = solution.maxCoins(new int[]{1, 5});

        assertEquals(10, res);
    }

    @Test
    void shouldMaxCoinsTest3() {
        var res = solution.maxCoins(new int[]{7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3});

        assertEquals(1654, res);
    }

    @Test
    void shouldMaxCoinsTest4() {
        var res = solution.maxCoins(new int[]{1, 2, 3});

        assertEquals(12, res);
    }

    @Test
    void shouldMaxCoinsTest5() {
        var res = solution.maxCoins(new int[]{2, 4, 8, 4, 0, 7, 8, 9, 1, 2, 4, 7, 1, 7, 3, 6});

        assertEquals(3304, res);
    }

    @Test
    void shouldMaxCoinsTest6() {
        var res = solution.maxCoins(new int[]{8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2});

        assertEquals(3446, res);
    }

    @Test
    void shouldMaxCoinsTest7() {
        var res = solution.maxCoins(new int[]{8, 2, 6, 8, 9, 8, 1, 4, 1, 5, 3, 0, 7, 7, 0, 4, 2, 2, 5, 5});

        assertEquals(3830, res);
    }

    @Test
    void shouldMaxCoinsTest8() {
        var res = solution.maxCoins(new int[]{8, 3, 4, 3, 5, 0, 5, 6, 6, 2, 8, 5, 6, 2, 3, 8, 3, 5, 1, 0, 2});

        assertEquals(3394, res);
    }
}
