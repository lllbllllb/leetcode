package org.lllbllllb.problems.constructbinarytreefrompreorderandinordertraversal;

import java.util.HashMap;
import java.util.Map;

import org.lllbllllb.domain.TreeNode;

/**
 * <a href="https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/">105. Construct Binary Tree from Preorder and Inorder Traversal</a>
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var valToIdxMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < inorder.length; i++) {
            valToIdxMap.put(inorder[i], i);
        }

        return buildTree(preorder, valToIdxMap, new int[1], 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, Map<Integer, Integer> valToIdxMap, int[] preCursorContainer, int inFrom, int inTo) {
        if (inFrom > inTo) {
            return null;
        }

        var preCursor = preCursorContainer[0]++;
        var nodeVal = preorder[preCursor];
        var nodeIdx = valToIdxMap.get(nodeVal);
        var node = new TreeNode(nodeVal);

        node.left = buildTree(preorder, valToIdxMap, preCursorContainer, inFrom, nodeIdx - 1);
        node.right = buildTree(preorder, valToIdxMap, preCursorContainer, nodeIdx + 1, inTo);

        return node;
    }
}
