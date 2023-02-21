package org.lllbllllb.domain.model;


import org.lllbllllb.domain.TreeNode;

public class TreeNodeGenerator {

    public static TreeNode generateBinaryTree(Integer... vals) {
        return generateBinaryTree(0, vals);
    }

    private static TreeNode generateBinaryTree(int cursor, Integer[] vals) {
        if (cursor >= vals.length) {
            return null;
        }

        var val = vals[cursor];

        if (val == null) {
            return null;
        }

        var left = generateBinaryTree(cursor * 2 + 1, vals);
        var right = generateBinaryTree(cursor * 2 + 2, vals);

        return new TreeNode(val, left, right);
    }
}
