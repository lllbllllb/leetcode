package org.lllbllllb.leetcode.problems.lowestcommonancestorofabinarysearchtree;

import org.lllbllllb.leetcode.domain.TreeNode;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">235. Lowest Common Ancestor of a Binary Search Tree</a>
 * Definition for a binary tree node.
 * <pre>
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * </pre>
 */

class Solution {

    // 5 ms, 51 MB
    public TreeNode lowestCommonAncestor(TreeNode node, TreeNode p, TreeNode q) {
        while (node != null) {
            if (node.val > p.val && node.val > q.val) {
                node = node.left;
            } else if (node.val < p.val && node.val < q.val) {
                node = node.right;
            } else {
                break;
            }
        }

        return node;
    }

    // 5 ms, 50.7 MB
    public TreeNode lowestCommonAncestor1(TreeNode node, TreeNode p, TreeNode q) {
        if (node.val > p.val && node.val > q.val) {
            return lowestCommonAncestor1(node.left, p, q);
        }

        if (node.val < p.val && node.val < q.val) {
            return lowestCommonAncestor1(node.right, p, q);
        }

        return node;
    }

    // 6 ms, 50.9 MB
    public TreeNode lowestCommonAncestor2(TreeNode node, TreeNode p, TreeNode q) {
        var observer = new TreeNode[1];

        isBothInside(node, p, q, observer);

        return observer[0];
    }

    private int isBothInside(TreeNode node, TreeNode p, TreeNode q, TreeNode[] observer) {
        if (node == null) {
            return 0;
        }

        var curr = 0;

        if (node.val == p.val) {
            curr++;
        }

        if (node.val == q.val) {
            curr++;
        }

        var left = isBothInside(node.left, p, q, observer);
        var right = isBothInside(node.right, p, q, observer);
        var sum = left + right + curr;

        if (sum == 2 && observer[0] == null) {
            observer[0] = node;
        }

        return sum;
    }
}
