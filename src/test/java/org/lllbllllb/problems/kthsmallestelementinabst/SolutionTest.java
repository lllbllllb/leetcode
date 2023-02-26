package org.lllbllllb.problems.kthsmallestelementinabst;

import org.junit.jupiter.api.Test;
import org.lllbllllb.domain.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void kthSmallest1() {
        var res = solution.kthSmallest(TreeNode.of(3, 1, 4, null, 2), 1);

        assertEquals(1, res);
    }

    @Test
    void kthSmallest2() {
        var res = solution.kthSmallest(TreeNode.of(5, 3, 6, 2, 4, null, null, 1), 3);

        assertEquals(3, res);
    }

    @Test
    void kthSmallest3() {
        var res = solution.kthSmallest(TreeNode.of(1,null,2), 2);

        assertEquals(2, res);
    }
}
