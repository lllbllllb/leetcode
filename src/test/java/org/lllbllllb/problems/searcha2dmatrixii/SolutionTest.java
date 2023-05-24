package org.lllbllllb.problems.searcha2dmatrixii;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void searchMatrix1() {
        var res = solution.searchMatrix(new int[][]{
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        }, 5);

        assertTrue(res);
    }

    @Test
    void searchMatrix2() {
        var res = solution.searchMatrix(new int[][]{
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        }, 20);

        assertFalse(res);
    }

    @Test
    void searchMatrix3() {
        var res = solution.searchMatrix(new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}}, 5);

        assertTrue(res);
    }

    @Test
    void searchMatrix4() {
        var res = solution.searchMatrix(new int[][]{{-5}}, -2);

        assertFalse(res);
    }

    @Test
    void searchMatrix5() {
        var res = solution.searchMatrix(new int[][]{{-3, -1}, {-2, 0}}, 5);

        assertFalse(res);
    }

    @Test
    void searchMatrix6() {
        var res = solution.searchMatrix(new int[][]{
            {-3, -1},
            {-2, 0}
        }, 0);

        assertTrue(res);
    }

    @Test
    void searchMatrix7() {
        var res = solution.searchMatrix(new int[][]{{-5}}, -5);

        assertTrue(res);
    }

    @Test
    void searchMatrix8() {
        var res = solution.searchMatrix(new int[][]{{-1, 3}}, -1);

        assertTrue(res);
    }

    @Test
    void searchMatrix9() {
        var res = solution.searchMatrix(new int[][]{
            {1, 4},
            {2, 5}
        }, 2);

        assertTrue(res);
    }

    @Test
    void searchMatrix10() {
        var res = solution.searchMatrix(new int[][]{{-5}}, -10);

        assertFalse(res);
    }

    @Test
    void searchMatrix11() {
        var res = solution.searchMatrix(new int[][]{
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15},
            {16, 17, 18, 19, 20},
            {21, 22, 23, 24, 25}
        }, 19);

        assertTrue(res);
    }

    @Test
    void searchMatrix12() {
        var res = solution.searchMatrix(new int[][]{
            {1, 3, 5, 7, 9},
            {2, 4, 6, 8, 10},
            {11, 13, 15, 17, 19},
            {12, 14, 16, 18, 20},
            {21, 22, 23, 24, 25}
        }, 13);

        assertTrue(res);
    }
}
