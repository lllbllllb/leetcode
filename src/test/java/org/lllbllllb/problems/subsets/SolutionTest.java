package org.lllbllllb.problems.subsets;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void subsets1() {
        var res = solution.subsets(new int[]{1, 2, 3});

        assertThat(res).containsExactlyInAnyOrder(List.of(), List.of(1), List.of(2), List.of(1, 2), List.of(3), List.of(1, 3), List.of(2, 3), List.of(1, 2, 3));
    }

    @Test
    void subsets2() {
        var res = solution.subsets(new int[]{0});

        assertThat(res).containsExactlyInAnyOrder(List.of(), List.of(0));
    }
}
