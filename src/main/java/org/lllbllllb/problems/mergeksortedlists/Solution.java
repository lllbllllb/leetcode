package org.lllbllllb.problems.mergeksortedlists;

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
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/">23. Merge k Sorted Lists</a>
 */
class Solution {

    // 7ms
    public ListNode mergeKLists(ListNode[] lists) {
        var shift = 10_000;
        var len = 20_001;
        var counter = new int[len];

        for (var list : lists) {
            var tmp = list;

            while (tmp != null) {
                var idx = tmp.val + shift;

                counter[idx] = counter[idx] + 1;
                tmp = tmp.next;
            }
        }

        ListNode head = null;

        for (int i = counter.length - 1; i > -1; i--) {
            for (int j = 0; j < counter[i]; j++) {
                head = new ListNode(i - shift, head);
            }
        }

        return head;
    }

    // 110 ms
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null ||lists.length == 0) {
            return null;
        }

        for (int i = 1; i < lists.length; i++) {
            lists[0] = mergeTwoLists(lists[0], lists[i]);
        }

        return lists[0];
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
