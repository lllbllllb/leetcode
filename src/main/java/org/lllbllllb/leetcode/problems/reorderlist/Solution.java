package org.lllbllllb.leetcode.problems.reorderlist;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/reorder-list/">143. Reorder List</a>
 * <pre>
 * Definition for singly-linked list.
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

    // 1 ms, 45.3 MB
    public void reorderList(ListNode head) {
        var leftHalfEnd = head;
        var last = head.next;

        while (last != null && last.next != null) {
            leftHalfEnd = leftHalfEnd.next;
            last = last.next.next;
        }

        var straightWay = head;
        var middleNext = leftHalfEnd.next;
        leftHalfEnd.next = null;
        var reversedRightHalf = reverse(null, middleNext);

        while (reversedRightHalf != null) {
            var straightNext = straightWay.next;
            var reversedNext = reversedRightHalf.next;
            straightWay.next = reversedRightHalf;
            reversedRightHalf.next = straightNext;
            straightWay = straightNext;
            reversedRightHalf = reversedNext;
        }
    }

    private ListNode reverse(ListNode curr, ListNode next) {
        if (next == null) {
            return curr;
        }

        var nextNext = next.next;
        next.next = curr;

        return reverse(next, nextNext);
    }

    // 2 ms, 44.4 MB
    public void reorderList1(ListNode head) {
        var order = new ArrayList<ListNode>();
        var tmp = head;

        while (tmp != null) {
            order.add(tmp);
            tmp = tmp.next;
        }

        var size = order.size();

        for (int i = 0; i < size / 2; i++) {
            var curr = order.get(i);
            var next = order.get(size - 1 - i);
            var currNext = curr.next;
            curr.next = next;
            next.next = currNext;
        }

        order.get(size / 2).next = null;
    }

    // 1 ms, 45.2 MB
    public void reorderList2(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        var middle = head;
        var last = head;

        while (last.next != null) {
            middle = middle.next;

            if (last.next.next == null) {
                last = last.next;
            } else {
                last = last.next.next;
            }
        }

        middle = reverse(null, middle);
        var tmp = head;

        while (middle != null) {
            var headNext = tmp.next;
            var midNext = middle.next;
            tmp.next = middle;
            middle.next = headNext;
            tmp = headNext;
            middle = midNext;
        }

        if (tmp != null) {
            tmp.next = null;
        }
    }
}
