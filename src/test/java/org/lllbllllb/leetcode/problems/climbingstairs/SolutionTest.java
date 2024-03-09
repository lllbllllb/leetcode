package org.lllbllllb.leetcode.problems.climbingstairs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void climbStairs1() {
        var res = solution.climbStairs(2);

        assertEquals(2, res);
    }

    @Test
    void climbStairs2() {
        var res = solution.climbStairs(3);

        assertEquals(3, res);
    }

    @Test
    void climbStairs3() {
        var res = solution.climbStairs(4);

        assertEquals(5, res); // 1111, 22, 121,211,112
    }

    @Test
    void climbStairs4() {
        var res = solution.climbStairs(45);

        assertEquals(1836311903, res);
    }

    @Test
    void climbStairs5() {
        var res = solution.climbStairs(5);

        assertEquals(8, res);
    }

    @Test
    void climbStairs6() {
        var res = solution.climbStairs(6);

        assertEquals(13, res);
    }

    @Test
    void climbStairs7() {
        var res = solution.climbStairs(1);

        assertEquals(1, res);
    }
}
