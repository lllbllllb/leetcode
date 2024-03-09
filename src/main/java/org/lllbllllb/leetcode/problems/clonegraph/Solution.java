package org.lllbllllb.leetcode.problems.clonegraph;

/*
// Definition for a Node.
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
}
*/

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/clone-graph/">133. Clone Graph</a>
 */
class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        return dfs(node, new HashMap<>());
    }

    // 24 ms, 42.9 MB
    private Node dfs(Node originalNode, Map<Integer, Node> clonedNodes) {
        if (!clonedNodes.containsKey(originalNode.val)) {
            clonedNodes.put(originalNode.val, new Node(originalNode.val));
        }

        var clonedNode = clonedNodes.get(originalNode.val);

        for (var neighbor : originalNode.neighbors) {
            if (clonedNodes.containsKey(neighbor.val)) {
                clonedNode.neighbors.add(clonedNodes.get(neighbor.val));
            } else {
                clonedNode.neighbors.add(dfs(neighbor, clonedNodes));
            }
        }

        return clonedNode;
    }

}

// 26 ms, 42.6 MB
class Solution1 {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        return dfs(node, new HashMap<>());
    }

    private Node dfs(Node originalNode, Map<Integer, Node> clonedNodes) {
        var clonedNode = clonedNodes.computeIfAbsent(originalNode.val, Node::new);

        for (var neighbor : originalNode.neighbors) {
            if (clonedNodes.containsKey(neighbor.val)) {
                clonedNode.neighbors.add(clonedNodes.get(neighbor.val));
            } else {
                clonedNode.neighbors.add(dfs(neighbor, clonedNodes));
            }
        }

        return clonedNode;
    }
}