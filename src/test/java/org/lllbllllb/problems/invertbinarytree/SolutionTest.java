package org.lllbllllb.problems.invertbinarytree;

import org.junit.jupiter.api.Test;
import org.lllbllllb.domain.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    Solution solution = new Solution();

    @Test
    void invertTree1() {
        var res = solution.invertTree(TreeNode.of(4, 2, 7, 1, 3, 6, 9));

        assertEquals(TreeNode.of(4, 7, 2, 9, 6, 3, 1), res);
    }

    @Test
    void invertTree2() {
        var res = solution.invertTree(TreeNode.of(2, 1, 3));

        assertEquals(TreeNode.of(2, 3, 1), res);
    }
}
