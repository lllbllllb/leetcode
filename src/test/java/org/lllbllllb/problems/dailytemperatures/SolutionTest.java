package org.lllbllllb.problems.dailytemperatures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void dailyTemperatures1() {
        // 73, 74, 75, 71, 69, 72, 76, 73
        var res = solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});

        assertThat(res).containsExactly(1, 1, 4, 2, 1, 1, 0, 0);
    }

    @Test
    void dailyTemperatures2() {
        var res = solution.dailyTemperatures(new int[]{30, 40, 50, 60});

        assertThat(res).containsExactly(1, 1, 1, 0);
    }

    @Test
    void dailyTemperatures3() {
        var res = solution.dailyTemperatures(new int[]{30, 60, 90});

        assertThat(res).containsExactly(1, 1, 0);
    }
}
