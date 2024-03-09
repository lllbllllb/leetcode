package org.lllbllllb.leetcode.problems.mergetwosortedlists;

/**
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
 *
 * <a href="https://leetcode.com/problems/merge-two-sorted-lists/">21. Merge Two Sorted Lists</a>
 */
class Solution {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            var next = list1.next;

            list1.next = mergeTwoLists(next, list2);

            return list1;
        } else {
            var next = list2.next;

            list2.next = mergeTwoLists(list1, next);

            return list2;
        }
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        var res = new ListNode();
        var tail = res;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }

            tail = tail.next;
        }

        tail.next = list1 != null ? list1 : list2;

        return res.next;
    }

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        var res = list1.val < list2.val ? list1 : list2;
        var tail = res;
        var cursor1 = list1 == res ? list1.next : list1;
        var cursor2 = list2 == res ? list2.next : list2;

        while (cursor1 != null && cursor2 != null) {
            if (cursor1.val < cursor2.val) {
                tail.next = cursor1;
                tail = cursor1;
                cursor1 = cursor1.next;
            } else {
                tail.next = cursor2;
                tail = cursor2;
                cursor2 = cursor2.next;
            }
        }

        tail.next = cursor1 != null ? cursor1 : cursor2;

        return res;
    }
}
