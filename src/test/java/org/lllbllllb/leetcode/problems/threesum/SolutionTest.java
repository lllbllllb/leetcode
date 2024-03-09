package org.lllbllllb.leetcode.problems.threesum;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void threeSum1() {
        var res = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});

        assertThat(res, containsInAnyOrder(List.of(-1, -1, 2), List.of(-1, 0, 1)));
    }

    @Test
    void threeSum2() {
        var res = solution.threeSum(new int[]{0, 1, 1});

        assertThat(res, containsInAnyOrder());
    }

    @Test
    void threeSum3() {
        var res = solution.threeSum(new int[]{0, 0, 0});

        assertThat(res, containsInAnyOrder(List.of(0, 0, 0)));
    }

    @Test
    void threeSum4() {
        var res = solution.threeSum(new int[]{-2, 0, 1, 1, 2});

        assertThat(res, containsInAnyOrder(List.of(-2, 0, 2), List.of(-2, 1, 1)));
    }

    @Test
    void threeSum5() {
        var res = solution.threeSum(new int[]{-2, -1, -1, 0, 2});

        assertThat(res, containsInAnyOrder(List.of(-2, 0, 2), List.of(-1, -1, 2)));
    }

    @Test
    void threeSum6() {
        var res = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4}); // -4 -3 -2 -1 -1 0 0 1 2 3 4

        assertThat(res, containsInAnyOrder(
            List.of(-4, 0, 4),
            List.of(-4, 1, 3),
            List.of(-3, -1, 4),
            List.of(-3, 0, 3),
            List.of(-3, 1, 2),
            List.of(-2, -1, 3),
            List.of(-2, 0, 2),
            List.of(-1, -1, 2),
            List.of(-1, 0, 1))
        );
    }
}
