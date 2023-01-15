package org.lllbllllb.problems.gasstation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void canCompleteCircuit1() {
        var res = solution.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});

        assertEquals(3, res);
    }

    @Test
    void canCompleteCircuit2() {
        var res = solution.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});

        assertEquals(-1, res);
    }

    @Test
    void canCompleteCircuit3() {
        var res = solution.canCompleteCircuit(new int[]{3, 1, 1}, new int[]{1, 2, 2});

        assertEquals(0, res);
    }


}
