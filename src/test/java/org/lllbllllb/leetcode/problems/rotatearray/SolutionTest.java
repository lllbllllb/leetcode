package org.lllbllllb.leetcode.problems.rotatearray;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void rotate1() {
        var arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution.rotate(arr, 3);

        assertThat(arr).containsExactly(5, 6, 7, 1, 2, 3, 4);
    }

    @Test
    void rotate2() {
        var arr = new int[]{-1,-100,3,99};
        solution.rotate(arr, 2);

        assertThat(arr).containsExactly(3,99,-1,-100);
    }
}
