package org.lllbllllb.problems.lowestcommonancestorofabinarysearchtree;

import org.junit.jupiter.api.Test;
import org.lllbllllb.domain.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.lllbllllb.domain.TreeNode;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void lowestCommonAncestor1() {
        var tree = TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        var p = getSubTree(tree, 2);
        var q = getSubTree(tree, 8);
        var res = solution.lowestCommonAncestor(tree, p, q);

        assertEquals(getSubTree(tree, 6), res);
    }

    @Test
    void lowestCommonAncestor2() {
        var tree = TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        var p = getSubTree(tree, 2);
        var q = getSubTree(tree, 4);
        var res = solution.lowestCommonAncestor(tree, p, q);

        assertEquals(getSubTree(tree, 2), res);
    }

    @Test
    void lowestCommonAncestor3() {
        var tree = TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        var p = getSubTree(tree, 3);
        var q = getSubTree(tree, 5);
        var res = solution.lowestCommonAncestor(tree, p, q);

        assertEquals(getSubTree(tree, 4), res);
    }

    @Test
    void lowestCommonAncestor4() {
        var tree = TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5);
        var p = getSubTree(tree, 4);
        var q = getSubTree(tree, 4);
        var res = solution.lowestCommonAncestor(tree, p, q);

        assertEquals(getSubTree(tree, 4), res);
    }

    private TreeNode getSubTree(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        var left = getSubTree(root.left, val);

        if (left != null) {
            return left;
        }

        return getSubTree(root.right, val);
    }
}
