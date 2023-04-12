package org.lllbllllb.problems.rottingoranges;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void orangesRotting1() {
        var res = solution.orangesRotting(new int[][]{
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        });

        assertEquals(4, res);
    }

    @Test
    void orangesRotting2() {
        var res = solution.orangesRotting(new int[][]{
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        });

        assertEquals(-1, res);
    }

    @Test
    void orangesRotting3() {
        var res = solution.orangesRotting(new int[][]{{0, 2}});

        assertEquals(0, res);
    }

    @Test
    void orangesRotting4() {
        var res = solution.orangesRotting(new int[][]{{0}});

        assertEquals(0, res);
    }
}
