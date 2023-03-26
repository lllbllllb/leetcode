package org.lllbllllb.problems.houserobberii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void rob1() {
        var res = solution.rob(new int[]{2, 3, 2});

        assertEquals(3, res);
    }

    @Test
    void rob2() {
        var res = solution.rob(new int[]{1, 2, 3, 1});

        assertEquals(4, res);
    }

    @Test
    void rob3() {
        var res = solution.rob(new int[]{1, 2, 3});

        assertEquals(3, res);
    }

    @Test
    void rob4() {
        var res = solution.rob(new int[]{1, 2, 1, 1});

        assertEquals(3, res);
    }
}
