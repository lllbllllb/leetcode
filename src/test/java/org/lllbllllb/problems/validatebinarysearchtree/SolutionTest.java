package org.lllbllllb.problems.validatebinarysearchtree;

import org.junit.jupiter.api.Test;
import org.lllbllllb.domain.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void isValidBST1() {
        var res = solution.isValidBST(TreeNode.of(2, 1, 3));

        assertTrue(res);
    }

    @Test
    void isValidBST2() {
        var res = solution.isValidBST(TreeNode.of(5, 1, 4, null, null, 3, 6));

        assertFalse(res);
    }

    @Test
    void isValidBST3() {
        var res = solution.isValidBST(TreeNode.of(5, 4, 6, null, null, 3, 7));

        assertFalse(res);
    }

    @Test
    void isValidBST4() {
        var res = solution.isValidBST(TreeNode.of(2, 1, null, 0, 3));

        assertFalse(res);
    }

    @Test
    void isValidBST5() {
        var res = solution.isValidBST(TreeNode.of(3, 1, null, 0, 2));

        assertTrue(res);
    }

    @Test
    void isValidBST6() {
        var res = solution.isValidBST(TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5));

        assertTrue(res);
    }

    @Test
    void isValidBST7() {
        var res = solution.isValidBST(TreeNode.of(2, 2, 2));

        assertFalse(res);
    }
}
