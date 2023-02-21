package org.lllbllllb.domain.model;


import org.lllbllllb.domain.ListNode;

public class ListNodeGenerator {

    public static ListNode generateLinkedList(int... vals) {
        var tail = new ListNode(vals[vals.length - 1]);

        for (int i = vals.length - 2; i > -1; i--) {
            tail = new ListNode(vals[i], tail);
        }

        return tail;
    }
}
