package org.lllbllllb.leetcode.problems.cheapestflightswithinkstops;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void shouldFindCheapestPriceTest1() {
        var res = solution.findCheapestPrice(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1);

        assertEquals(700, res);
    }

    @Test
    void shouldFindCheapestPriceTest2() {
        var res = solution.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1);

        assertEquals(200, res);
    }

    @Test
    void shouldFindCheapestPriceTest3() {
        var res = solution.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0);

        assertEquals(500, res);
    }

    @Test
    void shouldFindCheapestPriceTest4() {
        var res = solution.findCheapestPrice(10, new int[][]{{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4}, {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6}, {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}}, 6, 0, 7);

        assertEquals(14, res);
    }

    @Test
    void shouldFindCheapestPriceTest5() {
        var res = solution.findCheapestPrice(5, new int[][]{{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}}, 0, 2, 2);

        assertEquals(7, res);
    }

    @Test
    void shouldFindCheapestPriceTest6() {
        var res = solution.findCheapestPrice(5, new int[][]{{0, 1, 1}, {0, 2, 5}, {1, 2, 1}, {2, 3, 1}}, 0, 3, 1);

        assertEquals(6, res);
    }
}
