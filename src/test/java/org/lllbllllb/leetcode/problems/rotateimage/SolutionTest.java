package org.lllbllllb.leetcode.problems.rotateimage;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    /**
     * <pre>
     *   (0, 0) (0, 1) (0, 2)
     *   (1, 0) (1, 1) (1, 2)
     *   (2, 0) (2, 1) (2, 2)
     * </pre>
     * --->
     * <pre>
     *   (2, 0) (1, 0) (0, 0)
     *   (2, 1) (1, 1) (0, 1)
     *   (2, 2) (1, 2) (0, 2)
     * </pre>
     */
    @Test
    void rotate1() {
        var img = new int[][]{
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        solution.rotate(img);

        assertThat(img).isDeepEqualTo(new int[][]{
            {7, 4, 1},
            {8, 5, 2},
            {9, 6, 3}
        });
    }

    /**
     * <pre>
     *   (0, 0) (0, 1) (0, 2) (0, 3)
     *   (1, 0) (1, 1) (1, 2) (1, 3)
     *   (2, 0) (2, 1) (2, 2) (2, 3)
     *   (3, 0) (3, 1) (3, 2) (3, 3)
     * </pre>
     * --->
     * <pre>
     *   (3, 0) (2, 0) (1, 0) (0, 0)  i = len - j - 1; j = i;
     *   (3, 1) (2, 1) (1, 1) (0, 1)  i = j; j = len - i - 1;
     *   (3, 2) (2, 2) (1, 2) (0, 2)
     *   (3, 3) (2, 3) (1, 3) (0, 3)
     * </pre>
     */
    @Test
    void rotate2() {
        var img = new int[][]{
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };
        solution.rotate(img);

        assertThat(img).isDeepEqualTo(new int[][]{
            {15, 13, 2, 5},
            {14, 3, 4, 1},
            {12, 6, 8, 9},
            {16, 7, 10, 11}
        });
    }

    /**
     * <pre>
     *   (0, 0) (0, 1)
     *   (1, 0) (1, 1)
     * </pre>
     * --->
     * <pre>
     *   (1, 0) (0, 0)
     *   (1, 1) (0, 1)
     * </pre>
     */
    @Test
    void rotate3() {
        var img = new int[][]{
            {1, 2},
            {3, 4}
        };
        solution.rotate(img);

        assertThat(img).isDeepEqualTo(new int[][]{
            {3, 1},
            {4, 2}
        });
    }
}
