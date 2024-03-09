package org.lllbllllb.leetcode.problems.topkfrequentelements;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void topKFrequent1() {
        var res = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);

        assertThat(res).containsExactlyInAnyOrder(1, 2);
    }

    @Test
    void topKFrequent2() {
        var res = solution.topKFrequent(new int[]{1}, 1);

        assertThat(res).containsExactlyInAnyOrder(1);
    }

    @Test
    void topKFrequent3() {
        var res = solution.topKFrequent(new int[]{1, 2}, 2);

        assertThat(res).containsExactlyInAnyOrder(1, 2);
    }
}
