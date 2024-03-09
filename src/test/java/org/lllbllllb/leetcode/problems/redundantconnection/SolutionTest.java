package org.lllbllllb.leetcode.problems.redundantconnection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void findRedundantConnection1() {
        var res = solution.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}});

        assertThat(res).containsExactly(2, 3);
    }

    @Test
    void findRedundantConnection2() {
        var res = solution.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}});

        assertThat(res).containsExactly(1, 4);
    }
}
