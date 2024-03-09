package org.lllbllllb.leetcode.problems.narytreelevelordertraversal;

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/n-ary-tree-level-order-traversal/">429. N-ary Tree Level Order Traversal</a>
 */
// 1 ms, 43.7 MB
class Solution {

    public List<List<Integer>> levelOrder(Node root) {
        var levelOrderTraversal = new ArrayList<List<Integer>>();

        if (root == null) {
            return levelOrderTraversal;
        }

        dfs(root, 0, levelOrderTraversal);

        return levelOrderTraversal;
    }

    private void dfs(Node node, int level, List<List<Integer>> levelOrderTraversal) {
        if (level == levelOrderTraversal.size()) {
            levelOrderTraversal.add(new ArrayList<>());
        }

        levelOrderTraversal.get(level).add(node.val);

        for (var child : node.children) {
            dfs(child, level + 1, levelOrderTraversal);
        }
    }

}

// 3 ms, 43.6 MB
class Solution1 {

    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return List.of();
        }

        var levelOrderTraversal = new ArrayList<List<Integer>>();
        var queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var levelSize = queue.size();
            var levelTraversal = new ArrayList<Integer>();

            for (int i = 0; i < levelSize; i++) {
                var node = queue.poll();
                levelTraversal.add(node.val);

                for (var child : node.children) {
                    queue.offer(child);
                }
            }

            levelOrderTraversal.add(levelTraversal);
        }

        return levelOrderTraversal;
    }
}
