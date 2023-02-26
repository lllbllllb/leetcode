package org.lllbllllb.problems.binarytreerightsideview;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import org.lllbllllb.domain.TreeNode;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void rightSideView1() {
        var res = solution.rightSideView(TreeNode.of(1, 2, 3, null, 5, null, 4));

        assertThat(res).containsExactly(1, 3, 4);
    }

    @Test
    void rightSideView2() {
        var res = solution.rightSideView(TreeNode.of(1,null,3));

        assertThat(res).containsExactly(1, 3);
    }

    @Test
    void rightSideView3() {
        var res = solution.rightSideView(TreeNode.of());

        assertThat(res).containsExactly();
    }

    @Test
    void rightSideView4() {
        var res = solution.rightSideView(TreeNode.of(1, 2));

        assertThat(res).containsExactly(1, 2);
    }

    @Test
    void rightSideView5() {
        var res = solution.rightSideView(TreeNode.of(1,2,3,4));

        assertThat(res).containsExactly(1, 3, 4);
    }
}
