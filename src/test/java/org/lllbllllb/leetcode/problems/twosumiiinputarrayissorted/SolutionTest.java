package org.lllbllllb.leetcode.problems.twosumiiinputarrayissorted;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void twoSum1() {
        var res = solution.twoSum(new int[]{2, 7, 11, 15}, 9);

        assertThat(res).containsExactly(1, 2);
    }

    @Test
    void twoSum2() {
        var res = solution.twoSum(new int[]{2, 3, 4}, 6);

        assertThat(res).containsExactly(1, 3);
    }

    @Test
    void twoSum3() {
        var res = solution.twoSum(new int[]{-1, 0}, -1);

        assertThat(res).containsExactly(1, 2);
    }
}
