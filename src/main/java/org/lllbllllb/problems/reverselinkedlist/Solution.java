package org.lllbllllb.problems.reverselinkedlist;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">206. Reverse Linked List</a>
 * <br>
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

    // iterative
    public ListNode reverseList1(ListNode head) {
        if (head == null) {
            return null;
        }

        var reversed = head;
        var next = head.next;

        if (next == null) {
            return head;
        }

        reversed.next = null;

        while (next != null) {
            var nextNext = next.next;
            next.next = reversed;
            reversed = next;
            next = nextNext;

        }

        return reversed;
    }

    // recursive
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode curr, ListNode next) {
        if (next == null) {
            return curr;
        }

        var nextNext = next.next;
        next.next = curr;

        return reverse(next, nextNext);
    }

}
