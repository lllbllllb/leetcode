package org.lllbllllb.leetcode.problems.spiralmatrix;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void spiralOrder1() {
        var res = solution.spiralOrder(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });

        assertThat(res).containsExactly(1, 2, 3, 6, 9, 8, 7, 4, 5);
    }

    @Test
    void spiralOrder2() {
        var res = solution.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        });

        assertThat(res).containsExactly(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
    }

    @Test
    void spiralOrder3() {
        var res = solution.spiralOrder(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        });

        assertThat(res).containsExactly(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10);
    }
}