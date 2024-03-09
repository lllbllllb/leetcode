package org.lllbllllb.leetcode.problems.nextgreaterelementii;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void nextGreaterElements1() {
        var res = solution.nextGreaterElements(new int[]{1, 2, 1});

        assertThat(res).containsExactly(2, -1, 2);
    }

    @Test
    void nextGreaterElements2() {
        var res = solution.nextGreaterElements(new int[]{1, 2, 3, 4, 3});

        assertThat(res).containsExactly(2, 3, 4, -1, 4);
    }

    @Test
    void nextGreaterElements3() {
        var res = solution.nextGreaterElements(new int[]{4, 3, 2, 1});

        assertThat(res).containsExactly(-1, 4, 4, 4);
    }
}
