package org.lllbllllb.problems.countgoodnodesinbinarytree;

import org.lllbllllb.domain.TreeNode;

/**
 * <a href="https://leetcode.com/problems/count-good-nodes-in-binary-tree/">1448. Count Good Nodes in Binary Tree</a>
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

    // 2 ms, 51.1 MB
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    public int goodNodes(TreeNode node, int maxVal) {
        if (node == null) {
            return 0;
        }

        var count = 0;

        if (node.val >= maxVal) {
            count++;
            maxVal = node.val;
        }

        var left = goodNodes(node.left, maxVal);
        var right = goodNodes(node.right, maxVal);

        return count + left + right;
    }

}
