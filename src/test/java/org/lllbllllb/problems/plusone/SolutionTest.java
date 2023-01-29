package org.lllbllllb.problems.plusone;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void plusOne1() {
        var res = solution.plusOne(new int[]{1, 2, 3});

        assertThat(res).containsExactly(1, 2, 4);
    }

    @Test
    void plusOne2() {
        var res = solution.plusOne(new int[]{4, 3, 2, 1});

        assertThat(res).containsExactly(4, 3, 2, 2);
    }

    @Test
    void plusOne3() {
        var res = solution.plusOne(new int[]{9});

        assertThat(res).containsExactly(1, 0);
    }

    @Test
    void plusOne4() {
        var res = solution.plusOne(new int[]{9, 9, 9});

        assertThat(res).containsExactly(1, 0, 0, 0);
    }

    @Test
    void plusOne5() {
        var res = solution.plusOne(new int[]{9, 9, 8});

        assertThat(res).containsExactly(9, 9, 9);
    }
}
