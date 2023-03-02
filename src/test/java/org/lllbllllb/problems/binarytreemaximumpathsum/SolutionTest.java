package org.lllbllllb.problems.binarytreemaximumpathsum;

import org.junit.jupiter.api.Test;
import org.lllbllllb.domain.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maxPathSum1() {
        var res = solution.maxPathSum(TreeNode.of(1, 2, 3));

        assertEquals(6, res);
    }

    @Test
    void maxPathSum2() {
        var res = solution.maxPathSum(TreeNode.of(-10, 9, 20, null, null, 15, 7));

        assertEquals(42, res);
    }

    @Test
    void maxPathSum3() {
        var res = solution.maxPathSum(TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5));

        assertEquals(34, res);
    }

    @Test
    void maxPathSum4() {
        var res = solution.maxPathSum(TreeNode.of(1, 2, 3, null, null, null, 4));

        assertEquals(10, res);
    }

    @Test
    void maxPathSum5() {
        var res = solution.maxPathSum(TreeNode.of(2, -1));

        assertEquals(2, res);
    }

    @Test
    void maxPathSum6() {
        var res = solution.maxPathSum(TreeNode.of(-3));

        assertEquals(-3, res);
    }
}
