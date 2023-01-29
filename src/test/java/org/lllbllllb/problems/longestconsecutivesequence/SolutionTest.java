package org.lllbllllb.problems.longestconsecutivesequence;

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

        assertEquals(4, res);
    }
}
