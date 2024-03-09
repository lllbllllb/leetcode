package org.lllbllllb.leetcode.problems.serializeanddeserializebinarytree;

import java.util.LinkedList;

import org.lllbllllb.leetcode.domain.TreeNode;

/**
 * <a href="https://leetcode.com/problems/serialize-and-deserialize-binary-tree/">297. Serialize and Deserialize Binary Tree</a>
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
class Codec {

    private static final char COMMA = ',';

    private static final char NULL = 'n';

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        var res = new StringBuilder();
        var queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            var node = queue.poll();

            if (node != null) {
                res.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                res.append(NULL);
            }

            res.append(COMMA);
        }

        System.out.println(res);

        return res.toString();
    }

    // 15 ms, 43.7 MB
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        var nodeValues = new LinkedList<Integer>();
        var from = 0;

        while (from != data.length()) {
            var to = data.indexOf(COMMA, from);

            if (data.charAt(from) != NULL) {
                var nodeVal = Integer.parseInt(data, from, to, 10);
                nodeValues.offer(nodeVal);
            } else {
                nodeValues.offer(null);
            }

            from = to + 1;
        }

        var rootVal = nodeValues.poll();

        if (rootVal == null) {
            return null;
        }

        var queue = new LinkedList<TreeNode>();
        var root = new TreeNode(rootVal);
        queue.offer(root);

        while (!queue.isEmpty()) {
            var node = queue.poll();
            var leftVal = nodeValues.poll();

            if (leftVal != null) {
                var leftNode = new TreeNode(leftVal);
                node.left = leftNode;
                queue.offer(leftNode);
            }

            var rightVal = nodeValues.poll();

            if (rightVal != null) {
                var rightNode = new TreeNode(rightVal);
                node.right = rightNode;
                queue.offer(rightNode);
            }
        }

        return root;
    }

    // 15 ms, 43.7 MB
    // 16 ms, 43.6 MB
    // Decodes your encoded data to tree.
    public TreeNode deserialize1(String data) {
        var head = (TreeNode) null;
        var queue = new LinkedList<TreeNode>();
        var from = 0;
        var left = false;

        while (from != data.length()) {
            var nodeVal = (Integer) null;
            var to = data.indexOf(COMMA, from);

            if (data.charAt(from) != NULL) {
                nodeVal = Integer.parseInt(data, from, to, 10);

                if (head == null) {
                    var newNode = new TreeNode(nodeVal);
                    head = newNode;
                    queue.offer(newNode);

                    from = to + 1;

                    continue;
                }
            }

            from = to + 1;

            if (head == null || queue.isEmpty()) {
                return head;
            }

            var node = queue.peekFirst();

            if (nodeVal != null) {
                var newNode = new TreeNode(nodeVal);

                if (!left) {
                    node.left = newNode;
                } else {
                    node.right = newNode;
                }

                queue.offer(newNode);
            }

            if (!left) {
                left = true;
            } else {
                left = false;
                queue.poll();
            }
        }

        return head;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
