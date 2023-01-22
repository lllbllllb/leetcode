package org.lllbllllb.problems.uniquepathsiii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void uniquePathsIII1() {
        var res = solution.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}});

        assertEquals(2, res);
    }

    @Test
    void uniquePathsIII2() {
        var res = solution.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}});

        assertEquals(4, res);
    }

    @Test
    void uniquePathsIII3() {
        var res = solution.uniquePathsIII(new int[][]{{0, 1}, {2, 0}});

        assertEquals(0, res);
    }
}
