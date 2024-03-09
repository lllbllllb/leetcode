package org.lllbllllb.leetcode.problems.longestconsecutivesequence;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void longestConsecutive1() {
        var res = solution.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});

        assertEquals(4, res);
    }

    @Test
    void longestConsecutive2() {
        var res = solution.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});

        assertEquals(9, res);
    }

    @Test
    void longestConsecutive3() {
        var res = solution.longestConsecutive(new int[]{-1, -9, -5, -2, -9, 8, -8, 1, -9, -3, -3});

        assertEquals(3, res);
    }

    @Test
    void longestConsecutive4() {
        var res = solution.longestConsecutive(new int[]{-2, -3, -3, 7, -3, 0, 5, 0, -8, -4, -1, 2});

        assertEquals(5, res);
    }

    @Test
    void longestConsecutive5() {
        var res = solution.longestConsecutive(new int[]{});

        assertEquals(0, res);
    }
}
