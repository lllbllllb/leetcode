package org.lllbllllb.leetcode.problems.clonegraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void cloneGraph1() {
        var res = solution.cloneGraph(Node.of(new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}}));

        assertEquals(Node.of(new int[][]{{2, 4}, {1, 3}, {2, 4}, {1, 3}}), res);
    }
}
