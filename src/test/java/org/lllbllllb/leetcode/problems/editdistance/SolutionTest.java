package org.lllbllllb.leetcode.problems.editdistance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void shouldMinDistanceTest1() {
        var res = solution.minDistance("horse", "ros");

        assertEquals(3, res);
    }

    @Test
    void shouldMinDistanceTest2() {
        var res = solution.minDistance("intention", "execution");

        assertEquals(5, res);
    }

    @Test
    void shouldMinDistanceTest3() {
        var res = solution.minDistance("zybcde", "abcdef");

        assertEquals(3, res);
    }
}
