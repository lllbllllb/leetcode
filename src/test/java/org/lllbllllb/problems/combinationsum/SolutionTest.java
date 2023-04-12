package org.lllbllllb.problems.combinationsum;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void combinationSum1() {
        var res = solution.combinationSum(new int[]{2, 3, 6, 7}, 7);

        assertThat(res).containsExactlyInAnyOrder(List.of(2, 2, 3), List.of(7));

    }

    @Test
    void combinationSum2() {
        var res = solution.combinationSum(new int[]{2, 3, 5}, 8);

        assertThat(res).containsExactlyInAnyOrder(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5));

    }

    @Test
    void combinationSum3() {
        var res = solution.combinationSum(new int[]{2}, 1);

        assertThat(res).containsExactlyInAnyOrder();

    }
}
