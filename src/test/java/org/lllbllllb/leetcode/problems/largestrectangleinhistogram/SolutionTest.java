package org.lllbllllb.leetcode.problems.largestrectangleinhistogram;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void largestRectangleArea1() {
        var res = solution.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});

        assertEquals(10, res);
    }

    @Test
    void largestRectangleArea2() {
        var res = solution.largestRectangleArea(new int[]{2, 4});

        assertEquals(4, res);
    }

    @Test
    void largestRectangleArea3() {
        var res = solution.largestRectangleArea(new int[]{1, 2, 3, 4, 5});

        assertEquals(9, res);
    }

    @Test
    void largestRectangleArea4() {
        var res = solution.largestRectangleArea(new int[]{1, 2, 0, 1, 1});

        assertEquals(2, res);
    }

    @Test
    void largestRectangleArea5() {
        var res = solution.largestRectangleArea(new int[]{3, 2, 6, 5, 1, 2});

        assertEquals(10, res);
    }

    @Test
    void largestRectangleArea6() {
        var res = solution.largestRectangleArea(new int[]{1});

        assertEquals(1, res);
    }

    @Test
    void largestRectangleArea7() {
        var res = solution.largestRectangleArea(new int[]{0, 9});

        assertEquals(9, res);
    }

    @Test
    void largestRectangleArea8() {
        var res = solution.largestRectangleArea(new int[]{4, 2, 0, 3, 2, 5});

        assertEquals(6, res);
    }

    @Test
    void largestRectangleArea9() {
        var res = solution.largestRectangleArea(new int[]{3, 6, 5, 7, 4, 8, 1, 0});

        assertEquals(20, res);
    }
}
