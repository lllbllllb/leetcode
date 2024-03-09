package org.lllbllllb.leetcode.problems.subsetsii;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void subsetsWithDup1() {
        var res = solution.subsetsWithDup(new int[]{1, 2, 2});

        assertThat(res).containsExactlyInAnyOrder(List.of(), List.of(1), List.of(1, 2), List.of(1, 2, 2), List.of(2), List.of(2, 2));
    }

    @Test
    void subsetsWithDup2() {
        var res = solution.subsetsWithDup(new int[]{0});

        assertThat(res).containsExactlyInAnyOrder(List.of(), List.of(0));
    }

    @Test
    void subsetsWithDup3() {
        var res = solution.subsetsWithDup(new int[]{1, 4, 4, 4, 4});

        assertThat(res).containsExactlyInAnyOrder(List.of(), List.of(1), List.of(1, 4), List.of(1, 4, 4), List.of(1, 4, 4, 4), List.of(1, 4, 4, 4, 4), List.of(4), List.of(4, 4), List.of(4, 4, 4), List.of(4, 4, 4, 4));
    }
}
