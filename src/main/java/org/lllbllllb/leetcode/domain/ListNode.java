package org.lllbllllb.leetcode.domain;

import java.util.Objects;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val && Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        return "ListNode{" +
            "val=" + val +
            ", next=" + next +
            '}';
    }

    public static ListNode of(int... vals) {
        var tail = new ListNode(vals[vals.length - 1]);

        for (int i = vals.length - 2; i > -1; i--) {
            tail = new ListNode(vals[i], tail);
        }

        return tail;
    }
}
