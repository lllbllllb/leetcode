package org.lllbllllb.problems.coursescheduleii;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void findOrder1() {
        var res = solution.findOrder(2, new int[][]{{1, 0}});

        assertThat(res).containsExactly(0, 1);
    }

    @Test
    void findOrder2() {
        var res = solution.findOrder(4, new int[][]{
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        });

        assertThat(res).containsExactly(0, 1, 2, 3); // 0 1 2 3
    }

    @Test
    void findOrder3() {
        var res = solution.findOrder(1, new int[][]{});

        assertThat(res).containsExactly(0);
    }

    @Test
    void findOrder4() {
        var res = solution.findOrder(2, new int[][]{{0, 1}});

        assertThat(res).containsExactly(1, 0);
    }
}
