package org.lllbllllb.leetcode.problems.copylistwithrandompointer;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/copy-list-with-random-pointer/">138. Copy List with Random Pointer</a>
 * Definition for a Node.
 * <pre>
 * class Node {
 *     int val;
 *     Node next;
 *     Node random;
 *
 *     public Node(int val) {
 *         this.val = val;
 *         this.next = null;
 *         this.random = null;
 *     }
 * }
 * </pre>
 */

// 0 ms, 41.7 MB
class Solution {

    public Node copyRandomList(Node head) {
        var sourceToNewMap = new HashMap<Node, Node>();
        var tmp = head;

        while (tmp != null) {
            sourceToNewMap.put(tmp, new Node(tmp.val));
            tmp = tmp.next;
        }

        tmp = head;

        while (tmp != null) {
            sourceToNewMap.get(tmp).next = sourceToNewMap.get(tmp.next);
            sourceToNewMap.get(tmp).random = sourceToNewMap.get(tmp.random);
            tmp = tmp.next;
        }

        return sourceToNewMap.get(head);
    }

}

// 0 ms, 41.9 MB
class Solution1 {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        var sourceNodes = new ArrayList<Node>();
        var nodeToIdxMap = new HashMap<Node, Integer>();
        var idx = 0;
        var newNodes = new ArrayList<Node>();

        while (head != null) {
            sourceNodes.add(head);
            newNodes.add(new Node(head.val));
            nodeToIdxMap.put(head, idx);
            idx++;
            head = head.next;
        }

        for (int i = 0; i < sourceNodes.size(); i++) {
            var currNode = newNodes.get(i);

            if (i != sourceNodes.size() - 1) {
                currNode.next = newNodes.get(i + 1);
            }

            var randomIdx = nodeToIdxMap.get(sourceNodes.get(i).random);

            if (randomIdx != null) {
                currNode.random = newNodes.get(randomIdx);
            }
        }

        return newNodes.get(0);
    }
}