package org.lllbllllb.problems.removenthnodefromendoflist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void removeNthFromEnd1() {
        var source = generate(1,2,3,4,5);
        var target = generate(1,2,3,5);
        var res = solution.removeNthFromEnd(source, 2);

        assertEquals(target, res);
    }

    @Test
    void removeNthFromEnd2() {
        var source = generate(1);
        var res = solution.removeNthFromEnd(source, 1);

        assertEquals(null, res);
    }

    @Test
    void removeNthFromEnd3() {
        var source = generate(1,2);
        var res = solution.removeNthFromEnd(source, 2);
        var target = generate(2);

        assertEquals(target, res);
    }

    private ListNode generate(int... vals) {
        var tail = new ListNode(vals[vals.length - 1]);

        for (int i = vals.length - 2; i > -1; i--) {
            tail = new ListNode(vals[i], tail);
        }

        return tail;
    }
}
