package org.lllbllllb.problems.surroundedregions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void solve1() {
        var board = new char[][]{
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        solution.solve(board);

        assertThat(board).isDeepEqualTo(new char[][]{
            {'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'X', 'X'}
        });
    }

    @Test
    void solve2() {
        var board = new char[][]{
            {'X'}
        };

        solution.solve(board);

        assertThat(board).isDeepEqualTo(new char[][]{
            {'X'}
        });
    }
}
