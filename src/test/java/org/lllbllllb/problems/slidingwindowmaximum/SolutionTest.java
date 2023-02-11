package org.lllbllllb.problems.slidingwindowmaximum;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxSlidingWindow1() {
        var res = solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);

        assertThat(res).containsExactly(3, 3, 5, 5, 6, 7);
    }

    @Test
    void maxSlidingWindow2() {
        var res = solution.maxSlidingWindow(new int[]{1}, 1);

        assertThat(res).containsExactly(1);
    }

    @Test
    void maxSlidingWindow3() {
        var res = solution.maxSlidingWindow(new int[]{3, 1, -1, -3, 5, 3, 6, 7}, 3);

        assertThat(res).containsExactly(3, 1, 5, 5, 6, 7);
    }

    @Test
    void maxSlidingWindow4() {
        var res = solution.maxSlidingWindow(new int[]{}, 0);

        assertThat(res).containsExactly();
    }
}
