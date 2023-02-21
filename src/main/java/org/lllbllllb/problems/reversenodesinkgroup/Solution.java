package org.lllbllllb.problems.reversenodesinkgroup;

/**
 * <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">25. Reverse Nodes in k-Group</a>
 * Definition for singly-linked list.
 * <pre>
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * </pre>
 */
class Solution {

    // 0 ms, 42.0 MB
    public ListNode reverseKGroup(ListNode head, int k) {
        return reverseKGroup(null, head, head, k, k);
    }

    private ListNode reverseKGroup(ListNode l1, ListNode l2, ListNode reversedTail /* ex head */, int cursor, int groupSize) {
        if (cursor == 0) {
            var sample = l1;
            var tmp = l2;

            while (sample != null) {
                if (tmp == null) { // means that rest of list is less than k and can't be reverse
                    reversedTail.next = l2;

                    return l1;
                }

                sample = sample.next;
                tmp = tmp.next;
            }

            reversedTail.next = reverseKGroup(null, l2, l2, groupSize, groupSize);

            return l1;
        }

        var l2Next = l2.next;
        l2.next = l1;

        return reverseKGroup(l2, l2Next, reversedTail, cursor - 1, groupSize);
    }

    // 0 ms, 42.6 MB
    public ListNode reverseKGroup1(ListNode head, int k) {
        var result = (ListNode) null;
        var reversedTail = new ListNode();
        var curr = head;
        var tmp = head;
        var count = k;

        while (true) {
            if (count == 0) {
                count = k;
                var reversedGroup = reverseGroup(null, curr, k);

                if (result == null) {
                    result = reversedGroup;
                }

                reversedTail.next = reversedGroup;


                while (reversedGroup.next != null) {
                    reversedGroup = reversedGroup.next;
                }

                reversedTail = reversedGroup;
                curr = tmp;

                if (tmp == null) {
                    return result;
                }
            } else {
                if (tmp == null) {
                    reversedTail.next = curr;

                    return result;
                }

                count--;
                tmp = tmp.next;
            }
        }
    }

    private ListNode reverseGroup(ListNode l1, ListNode l2, int groupSize) {
        if (groupSize == 0) {
            return l1;
        }

        var l2Next = l2.next;
        l2.next = l1;

        return reverseGroup(l2, l2Next, groupSize - 1);
    }

}
