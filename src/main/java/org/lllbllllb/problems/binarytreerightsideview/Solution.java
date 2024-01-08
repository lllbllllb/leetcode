package org.lllbllllb.problems.binarytreerightsideview;

import org.lllbllllb.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/binary-tree-right-side-view/">199. Binary Tree Right Side View</a>
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
// 0 ms, 40.7 MB
class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        var res = new ArrayList<Integer>();

        rightSideView(root, res, 0);

        return res;
    }

    private void rightSideView(TreeNode node, List<Integer> result, int level) {
        if (node == null) {
            return;
        }

        if (level == result.size()) {
            result.add(node.val);
        }

        rightSideView(node.right, result, level + 1);
        rightSideView(node.left, result, level + 1);
    }

}

// 1 ms, 40.7 MB
class Solution1 {

    public List<Integer> rightSideView(TreeNode root) {
        var res = new ArrayList<Integer>();

        if (root != null) {
            var queue = new LinkedList<TreeNode>();
            queue.add(root);

            while (!queue.isEmpty()) {
                var levelLen = queue.size();
                res.add(queue.peekLast().val);

                for (int i = 0; i < levelLen; i++) {
                    var node = queue.poll();

                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
        }

        return res;
    }
}