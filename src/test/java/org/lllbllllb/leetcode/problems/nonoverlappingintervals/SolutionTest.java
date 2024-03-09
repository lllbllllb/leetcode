package org.lllbllllb.leetcode.problems.nonoverlappingintervals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void eraseOverlapIntervals1() {
        var res = solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}});

        assertEquals(1, res);
    }

    @Test
    void eraseOverlapIntervals2() {
        var res = solution.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}});

        assertEquals(2, res);
    }

    @Test
    void eraseOverlapIntervals3() {
        var res = solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}});

        assertEquals(0, res);
    }
}
