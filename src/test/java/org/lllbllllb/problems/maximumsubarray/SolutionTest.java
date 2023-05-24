package org.lllbllllb.problems.maximumsubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxSubArray1() {
        var res = solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});

        assertEquals(6, res);
    }

    @Test
    void maxSubArray2() {
        var res = solution.maxSubArray(new int[]{1});

        assertEquals(1, res);
    }

    @Test
    void maxSubArray3() {
        var res = solution.maxSubArray(new int[]{5, 4, -1, 7, 8});

        assertEquals(23, res);
    }

    @Test
    void maxSubArray4() {
        var res = solution.maxSubArray(new int[]{-2, 4, -1, 4, -1, 2, 1, -5, 4});

        assertEquals(9, res);
    }
}
