package org.lllbllllb.leetcode.problems.multiplystrings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void multiply1() {
        var res = solution.multiply("2", "3");

        assertEquals("6", res);
    }

    @Test
    void multiply2() {
        var res = solution.multiply("123", "456");

        assertEquals("56088", res);
    }

    @Test
    void multiply3() {
        var res = solution.multiply("3", "456");

        assertEquals("1368", res);
    }

    @Test
    void multiply4() {
        var res = solution.multiply("123456789", "987654321");

        assertEquals("121932631112635269", res);
    }

    @Test
    void multiply5() {
        var res = solution.multiply("9133", "0");

        assertEquals("0", res);
    }

    @Test
    void multiply6() {
        var res = solution.multiply("100", "12");

        assertEquals("1200", res);
    }
}