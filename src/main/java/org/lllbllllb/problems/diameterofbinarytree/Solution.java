package org.lllbllllb.problems.diameterofbinarytree;

import org.lllbllllb.domain.TreeNode;

/**
 * <a href="https://leetcode.com/problems/diameter-of-binary-tree/">543. Diameter of Binary Tree</a>
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

    public int diameterOfBinaryTree(TreeNode root) {
        var observer = new int[1];

        dfs(root, observer);

        return observer[0];
    }

    private int dfs(TreeNode node, int[] observer) {
        if (node == null) {
            return 0;
        }

        var left = dfs(node.left, observer);
        var right = dfs(node.right, observer);
        var currDiameter = left + right;

        observer[0] = Math.max(observer[0], currDiameter);

        return 1 + Math.max(left, right);
    }
}
