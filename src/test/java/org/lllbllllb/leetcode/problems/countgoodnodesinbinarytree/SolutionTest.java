package org.lllbllllb.leetcode.problems.countgoodnodesinbinarytree;

import org.junit.jupiter.api.Test;
import org.lllbllllb.leetcode.domain.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void goodNodes1() {
        var res = solution.goodNodes(TreeNode.of(3, 1, 4, 3, null, 1, 5));

        assertEquals(4, res);
    }

    @Test
    void goodNodes2() {
        var res = solution.goodNodes(TreeNode.of(3, 3, null, 4, 2));

        assertEquals(3, res);
    }

    @Test
    void goodNodes3() {
        var res = solution.goodNodes(TreeNode.of(1));

        assertEquals(1, res);
    }
}
