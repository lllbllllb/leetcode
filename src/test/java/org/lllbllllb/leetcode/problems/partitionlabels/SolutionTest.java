package org.lllbllllb.leetcode.problems.partitionlabels;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void partitionLabels1() {
        var res = solution.partitionLabels("ababcbacadefegdehijhklij");

        assertThat(res).containsExactly(9, 7, 8);
    }

    @Test
    void partitionLabels2() {
        var res = solution.partitionLabels("eccbbbbdec");

        assertThat(res).containsExactly(10);
    }
}
