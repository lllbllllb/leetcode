package org.lllbllllb.leetcode.problems.countingbits;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void countBits1() {
        var res = solution.countBits(2);

        assertThat(res).containsExactly(0, 1, 1);
    }

    @Test
    void countBits2() {
        var res = solution.countBits(5);

        assertThat(res).containsExactly(0, 1, 1, 2, 1, 2);
    }

    @Test
    void countBits3() {
        var res = solution.countBits(8);

        assertThat(res).containsExactly(0, 1, 1, 2, 1, 2, 2, 3, 1);
    }

    @Test
    void countBits4() {
        var res = solution.countBits(16);

        assertThat(res).containsExactly(0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1); //
    }
}