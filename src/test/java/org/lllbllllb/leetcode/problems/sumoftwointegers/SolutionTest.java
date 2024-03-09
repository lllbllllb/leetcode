package org.lllbllllb.leetcode.problems.sumoftwointegers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void getSum1() {
        var res = solution.getSum(1, 2);

        assertEquals(3, res);
    }

    @Test
    void getSum2() {
        var res = solution.getSum(2, 3);

        assertEquals(5, res);
    }

    @Test
    void getSum3() {
        var res = solution.getSum(3, 1);

        assertEquals(4, res);
    }

    @Test
    void getSum4() {
        var res = solution.getSum(1, 3);

        assertEquals(4, res);
    }

    @Test
    void getSum5() {
        var res = solution.getSum(5, 3);

        assertEquals(8, res);
    }
}