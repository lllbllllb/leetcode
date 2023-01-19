package org.lllbllllb.problems.dividetwointegers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void divide1() {
        var res = solution.divide(10, 3);

        assertEquals(3, res);
    }

    @Test
    void divide2() {
        var res = solution.divide(7, -3);

        assertEquals(-2, res);
    }

    @Test
    void divide3() {
        var res = solution.divide(1, 1);

        assertEquals(1, res);
    }

    @Test
    void divide4() {
        var res = solution.divide(-1, 1);

        assertEquals(-1, res);
    }

    @Test
    void divide5() {
        var res = solution.divide(-2147483648, -1);

        assertEquals(2147483647, res);
    }

    @Test
    void divide6() {
        var res = solution.divide(-2147483648, 4);

        assertEquals(-536870912, res);
    }

    @Test
    void divide7() {
        var res = solution.divide(-4, -2);

        assertEquals(2, res);
    }

    @Test
    void divide8() {
        var res = solution.divide(-2147483648, 1);

        assertEquals(-2147483648, res);
    }

    @Test
    void divide9() {
        var res = solution.divide(2147483647, 3);

        assertEquals(715827882, res);
    }

    @Test
    void divide10() {
        var res = solution.divide(11, 3);

        assertEquals(3, res);
    }
}
