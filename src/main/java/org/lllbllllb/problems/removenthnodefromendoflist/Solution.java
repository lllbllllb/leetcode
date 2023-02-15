package org.lllbllllb.problems.removenthnodefromendoflist;

/**
 * Definition for singly-linked list.
 * <pre>
 *     public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * </pre>
 *
 * <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">19. Remove Nth Node From End of List</a>
 */
class Solution {

    // 0 ms, 40.4 MB
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var fast = head;

        while (n != 0) {
            fast = fast.next;
            n--;
        }

        if (fast == null) {
            return head.next;
        }

        var slow = head;

        while (fast != null) {
            if (fast.next == null) {
                slow.next = slow.next.next;
            }

            slow = slow.next;
            fast = fast.next;
        }

        return head;
    }

    // 0 ms, 40.4 MB
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode prev = null;
        var target = head;
        var count = 1;
        var current = head;

        while (current.next != null) {
            if (count == n) {
                prev = target;
                target = target.next;
            } else {
                count++;
            }

            current = current.next;
        }

        if (prev == null) {
            return head.next;
        }

        prev.next = target.next;

        return head;
    }
}

