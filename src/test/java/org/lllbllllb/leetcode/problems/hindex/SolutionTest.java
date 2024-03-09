package org.lllbllllb.leetcode.problems.hindex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void hIndex1() {
        var res = solution.hIndex(new int[]{3, 0, 6, 1, 5});

        assertEquals(3, res);
    }

    @Test
    void hIndex2() {
        var res = solution.hIndex(new int[]{1, 3, 1});

        assertEquals(1, res);
    }

    @Test
    void hIndex3() {
        var res = solution.hIndex(new int[]{6});

        assertEquals(1, res);
    }

    @Test
    void hIndex4() {
        var res = solution.hIndex(new int[]{0, 0});

        assertEquals(0, res);
    }
}
