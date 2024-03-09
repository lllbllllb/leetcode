package org.lllbllllb.leetcode.problems.narytreepreordertraversal;

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
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/n-ary-tree-preorder-traversal/">589. N-ary Tree Preorder Traversal</a>
 */
class Solution {

    public List<Integer> preorder(Node root) {
        var preorder = new ArrayList<Integer>();

        if (root == null) {
            return preorder;
        }

        dfs(root, preorder);

        return preorder;
    }

    private void dfs(Node node, List<Integer> preorder) {
        preorder.add(node.val);

        for (var child : node.children) {
            dfs(child, preorder);
        }
    }
}
