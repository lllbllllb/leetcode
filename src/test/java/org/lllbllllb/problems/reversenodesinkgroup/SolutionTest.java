package org.lllbllllb.problems.reversenodesinkgroup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void reverseKGroup1() {
        var res = solution.reverseKGroup(generate(1, 2, 3, 4, 5), 2);

        assertEquals(generate(2, 1, 4, 3, 5), res);
    }

    @Test
    void reverseKGroup2() {
        var res = solution.reverseKGroup(generate(1, 2, 3, 4, 5), 3);

        assertEquals(generate(3, 2, 1, 4, 5), res);
    }

    @Test
    void reverseKGroup3() {
        var res = solution.reverseKGroup(generate(1, 2, 3, 4, 5, 6, 7, 8), 3);

        assertEquals(generate(3, 2, 1, 6, 5, 4, 7, 8), res);
    }

    @Test
    void reverseKGroup4() {
        var res = solution.reverseKGroup(generate(1, 2, 3, 4), 1);

        assertEquals(generate(1, 2, 3, 4), res);
    }

    @Test
    void reverseKGroup5() {
        var res = solution.reverseKGroup(generate(1), 1);

        assertEquals(generate(1), res);
    }

    @Test
    void reverseKGroup6() {
        var res = solution.reverseKGroup(generate(1, 2), 2);

        assertEquals(generate(2, 1), res);
    }

    @Test
    void reverseKGroup7() {
        var res = solution.reverseKGroup(generate(1, 2, 3, 4), 2);

        assertEquals(generate(2, 1, 4, 3), res);
    }

    private ListNode generate(int... vals) {
        var tail = new ListNode(vals[vals.length - 1]);

        for (int i = vals.length - 2; i > -1; i--) {
            tail = new ListNode(vals[i], tail);
        }

        return tail;
    }
}
