package org.lllbllllb.problems.binarytreepaths;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void binaryTreePaths1() {
        var tree = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        var res = solution.binaryTreePaths(tree);

        assertEquals(List.of("1->2->5", "1->3"), res);
    }

    @Test
    void binaryTreePaths2() {
        var tree = new TreeNode(1);
        var res = solution.binaryTreePaths(tree);

        assertEquals(List.of("1"), res);
    }
}
