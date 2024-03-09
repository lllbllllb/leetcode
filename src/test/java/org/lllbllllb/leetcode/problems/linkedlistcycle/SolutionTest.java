package org.lllbllllb.leetcode.problems.linkedlistcycle;

import org.junit.jupiter.api.Test;
import org.lllbllllb.leetcode.domain.ListNode;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void hasCycle1() {
    }

    private ListNode generate(int... vals) {
        var tail = new ListNode(vals[vals.length - 1]);

        for (int i = vals.length - 2; i > -1; i--) {
            tail = new ListNode(vals[i], tail);
        }

        return tail;
    }
}
