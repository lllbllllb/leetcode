package org.lllbllllb.problems.binarytreepaths;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.lllbllllb.domain.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void binaryTreePaths1() {
        var res = solution.binaryTreePaths(TreeNode.of(1, 2, 3, null, 5));

        assertEquals(List.of("1->2->5", "1->3"), res);
    }

    @Test
    void binaryTreePaths2() {
        var res = solution.binaryTreePaths(TreeNode.of(1));

        assertEquals(List.of("1"), res);
    }
}
