package org.lllbllllb.problems.distinctsubsequences;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void shouldNumDistinctTest1() {
        var res = solution.numDistinct("rabbbit", "rabbit");

        assertEquals(3, res);
    }

    @Test
    void shouldNumDistinctTest2() {
        var res = solution.numDistinct("babgbag", "bag");

        assertEquals(5, res);
    }
}
