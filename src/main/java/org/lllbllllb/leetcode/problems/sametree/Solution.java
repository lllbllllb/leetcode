package org.lllbllllb.leetcode.problems.sametree;

import org.lllbllllb.leetcode.domain.TreeNode;

/**
 * <a href="https://leetcode.com/problems/same-tree/">100. Same Tree</a>
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        var left = isSameTree(p.left, q.left);
        var right = isSameTree(p.right, q.right);

        return left && right;
    }
}
