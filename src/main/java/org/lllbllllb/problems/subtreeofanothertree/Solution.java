package org.lllbllllb.problems.subtreeofanothertree;

import org.lllbllllb.domain.TreeNode;

/**
 * <a href="https://leetcode.com/problems/subtree-of-another-tree/">572. Subtree of Another Tree</a>
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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (isSameDfs(root, subRoot)) {
            return true;
        }

        var left = isSubtree(root.left, subRoot);
        var right = isSubtree(root.right, subRoot);

        return left || right;
    }

    public boolean isSameDfs(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.val != subRoot.val) {
            return false;
        }

        var left = isSameDfs(root.left, subRoot.left);
        var right = isSameDfs(root.right, subRoot.right);

        return left && right;
    }
}
