package org.lllbllllb.problems.binarytreelevelordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.lllbllllb.domain.TreeNode;

/**
 * <a href="https://leetcode.com/problems/binary-tree-level-order-traversal/">102. Binary Tree Level Order Traversal</a>
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

    // 0 ms, 42.9 MB
    public List<List<Integer>> levelOrder(TreeNode root) {
        var res = new ArrayList<List<Integer>>();

        if (root != null) {
            var queue = new LinkedList<TreeNode>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                var levelLen = queue.size();
                var level = new ArrayList<Integer>(levelLen);

                for (int i = 0; i < levelLen; i++) {
                    var node = queue.poll();
                    level.add(node.val);

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }

                res.add(level);
            }
        }

        return res;
    }

    // 1 ms, 43.2 MB
    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        var res = new ArrayList<List<Integer>>();
        var queue = new LinkedList<TreeNode>();
        var nextLevel = new LinkedList<TreeNode>();
        var level = new ArrayList<Integer>();
        queue.add(root);

        while (!queue.isEmpty()) {
            var node = queue.poll();
            level.add(node.val);

            if (node.left != null) {
                nextLevel.offer(node.left);
            }

            if (node.right != null) {
                nextLevel.offer(node.right);
            }

            if (queue.isEmpty()) {
                res.add(level);
                level = new ArrayList<>();
                queue = nextLevel;
                nextLevel = new LinkedList<>();
            }

        }

        return res;
    }
}
