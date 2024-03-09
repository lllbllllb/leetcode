package org.lllbllllb.leetcode.problems.addtwonumbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void addTwoNumbers1() {
        var res = solution.addTwoNumbers(generate(2, 4, 3), generate(5, 6, 4));

        assertEquals(generate(7, 0, 8), res);
    }

    @Test
    void addTwoNumbers2() {
        var res = solution.addTwoNumbers(generate(0), generate(0));

        assertEquals(generate(0), res);
    }

    @Test
    void addTwoNumbers3() {
        var res = solution.addTwoNumbers(generate(9,9,9,9,9,9,9), generate(9,9,9,9));

        assertEquals(generate(8,9,9,9,0,0,0,1), res);
    }

    private ListNode generate(int... vals) {
        var tail = new ListNode(vals[vals.length - 1]);

        for (int i = vals.length - 2; i > -1; i--) {
            tail = new ListNode(vals[i], tail);
        }

        return tail;
    }
}
