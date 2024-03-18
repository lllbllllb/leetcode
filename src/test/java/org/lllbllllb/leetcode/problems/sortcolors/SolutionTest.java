package org.lllbllllb.leetcode.problems.sortcolors;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void shouldSortColorsTest1() {
        var arr = new int[]{2, 0, 2, 1, 1, 0};
        solution.sortColors(arr);

        assertThat(arr).containsExactly(0, 0, 1, 1, 2, 2);
    }

    @Test
    void shouldSortColorsTest2() {
        var arr = new int[]{2, 0, 1};
        solution.sortColors(arr);

        assertThat(arr).containsExactly(0, 1, 2);
    }

}
