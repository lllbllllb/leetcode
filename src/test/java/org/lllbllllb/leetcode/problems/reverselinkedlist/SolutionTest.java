package org.lllbllllb.leetcode.problems.reverselinkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void reverseList1() {
        var res = solution.reverseList(generate(1, 2, 3, 4, 5));

        assertEquals(generate(5, 4, 3, 2, 1), res);
    }

    @Test
    void reverseList2() {
        var res = solution.reverseList(generate(1, 2));

        assertEquals(generate(2, 1), res);
    }

    @Test
    void reverseList3() {
        var res = solution.reverseList(generate(1));

        assertEquals(generate(1), res);
    }

    @Test
    void reverseList4() {
        var res = solution.reverseList(null);

        assertNull(res);
    }

    private ListNode generate(int... vals) {
        var tail = new ListNode(vals[vals.length - 1]);

        for (int i = vals.length - 2; i > -1; i--) {
            tail = new ListNode(vals[i], tail);
        }

        return tail;
    }
}
