package org.lllbllllb.problems.maximumdepthofbinarytree;

import org.junit.jupiter.api.Test;
import org.lllbllllb.domain.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxDepth1() {
        var res = solution.maxDepth(TreeNode.of(3, 9, 20, null, null, 15, 7));

        assertEquals(3, res);
    }

    @Test
    void maxDepth2() {
        var res = solution.maxDepth(TreeNode.of(1, null, 2));

        assertEquals(2, res);
    }
}
