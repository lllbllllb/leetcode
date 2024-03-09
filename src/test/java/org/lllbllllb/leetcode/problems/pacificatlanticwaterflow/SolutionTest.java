package org.lllbllllb.leetcode.problems.pacificatlanticwaterflow;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void pacificAtlantic1() {
        var res = solution.pacificAtlantic(new int[][]{
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        });

        assertThat(res).containsExactlyInAnyOrder(List.of(0, 4), List.of(1, 3), List.of(1, 4), List.of(2, 2), List.of(3, 0), List.of(3, 1), List.of(4, 0));
    }

    @Test
    void pacificAtlantic2() {
        var res = solution.pacificAtlantic(new int[][]{
            {1}
        });

        assertThat(res).containsExactlyInAnyOrder(List.of(0, 0));
    }

    @Test
    void pacificAtlantic3() {
        var res = solution.pacificAtlantic(new int[][]{
            {1, 2, 3},
            {8, 9, 4},
            {7, 6, 5}
        });

        assertThat(res).containsExactlyInAnyOrder(List.of(0, 2), List.of(1, 0), List.of(1, 1), List.of(1, 2), List.of(2, 0), List.of(2, 1), List.of(2, 2));
    }
}
