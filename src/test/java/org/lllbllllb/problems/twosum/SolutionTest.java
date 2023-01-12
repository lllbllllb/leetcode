package org.lllbllllb.problems.twosum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void twoSum1() {
        var res = solution.twoSum(new int[]{2,7,11,15}, 9);

        assertThat(res).containsExactlyInAnyOrder(0, 1);
    }

    @Test
    void twoSum2() {
        var res = solution.twoSum(new int[]{3,2,4}, 6);

        assertThat(res).containsExactlyInAnyOrder(2, 1);
    }

    @Test
    void twoSum3() {
        var res = solution.twoSum(new int[]{3,3}, 6);

        assertThat(res).containsExactlyInAnyOrder(0, 1);
    }
}
