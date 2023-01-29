package org.lllbllllb.problems.basiccalculatorii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void calculate1() {
        var res = solution.calculate("3+2*2");

        assertEquals(7, res);
    }

    @Test
    void calculate2() {
        var res = solution.calculate(" 3/2 ");

        assertEquals(1, res);
    }

    @Test
    void calculate3() {
        var res = solution.calculate(" 3+5 / 2 ");

        assertEquals(5, res);
    }
}
