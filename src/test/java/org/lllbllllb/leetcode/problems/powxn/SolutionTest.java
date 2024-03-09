package org.lllbllllb.leetcode.problems.powxn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void myPow1() {
        var res = solution.myPow(2.00000, 10);

        assertEquals(1024.00000, res);
    }

    @Test
    void myPow2() {
        var res = solution.myPow(2.10000, 3);

        assertEquals(9.26100, res, 0.000001);
    }

    @Test
    void myPow3() {
        var res = solution.myPow(2.00000, -2);
    }

    @Test
    void myPow4() {
        var res = solution.myPow(0.44528, 0);

        assertEquals(1.0, res);
    }

    @Test
    void myPow5() {
        var res = solution.myPow(1.00000, 2147483647);

        assertEquals(1.0, res);
    }
    @Test
    void myPow6() {
        var res = solution.myPow(2.00000, -2147483648);

        assertEquals(0.00000, res);
    }

    @Test
    void myPow7() {
        var res = solution.myPow(-1.00000, 2147483647);

        assertEquals(-1.00000, res);
    }

    @Test
    void myPow8() {
        var res = solution.myPow(1.0000000000001, -2147483648);

        assertEquals(0.99979, res, 0.00001);
    }
}