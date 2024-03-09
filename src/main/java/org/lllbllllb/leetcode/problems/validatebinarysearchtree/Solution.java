package org.lllbllllb.leetcode.problems.validatebinarysearchtree;

import org.lllbllllb.leetcode.domain.TreeNode;

/**
 * <a href="https://leetcode.com/problems/validate-binary-search-tree/">98. Validate Binary Search Tree</a>
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

    public boolean isValidBST(TreeNode root) {
        return isValidBSTInorder(root, new Integer[1]);
    }

    // Inorder means, that in valid BST each element must be less, than next by order
    public boolean isValidBSTInorder(TreeNode node, Integer[] prevObserver) {
        if (node == null) {
            return true;
        }

        var left = isValidBSTInorder(node.left, prevObserver);

        if (prevObserver[0] != null && node.val <= prevObserver[0]) {
            return false;
        }

        prevObserver[0] = node.val;

        var right = isValidBSTInorder(node.right, prevObserver);

        return left && right;
    }

    public boolean isValidBST1(TreeNode root) {
        return isValidBSTBoundaries(root, null, null);
    }

    public boolean isValidBSTBoundaries(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }


        var currInvalid = (min != null && node.val <= min) || (max != null && node.val >= max);

        if (currInvalid) {
            return false;
        }

        var left = isValidBSTBoundaries(node.left, min, node.val);
        var right = isValidBSTBoundaries(node.right, node.val, max);

        return left && right;
    }
}
