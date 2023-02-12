package org.lllbllllb.problems.findminimuminrotatedsortedarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void findMin1() {
        var res = solution.findMin(new int[]{3, 4, 5, 1, 2});

        assertEquals(1, res);
    }

    @Test
    void findMin2() {
        var res = solution.findMin(new int[]{4, 5, 6, 7, 0, 1, 2});

        assertEquals(0, res);
    }

    @Test
    void findMin3() {
        var res = solution.findMin(new int[]{11, 13, 15, 17});

        assertEquals(11, res);
    }
}
