package org.lllbllllb.leetcode.problems.carfleet;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void carFleet1() {
        var res = solution.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3});

        assertEquals(3, res);
    }

    @Test
    void carFleet2() {
        var res = solution.carFleet(10, new int[]{3}, new int[]{3});

        assertEquals(1, res);
    }

    @Test
    void carFleet3() {
        var res = solution.carFleet(100, new int[]{0, 2, 4}, new int[]{4, 2, 1});

        assertEquals(1, res);
    }

    @Test
    void carFleet4() {
        var res = solution.carFleet(10, new int[]{4, 6}, new int[]{3, 2});

        assertEquals(1, res);
    }

    @Test
    void carFleet5() {
        var res = solution.carFleet(10, new int[]{6, 8}, new int[]{3, 2});

        assertEquals(2, res);
    }

    @Test
    void carFleet6() {
        var res = solution.carFleet(10, new int[]{0, 4, 2}, new int[]{2, 1, 3});

        assertEquals(1, res);
    }

    @Test
    void carFleet7() {
        var res = solution.carFleet(633947, new int[]{438041, 10102, 52880, 327011, 192635, 540709, 246171, 288172, 299615, 12225}, new int[]{952932, 300584, 277425, 445395, 776871, 998301, 45486, 793585, 617741, 73735});

        assertEquals(4, res);
    }


}
