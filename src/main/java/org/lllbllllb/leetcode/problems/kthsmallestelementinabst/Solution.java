package org.lllbllllb.leetcode.problems.kthsmallestelementinabst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.lllbllllb.leetcode.domain.TreeNode;

/**
 * <a href="https://leetcode.com/problems/kth-smallest-element-in-a-bst/">230. Kth Smallest Element in a BST</a>
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

    // 1 ms, 43 MB
    public int kthSmallest(TreeNode root, int k) {
        var res = new ArrayList<Integer>();

        inOrder(root, k, res);

        return res.get(k - 1);
    }

    private void inOrder(TreeNode node, int k, List<Integer> vals) {
        if (node == null) {
            return;
        }

        inOrder(node.left, k, vals);

        vals.add(node.val);

        if (vals.size() == k) {
            return;
        }

        inOrder(node.right, k, vals);
    }

    // 16 ms, 42.7 MB
    public int kthSmallest1(TreeNode root, int k) {
        var stack = new LinkedList<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            var node = stack.peekFirst();

            if (node.left != null) {
                var left = node.left;
                node.left = null;
                stack.push(left);
            } else {
                k--;
                var min = stack.pop();

                System.out.println(min.val + " - " + k);

                if (k == 0) {
                    return min.val;
                }

                if (node.right != null) {
                    stack.push(min.right);
                }
            }
        }

        return -1;
    }

    private int tmp;

    // 0 ms, 42.2 MB
    public int kthSmallest2(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        var left = kthSmallest2(root.left, k);

        tmp++;

        if (k == tmp) {
            return root.val;
        }

        var right = kthSmallest2(root.right, k);

        return Math.max(left, right);
    }

}
