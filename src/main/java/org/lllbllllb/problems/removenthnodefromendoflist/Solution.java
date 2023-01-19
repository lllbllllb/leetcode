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
 * @see <a href="https://leetcode.com/problems/remove-nth-node-from-end-of-list/">19. Remove Nth Node From End of List</a>
 */
class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
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

