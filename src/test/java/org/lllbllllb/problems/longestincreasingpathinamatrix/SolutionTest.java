package org.lllbllllb.problems.longestincreasingpathinamatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void shouldLongestIncreasingPathTest1() {
        var res = solution.longestIncreasingPath(new int[][]{
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        });

        assertEquals(4, res);
    }

    @Test
    void shouldLongestIncreasingPathTest2() {
        var res = solution.longestIncreasingPath(new int[][]{
            {3, 4, 5},
            {3, 2, 6},
            {2, 2, 1}
        });

        assertEquals(4, res);
    }

    @Test
    void shouldLongestIncreasingPathTest3() {
        var res = solution.longestIncreasingPath(new int[][]{{1}});

        assertEquals(1, res);
    }
}
