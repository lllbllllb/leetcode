package org.lllbllllb.leetcode.problems.permutations;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void permute1() {
        var res = solution.permute(new int[]{1, 2, 3});

        assertThat(res).containsExactlyInAnyOrder(List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1));
    }

    @Test
    void permute2() {
        var res = solution.permute(new int[]{0, 1});

        assertThat(res).containsExactlyInAnyOrder(List.of(0, 1), List.of(1, 0));
    }

    @Test
    void permute3() {
        var res = solution.permute(new int[]{1});

        assertThat(res).containsExactlyInAnyOrder(List.of(1));
    }

    @Test
    void permute4() {
        var res = solution.permute(new int[]{0, 1, 2});

        assertThat(res).containsExactlyInAnyOrder(List.of(1, 2, 0), List.of(1, 0, 2), List.of(2, 1, 0), List.of(2, 0, 1), List.of(0, 1, 2), List.of(0, 2, 1));
    }
}
