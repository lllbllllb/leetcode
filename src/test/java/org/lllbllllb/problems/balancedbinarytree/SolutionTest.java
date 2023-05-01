package org.lllbllllb.problems.balancedbinarytree;

import org.junit.jupiter.api.Test;
import org.lllbllllb.domain.TreeNode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void isBalanced1() {
        var res = solution.isBalanced(TreeNode.of(3, 9, 20, null, null, 15, 7));

        assertTrue(res);
    }

    @Test
    void isBalanced2() {
        var res = solution.isBalanced(TreeNode.of(1, 2, 2, 3, 3, null, null, 4, 4));

        assertFalse(res);
    }

    @Test
    void isBalanced3() {
        var res = solution.isBalanced(TreeNode.of(1, 2, 2, 3, null, null, 3, 4, null, null, 4));

        assertFalse(res);
    }
}
