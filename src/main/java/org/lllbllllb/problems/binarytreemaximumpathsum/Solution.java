package org.lllbllllb.problems.binarytreemaximumpathsum;

import org.lllbllllb.domain.TreeNode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-maximum-path-sum/">124. Binary Tree Maximum Path Sum</a>
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

    private int max = -2000;

    public int maxPathSum(TreeNode node) {
        maxPath(node);

        return max;
    }

    public int maxPath(TreeNode node) {
        if (node == null) {
            return -2000;
        }

        var left = maxPath(node.left);
        var right = maxPath(node.right);

        max = Math.max(max, left);
        max = Math.max(max, right);
        max = Math.max(max, node.val);
        max = Math.max(max, node.val + left);
        max = Math.max(max, node.val + right);
        max = Math.max(max, node.val + right + left);

        var branch = Math.max(left, right);

        return Math.max(node.val, node.val + branch);
    }
}
