package org.lllbllllb.problems.binarytreepaths;

import java.util.ArrayList;
import java.util.List;

/**
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
 *
 * @see <a href="https://leetcode.com/problems/binary-tree-paths/description/">257. Binary Tree Paths</a>
 */
class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        var res = new ArrayList<String>();

        backTracking(root, res, new ArrayList<>());

        return res;
    }

    private void backTracking(TreeNode node, List<String> res, List<String> tmp) {
        tmp.add(Integer.toString(node.val));

        if (node.left == null && node.right == null) {
            res.add(String.join("->", tmp));
        } else {
            if (node.left != null) {
                backTracking(node.left, res, tmp);
                tmp.remove(tmp.size() - 1);
            }

            if (node.right != null) {
                backTracking(node.right, res, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}
