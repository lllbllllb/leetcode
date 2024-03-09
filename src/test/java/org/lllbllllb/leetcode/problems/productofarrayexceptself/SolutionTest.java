package org.lllbllllb.leetcode.problems.productofarrayexceptself;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void productExceptSelf1() {
        var res = solution.productExceptSelf(new int[]{1, 2, 3, 4});

        assertThat(res).containsExactly(24, 12, 8, 6);
    }

    @Test
    void productExceptSelf2() {
        var res = solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3});

        assertThat(res).containsExactly(0, 0, 9, 0, 0);
    }
}
