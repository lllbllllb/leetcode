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

    // 2 ms, 44 MB
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return mergeSort(lists, 0, lists.length);
    }

    private ListNode mergeSort(ListNode[] lists, int from, int to) {
        var len = to - from;

        if (len == 0) {
            return null;
        } else if (len == 1) {
            return lists[from];
        }

        var l1 = mergeSort(lists, from, from + len / 2);
        var l2 = mergeSort(lists, from + len / 2, to);

        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }

        if (l1 == null) {
            return l2;
        }

        if (l1.val < l2.val) {
            var l1Next = l1.next;

            l1.next = merge(l1Next, l2);

            return l1;
        } else {
            var l2Next = l2.next;

            l2.next = merge(l1, l2Next);

            return l2;
        }
    }

    // 3 ms, 43.9 MB
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        var len = lists.length;
        var interval = 1;

        while (interval < len) {
            for (int i = 0; i < (len - interval); i += 2 * interval) {
                lists[i] = merge(lists[i], lists[i + interval]);
            }

            interval *= 2;
        }

        return lists[0];
    }

    // 242 ms, 44.4 MB
    public ListNode mergeKLists4(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        var base = lists[0];
        var from = 1;

        if (base == null) {
            for (int i = 0; i < lists.length; i++) {
                var listNode = lists[i];

                if (listNode != null) {
                    base = listNode;
                    from = i + 1;
                    break;
                }
            }
        }

        for (int i = from; i < lists.length; i++) {
            var l2 = lists[i];

            base = merge(base, l2);
        }

        return base;
    }

    // 7ms
    public ListNode mergeKLists2(ListNode[] lists) {
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
    public ListNode mergeKLists3(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        for (int i = 1; i < lists.length; i++) {
            lists[0] = merge(lists[0], lists[i]);
        }

        return lists[0];
    }

}
