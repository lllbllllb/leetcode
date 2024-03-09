package org.lllbllllb.leetcode.problems.removenthnodefromendoflist;

import org.junit.jupiter.api.Test;
import org.lllbllllb.leetcode.domain.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void removeNthFromEnd1() {
        var source = ListNode.of(1,2,3,4,5);
        var target = ListNode.of(1,2,3,5);
        var res = solution.removeNthFromEnd(source, 2);

        assertEquals(target, res);
    }

    @Test
    void removeNthFromEnd2() {
        var source = ListNode.of(1);
        var res = solution.removeNthFromEnd(source, 1);

        assertEquals(null, res);
    }

    @Test
    void removeNthFromEnd3() {
        var source = ListNode.of(1,2);
        var res = solution.removeNthFromEnd(source, 2);
        var target = ListNode.of(2);

        assertEquals(target, res);
    }
}
