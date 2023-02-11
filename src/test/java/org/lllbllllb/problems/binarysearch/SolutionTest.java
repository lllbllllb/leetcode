package org.lllbllllb.problems.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void search1() {
        var res = solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9);

        assertEquals(4, res);
    }

    @Test
    void search2() {
        var res = solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 2);

        assertEquals(-1, res);
    }

    @Test
    void search3() {
        var res = solution.search(new int[]{-1,0,3,5,9,12}, 13);

        assertEquals(-1, res);
    }
}
