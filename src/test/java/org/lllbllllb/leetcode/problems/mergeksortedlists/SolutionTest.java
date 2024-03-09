package org.lllbllllb.leetcode.problems.mergeksortedlists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void mergeKLists1() {
        var res = solution.mergeKLists(new ListNode[]{generate(1, 4, 5), generate(1, 3, 4), generate(2, 6)});

        assertEquals(generate(1,1,2,3,4,4,5,6), res);
    }

    @Test
    void mergeKLists2() {
        var res = solution.mergeKLists(new ListNode[]{});

        assertNull(res);
    }

    @Test
    void mergeKLists3() {
        var res = solution.mergeKLists(new ListNode[]{null});

        assertNull(res);
    }

    @Test
    void mergeKLists4() {
        var res = solution.mergeKLists(new ListNode[]{generate(-10_000, 0, 10_000), generate(-10_000, 0, 10_000), generate(-10_000, 0, 10_000)});

        assertEquals(generate(-10_000, -10_000, -10_000, 0, 0, 0, 10_000, 10_000, 10_000), res);
    }

    @Test
    void mergeKLists5() { // [],[-1,5,11],[],[6,10]
        var res = solution.mergeKLists(new ListNode[]{null, generate(-1,5,11), null, generate(6, 10)});

        assertEquals(generate(-1, 5, 6, 10, 11), res);
    }

    @Test
    void mergeKLists6() {
        var res = solution.mergeKLists(new ListNode[]{generate(1), generate(2), generate(3), generate(4)});

        assertEquals(generate(1, 2, 3, 4), res);
    }


    private ListNode generate(int... vals) {
        var tail = new ListNode(vals[vals.length - 1]);

        for (int i = vals.length - 2; i > -1; i--) {
            tail = new ListNode(vals[i], tail);
        }

        return tail;
    }
}
