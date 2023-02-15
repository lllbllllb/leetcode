package org.lllbllllb.problems.reorderlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void reorderList1() {
        var source = generate(1, 2, 3, 4);
        solution.reorderList(source);

        assertEquals(generate(1, 4, 2, 3), source);
    }

    @Test
    void reorderList2() {
        var source = generate(1, 2, 3, 4, 5);
        solution.reorderList(source);

        assertEquals(generate(1, 5, 2, 4, 3), source);
    }

    private ListNode generate(int... vals) {
        var tail = new ListNode(vals[vals.length - 1]);

        for (int i = vals.length - 2; i > -1; i--) {
            tail = new ListNode(vals[i], tail);
        }

        return tail;
    }
}
