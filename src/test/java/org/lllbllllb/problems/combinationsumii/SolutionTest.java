package org.lllbllllb.problems.combinationsumii;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void combinationSum21() {
        var res = solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);

        assertThat(res).containsExactlyInAnyOrder(List.of(1, 1, 6), List.of(1, 2, 5), List.of(1, 7), List.of(2, 6));
    }

    @Test
    void combinationSum22() {
        var res = solution.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);

        assertThat(res).containsExactlyInAnyOrder(List.of(1, 2, 2), List.of(5));
    }
}
