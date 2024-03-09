package org.lllbllllb.leetcode.problems.networkdelaytime;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void networkDelayTime1() {
        var res = solution.networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2);

        assertEquals(2, res);
    }

    @Test
    void networkDelayTime2() {
        var res = solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1);

        assertEquals(1, res);
    }

    @Test
    void networkDelayTime3() {
        var res = solution.networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2);

        assertEquals(-1, res);
    }

    @Test
    void networkDelayTime4() {
        var res = solution.networkDelayTime(new int[][]{{1, 2, 1}, {2, 1, 3}}, 2, 2);

        assertEquals(3, res);
    }

    @Test
    void networkDelayTime5() {
        var res = solution.networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}}, 3, 1);

        assertEquals(2, res);
    }

    @Test
    void networkDelayTime6() {
        var res = solution.networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 7}, {1, 3, 4}, {2, 1, 2}}, 4, 1);

        assertEquals(-1, res);
    }

    @Test
    void networkDelayTime7() {
        var res = solution.networkDelayTime(new int[][]{{3, 5, 78}, {2, 1, 1}, {1, 3, 0}, {4, 3, 59}, {5, 3, 85}, {5, 2, 22}, {2, 4, 23}, {1, 4, 43}, {4, 5, 75}, {5, 1, 15}, {1, 5, 91}, {4, 1, 16}, {3, 2, 98}, {3, 4, 22}, {5, 4, 31}, {1, 2, 0}, {2, 5, 4}, {4, 2, 51}, {3, 1, 36}, {2, 3, 59}}, 5, 5);

        assertEquals(31, res);
    }
}
