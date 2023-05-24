package org.lllbllllb.problems.mergeintervals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void merge1() {
        var res = solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});

        assertThat(res).isDeepEqualTo(new int[][]{{1, 6}, {8, 10}, {15, 18}});
    }

    @Test
    void merge2() {
        var res = solution.merge(new int[][]{{1, 4}, {4, 5}});

        assertThat(res).isDeepEqualTo(new int[][]{{1, 5}});
    }

    @Test
    void merge3() {
        var res = solution.merge(new int[][]{{1, 4}, {0, 4}});

        assertThat(res).isDeepEqualTo(new int[][]{{0, 4}});
    }
}
