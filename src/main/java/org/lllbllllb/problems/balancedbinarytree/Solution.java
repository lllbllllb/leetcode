package org.lllbllllb.problems.balancedbinarytree;

import org.lllbllllb.domain.TreeNode;

/**
 * <a href="https://leetcode.com/problems/balanced-binary-tree/">110. Balanced Binary Tree</a>
 * <br>
 * Definition for a binary tree node.
 * <pre>
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * </pre>
 */
class Solution {

    // 1 ms, 41.7 MB
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        var balancedObserver = new boolean[]{true};
        dfs(root, balancedObserver);

        return balancedObserver[0];
    }

    private int dfs(TreeNode node, boolean[] observer) {
        if (node == null || !observer[0]) {
            return 0;
        }

        var left = dfs(node.left, observer);
        var right = dfs(node.right, observer);

        if (Math.abs(left - right) > 1) {
            observer[0] = false;
        }

        return 1 + Math.max(left, right);
    }
}
