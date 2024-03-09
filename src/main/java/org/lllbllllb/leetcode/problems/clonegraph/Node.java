package org.lllbllllb.leetcode.problems.clonegraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

class Node {

    public int val;

    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

    public static Node of(int[][] node) {
        var valToNodeMap = new HashMap<Integer, Node>();

        for (int i = 0; i < node.length; i++) {
            var val = i + 1;
            var currNode = valToNodeMap.computeIfAbsent(val, Node::new);

            for (var neighbor : node[i]) {
                var nNode = valToNodeMap.computeIfAbsent(neighbor, Node::new);
                currNode.neighbors.add(nNode);
            }
        }

        return valToNodeMap.get(1);
    }
}
