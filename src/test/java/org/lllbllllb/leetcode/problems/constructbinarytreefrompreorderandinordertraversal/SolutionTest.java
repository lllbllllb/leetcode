package org.lllbllllb.leetcode.problems.constructbinarytreefrompreorderandinordertraversal;

import org.junit.jupiter.api.Test;
import org.lllbllllb.leetcode.domain.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void buildTree1() {
        var res = solution.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});

        assertEquals(TreeNode.of(3, 9, 20, null, null, 15, 7), res);
    }

    @Test
    void buildTree2() {
        var res = solution.buildTree(new int[]{-1}, new int[]{-1});

        assertEquals(TreeNode.of(-1), res);
    }

    @Test
    void buildTree3() {
        var res = solution.buildTree(new int[]{1, 2}, new int[]{1, 2});

        assertEquals(TreeNode.of(1, null, 2), res);
    }
}
