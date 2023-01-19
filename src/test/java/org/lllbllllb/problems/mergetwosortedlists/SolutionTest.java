package org.lllbllllb.problems.mergetwosortedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void mergeTwoLists1() {
        var res = solution.mergeTwoLists(generate(1, 2, 4), generate(1, 3, 4));

        assertEquals(generate(1,1,2,3,4,4), res);
    }

    @Test
    void mergeTwoLists2() {
        var res = solution.mergeTwoLists(null, null);

        assertNull(res);
    }

    @Test
    void mergeTwoLists3() {
        var res = solution.mergeTwoLists(null, generate(0));

        assertEquals(generate(0), res);
    }

    private ListNode generate(int... vals) {
        var tail = new ListNode(vals[vals.length - 1]);

        for (int i = vals.length - 2; i > -1; i--) {
            tail = new ListNode(vals[i], tail);
        }

        return tail;
    }
}
