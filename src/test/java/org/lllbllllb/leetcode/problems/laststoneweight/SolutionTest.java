package org.lllbllllb.leetcode.problems.laststoneweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void lastStoneWeight1() {
        var res = solution.lastStoneWeight(new int[]{2,7,4,1,8,1});

        assertEquals(1, res);
    }
}
