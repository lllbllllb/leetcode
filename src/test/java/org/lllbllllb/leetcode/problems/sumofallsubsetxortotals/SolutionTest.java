package org.lllbllllb.leetcode.problems.sumofallsubsetxortotals;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void subsetXORSum1() {
        var res = solution.subsetXORSum(new int[]{1, 3});

        assertEquals(6, res);
    }

    @Test
    void subsetXORSum2() {
        var res = solution.subsetXORSum(new int[]{2, 5, 6});

        assertEquals(28, res);
    }

    @Test
    void subsetXORSum3() {
        var res = solution.subsetXORSum(new int[]{5, 1, 6});

        assertEquals(28, res);
    }

    @Test
    void subsetXORSum4() {
        var res = solution.subsetXORSum(new int[]{3,4,5,6,7,8});

        assertEquals(480, res);
    }
}
