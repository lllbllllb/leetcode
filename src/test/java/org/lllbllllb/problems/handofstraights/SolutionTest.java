package org.lllbllllb.problems.handofstraights;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void isNStraightHand1() {
        var res = solution.isNStraightHand(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3);

        assertTrue(res);
    }

    @Test
    void isNStraightHand2() {
        var res = solution.isNStraightHand(new int[]{1, 2, 3, 4, 5}, 4);

        assertFalse(res);
    }

    @Test
    void isNStraightHand3() {
        var res = solution.isNStraightHand(new int[]{1, 1, 2, 2, 3, 3}, 3);

        assertTrue(res);
    }

    @Test
    void isNStraightHand4() {
        var res = solution.isNStraightHand(new int[]{8, 10, 12}, 3);

        assertFalse(res);
    }

    @Test
    void isNStraightHand5() {
        var res = solution.isNStraightHand(new int[]{233722108, 386144634, 221638886, 175028874, 408337082, 91410299, 793763682, 972910825, 627251147, 135020779}, 2);

        assertFalse(res);
    }
}
