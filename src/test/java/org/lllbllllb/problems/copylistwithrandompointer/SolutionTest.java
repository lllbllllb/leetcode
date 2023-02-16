package org.lllbllllb.problems.copylistwithrandompointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void copyRandomList1() {
        var node = generate(new Integer[][]{{7, null}, {13, 0}, {11, 4}, {10, 2}, {1, 0}});
        var res = solution.copyRandomList(node);

        assertEquals(node, res);
    }

    private Node generate(Integer[]... vals) {
        var len = vals.length;
        var nodes = new Node[len];

        for (int i = 0; i < len; i++) {
            var node = new Node(vals[i][0]);
            nodes[i] = node;
        }

        for (int i = 0; i < len; i++) {
            var currNode = nodes[i];

            if (i != len - 1) {
                currNode.next = nodes[i + 1];
            }

            var randomNodeNum = vals[i][1];

            if (randomNodeNum != null) {
                currNode.random = nodes[randomNodeNum];
            }
        }

        return nodes[0];
    }
}
