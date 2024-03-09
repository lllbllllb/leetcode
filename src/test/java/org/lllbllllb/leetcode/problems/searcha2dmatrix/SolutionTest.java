package org.lllbllllb.leetcode.problems.searcha2dmatrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void searchMatrix1() {
        var res = solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3);

        assertTrue(res);
    }

    @Test
    void searchMatrix2() {
        var res = solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13);

        assertFalse(res);
    }

    @Test
    void searchMatrix3() {
        var res = solution.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 100);

        assertFalse(res);
    }

    @Test
    void searchMatrix4() {
        var res = solution.searchMatrix(new int[][]{{1, 1}}, 2);

        assertFalse(res);
    }
}
