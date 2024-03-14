package org.lllbllllb.other.problems.trysum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void shouldTrySumTest1() {
        var res = solution.trySum(new int[]{1, 2, 3, 4}, 4);

        assertEquals("1+2-3+4", res);
    }

    @Test
    void shouldTrySumTest2() {
        var res = solution.trySum(new int[]{1, 2, 3, 4}, 40);

        assertEquals("", res);
    }

    @Test
    void shouldTrySumTest3() {
        var res = solution.trySum(new int[]{1, 2, 3}, 0);

        assertEquals("1+2-3", res);
    }

    @Test
    void shouldTrySumTest4() {
        var res = solution.trySum(new int[]{1, 2, 3}, 2);

        assertEquals("1-2+3", res);
    }

    @Test
    void shouldTrySumTest5() {
        var res = solution.trySum(new int[]{1, 2, 3}, 6);

        assertEquals("1+2+3", res);
    }

    @Test
    void shouldTrySumTest6() {
        var res = solution.trySum(new int[]{1, 2, 3}, -6);

        assertEquals("-1-2-3", res);
    }

    @Test
    void shouldTrySumTest7() {
        var res = solution.trySum(new int[]{1, 2}, -3);

        assertEquals("-1-2", res);
    }

    @Test
    void shouldTrySumTest8() {
        var res = solution.trySum(new int[]{9, 3, 7}, 13);

        assertEquals("9-3+7", res);
    }

}
