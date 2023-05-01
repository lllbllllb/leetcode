package org.lllbllllb.problems.binarytreelevelordertraversal;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.lllbllllb.domain.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void levelOrder1() {
        var res = solution.levelOrder(TreeNode.of(3, 9, 20, null, null, 15, 7));

        assertThat(res).containsExactly(List.of(3), List.of(9, 20), List.of(15, 7));
    }

    @Test
    void levelOrder2() {
        var res = solution.levelOrder(TreeNode.of(1));

        assertThat(res).containsExactly(List.of(1));
    }

    @Test
    void levelOrder3() {
        var res = solution.levelOrder(TreeNode.of());

        assertThat(res).containsExactly();
    }

    @Test
    void levelOrder4() {
        var res = solution.levelOrder(TreeNode.of(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5));

        assertThat(res).containsExactly(List.of(6), List.of(2, 8), List.of(0, 4, 7, 9), List.of(3, 5));
    }

    @Test
    void levelOrder5() {
        var res = solution.levelOrder(TreeNode.of(1, 2, null, 3, null, 4, null, 5));

        assertThat(res).containsExactly(List.of(1), List.of(2), List.of(3), List.of(4), List.of(5));
    }
}
