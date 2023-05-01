package org.lllbllllb.problems.kclosestpointstoorigin;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void kClosest1() {
        var res = solution.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1);

        assertThat(List.of(res)).containsExactlyInAnyOrder(new int[]{-2, 2});
    }

    @Test
    void kClosest2() {
        var res = solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);

        assertThat(List.of(res)).containsExactlyInAnyOrder(new int[]{3, 3}, new int[]{-2, 4});
    }
}
