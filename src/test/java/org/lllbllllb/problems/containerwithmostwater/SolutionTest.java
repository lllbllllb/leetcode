package org.lllbllllb.problems.containerwithmostwater;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxArea1() {
        var res = solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});

        assertEquals(49, res);
    }

    @Test
    void maxArea2() {
        var res = solution.maxArea(new int[]{1, 1});

        assertEquals(1, res);
    }

    @Test
    void maxArea3() {
        var res = solution.maxArea(new int[]{1,2,1});

        assertEquals(2, res);
    }
}
