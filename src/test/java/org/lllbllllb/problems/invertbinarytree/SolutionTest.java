package org.lllbllllb.problems.invertbinarytree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.lllbllllb.domain.model.TreeNodeGenerator.generateBinaryTree;


class SolutionTest {

    Solution solution = new Solution();

    @Test
    void invertTree1() {
        var res = solution.invertTree(generateBinaryTree(4, 2, 7, 1, 3, 6, 9));

        assertEquals(generateBinaryTree(4, 7, 2, 9, 6, 3, 1), res);
    }

    @Test
    void invertTree2() {
        var res = solution.invertTree(generateBinaryTree(2, 1, 3));

        assertEquals(generateBinaryTree(2, 3, 1), res);
    }
}
