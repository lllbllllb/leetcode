package org.lllbllllb.problems.minimumintervaltoincludeeachquery;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void minInterval1() {
        var res = solution.minInterval(new int[][]{{1, 4}, {2, 4}, {3, 6}, {4, 4}}, new int[]{2, 3, 4, 5});

        assertThat(res).containsExactly(3, 3, 1, 4);
    }

    @Test
    void minInterval2() {
        var res = solution.minInterval(new int[][]{{2, 3}, {2, 5}, {1, 8}, {20, 25}}, new int[]{2, 19, 5, 22});

        assertThat(res).containsExactly(2, -1, 4, 6);
    }

    @Test
    void minInterval3() {
        var res = solution.minInterval(new int[][]{{4, 5}, {5, 8}, {1, 9}, {8, 10}, {1, 6}}, new int[]{7, 9, 3, 9, 3});

        assertThat(res).containsExactly(4, 3, 6, 3, 6);
    }

    @Test
    void minInterval4() {
        var res = solution.minInterval(new int[][]{{9, 9}, {6, 7}, {5, 6}, {2, 5}, {3, 3}}, new int[]{6, 1, 1, 1, 9});

        assertThat(res).containsExactly(2, -1, -1, -1, 1);
    }
}
