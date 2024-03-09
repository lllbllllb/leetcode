package org.lllbllllb.leetcode.problems.palindromepartitioning;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void partition1() {
        var res = solution.partition("aab");

        assertThat(res).containsExactlyInAnyOrder(
            List.of("a", "a", "b"),
            List.of("aa", "b")
        );
    }

    @Test
    void partition2() {
        var res = solution.partition("a");

        assertThat(res).containsExactlyInAnyOrder(List.of("a"));
    }

    @Test
    void partition3() {
        var res = solution.partition("ababa");

        assertThat(res).containsExactlyInAnyOrder(
            List.of("a", "b", "a", "b", "a"),
            List.of("aba", "b", "a"),
            List.of("a", "b", "aba"),
            List.of("ababa"),
            List.of("a", "bab", "a")
        );
    }

    @Test
    void partition4() {
        var res = solution.partition("abacaba");

        assertThat(res).containsExactlyInAnyOrder(
            List.of("a", "b", "a", "c", "a", "b", "a"),
            List.of("aba", "c", "aba"),
            List.of("abacaba"),
            List.of("aba", "c", "a", "b", "a"),
            List.of("a", "b", "aca", "b", "a"),
            List.of("a", "bacab", "a"),
            List.of("a", "b", "a", "c", "aba")
        );
    }
}
