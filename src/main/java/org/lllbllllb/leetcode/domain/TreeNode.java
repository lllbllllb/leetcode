package org.lllbllllb.leetcode.domain;

import java.util.LinkedList;
import java.util.Objects;

public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
            "val=" + val +
            ", left=" + left +
            ", right=" + right +
            '}';
    }

    public static TreeNode of(Integer... vals) {
        if (vals.length == 0) {
            return null;
        }

        var head = new TreeNode(vals[0]);
        var queue = new LinkedList<TreeNode>();
        queue.offer(head);
        var cursor = 1;

        while (!queue.isEmpty()) {
            var node = queue.poll();

            if (cursor < vals.length) {
                var leftVal = vals[cursor++];

                if (leftVal != null) {
                    var leftNode = new TreeNode(leftVal);
                    node.left = leftNode;
                    queue.offer(leftNode);
                }

            }

            if (cursor < vals.length) {
                var rightVal = vals[cursor++];

                if (rightVal != null) {
                    var rightNode = new TreeNode(rightVal);
                    node.right = rightNode;
                    queue.offer(rightNode);
                }
            }

        }

        return head;
    }
}
