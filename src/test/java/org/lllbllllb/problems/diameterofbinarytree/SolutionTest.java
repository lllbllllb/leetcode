package org.lllbllllb.problems.diameterofbinarytree;

import org.junit.jupiter.api.Test;
import org.lllbllllb.domain.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void diameterOfBinaryTree1() {
        var res = solution.diameterOfBinaryTree(TreeNode.of(1, 2, 3, 4, 5));

        assertEquals(3, res);
    }

    @Test
    void diameterOfBinaryTree2() {
        var res = solution.diameterOfBinaryTree(TreeNode.of(1, 2));

        assertEquals(1, res);
    }

}
