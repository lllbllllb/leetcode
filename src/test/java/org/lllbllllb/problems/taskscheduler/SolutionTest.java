package org.lllbllllb.problems.taskscheduler;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void leastInterval1() {
        var res = solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2);

        assertEquals(8, res);
    }

    @Test
    void leastInterval2() {
        var res = solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0);

        assertEquals(6, res);
    }

    @Test
    void leastInterval3() {
        var res = solution.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2);

        assertEquals(16, res);
    }
}
