package org.lllbllllb.problems.linkedlistcycle;

import java.util.HashSet;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle/">141. Linked List Cycle</a>
 * Definition for singly-linked list.
 * <pre>
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * </pre>
 */
public class Solution {

    // 0 ms, 43.6 MB
    public boolean hasCycle(ListNode head) {
        var fast = head;

        while (fast != null && fast.next != null) {
            if (fast.next == head) {
                return true;
            }

            head = head.next;
            fast = fast.next.next;
        }

        return false;
    }

    // 0 ms, 43.8 MB
    public boolean hasCycle1(ListNode head) {
        while (head != null) {

            if (head.val == Integer.MIN_VALUE) {
                return true;
            }

            head.val = Integer.MIN_VALUE;
            head = head.next;
        }

        return false;
    }

    // 4 ms, 42.8 MB
    public boolean hasCycle2(ListNode head) {
        var checked = new HashSet<ListNode>();

        while (head != null) {
            checked.add(head);

            if (checked.contains(head.next)) {
                return true;
            }

            head = head.next;
        }

        return false;
    }
}
