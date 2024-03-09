package org.lllbllllb.leetcode.problems.groupanagrams;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void groupAnagrams1() {
        var res = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        assertThat(res).containsExactlyInAnyOrder(List.of("bat"), List.of("tan", "nat"), List.of("eat", "tea", "ate"));
    }

    @Test
    void groupAnagrams2() {
        var res = solution.groupAnagrams(new String[]{""});

        assertThat(res).containsExactlyInAnyOrder(List.of(""));
    }

    @Test
    void groupAnagrams3() {
        var res = solution.groupAnagrams(new String[]{"a"});

        assertThat(res).containsExactlyInAnyOrder(List.of("a"));
    }
}
