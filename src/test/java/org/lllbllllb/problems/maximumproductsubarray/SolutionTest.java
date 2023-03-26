package org.lllbllllb.problems.maximumproductsubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxProduct1() {
        var res = solution.maxProduct(new int[]{2, 3, -2, 4});

        assertEquals(6, res);
    }

    @Test
    void maxProduct2() {
        var res = solution.maxProduct(new int[]{-2, 0, -1});

        assertEquals(0, res);
    }

    @Test
    void maxProduct3() {
        var res = solution.maxProduct(new int[]{-2});

        assertEquals(-2, res);
    }

    @Test
    void maxProduct4() {
        var res = solution.maxProduct(new int[]{-3, -1, -1});

        assertEquals(3, res);
    }

    @Test
    void maxProduct5() {
        var res = solution.maxProduct(new int[]{0, 2});

        assertEquals(2, res);
    }

    @Test
    void maxProduct6() {
        var res = solution.maxProduct(new int[]{2, -2, 3, -2, 4});

        assertEquals(96, res);
    }

    @Test
    void maxProduct7() {
        var res = solution.maxProduct(new int[]{2, -1, 3, 2, 4});

        assertEquals(24, res);
    }

    @Test
    void maxProduct8() {
        var res = solution.maxProduct(new int[]{-2, 2, -2, 2, -3});

        assertEquals(24, res);
    }

    @Test
    void maxProduct9() {
        var res = solution.maxProduct(new int[]{-3, 0, 1, -2});

        assertEquals(1, res);
    }

    @Test
    void maxProduct10() {
        var res = solution.maxProduct(new int[]{0, 3, -1});

        assertEquals(3, res);
    }
}
