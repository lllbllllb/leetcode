package org.lllbllllb.leetcode.problems.addtwonumbers;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/description/">2. Add Two Numbers</a>
 */
// 2 ms, 42.5 MB
class Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var headIsNext = new ListNode();
        var tmp = headIsNext;
        var mem = 0;

        while (l1 != null || l2 != null || mem == 1) {
            var val1 = 0;
            var val2 = 0;

            if (l1 != null && l2 != null) {
                val1 = l1.val;
                val2 = l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                val1 = l1.val;
                l1 = l1.next;
            } else if (l2 != null) {
                val2 = l2.val;
                l2 = l2.next;
            }

            var sum = val1 + val2 + mem;
            mem = 0;
            var node = new ListNode();

            if (sum > 9) {
                mem = 1;
                node.val = sum - 10;
            } else {
                node.val = sum;
            }

            tmp.next = node;
            tmp = tmp.next;
        }

        return headIsNext.next;
    }
}

// 2 ms, 42.6 MB
class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        var debt = 0;
        ListNode resHead = null;
        ListNode resLast = null;

        while (true) {
            if (debt == 0 && l1 == null && l2 == null) {
                return resHead;
            }

            var next = new ListNode();
            var l1Val = l1 != null ? l1.val : 0;
            var l2Val = l2 != null ? l2.val : 0;
            var resVal = l1Val + l2Val + debt;

            next.val = resVal % 10;
            if (resHead == null) {
                resHead = next;
                resLast = next;
            } else {
                resLast.next = next;
                resLast = next;
            }

            debt = resVal / 10;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
    }
}