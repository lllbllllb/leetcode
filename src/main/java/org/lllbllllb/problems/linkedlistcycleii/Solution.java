package org.lllbllllb.problems.linkedlistcycleii;

import java.util.HashSet;

import org.lllbllllb.domain.ListNode;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle-ii">142. Linked List Cycle II</a>
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
class Solution {

    // 0 ms, 43.9 MB
    public ListNode detectCycle(ListNode head) {
        var fast = head;
        var slow = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;

            if (fast != null) {
                fast = fast.next;
            }

            if (fast == slow) {
                break;
            }
        }

        if (fast == null) {
            return null;
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    // 3 ms, 43.7 MB
    public ListNode detectCycle1(ListNode head) {
        var visited = new HashSet<ListNode>();
        var node = head;

        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }

            visited.add(node);
            node = node.next;
        }

        return null;
    }
}
