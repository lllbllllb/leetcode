package org.lllbllllb.problems.setmatrixzeroes;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void setZeroes1() {
        var source = new int[][]{
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        solution.setZeroes(source);

        var expected = new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };

        assertThat(source).isDeepEqualTo(expected);
    }

    @Test
    void setZeroes2() {
        var source = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

        solution.setZeroes(source);

        var expected = new int[][]{
                {0, 0, 0, 0},
                {0, 4, 5, 0},
                {0, 3, 1, 0}
        };

        assertThat(source).isDeepEqualTo(expected);
    }

    @Test
    void setZeroes3() {
        var source = new int[][]{
                {1, 2, 3, 4},
                {5, 0, 7, 8},
                {0, 10, 11, 12},
                {13, 14, 15, 0}
        };

        solution.setZeroes(source);

        var expected = new int[][]{
                {0, 0, 3, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        assertThat(source).isDeepEqualTo(expected);
    }

    @Test
    void setZeroes4() {
        var source = new int[][]{
                {1, 0, 3}
        };

        solution.setZeroes(source);

        var expected = new int[][]{
                {0, 0, 0}
        };

        assertThat(source).isDeepEqualTo(expected);
    }
}