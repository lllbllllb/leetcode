package org.lllbllllb.problems.numberofislands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void numIslands1() {
        var res = solution.numIslands(new char[][]{
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        });

        assertEquals(1, res);
    }

    @Test
    void numIslands2() {
        var res = solution.numIslands(new char[][]{
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        });

        assertEquals(3, res);
    }

    @Test
    void numIslands3() {
        var res = solution.numIslands(new char[][]{
            {'1', '1', '1'},
            {'0', '1', '0'},
            {'1', '1', '1'}
        });

        assertEquals(1, res);
    }
}
