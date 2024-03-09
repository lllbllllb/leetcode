package org.lllbllllb.leetcode.problems.houserobber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void rob1() {
        var res = solution.rob(new int[]{1, 2, 3, 1});

        assertEquals(4, res);
    }

    @Test
    void rob2() {
        var res = solution.rob(new int[]{2, 7, 9, 3, 1});

        assertEquals(12, res);
    }

    @Test
    void rob3() {
        var res = solution.rob(new int[]{7, 1, 1, 7, 1});

        assertEquals(14, res);
    }
}
