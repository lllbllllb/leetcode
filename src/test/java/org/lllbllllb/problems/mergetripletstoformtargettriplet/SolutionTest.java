package org.lllbllllb.problems.mergetripletstoformtargettriplet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void mergeTriplets1() {
        var res = solution.mergeTriplets(new int[][]{{2, 5, 3}, {1, 8, 4}, {1, 7, 5}}, new int[]{2, 7, 5});

        assertTrue(res);
    }

    @Test
    void mergeTriplets2() {
        var res = solution.mergeTriplets(new int[][]{{3, 4, 5}, {4, 5, 6}}, new int[]{3, 2, 5});

        assertFalse(res);
    }

    @Test
    void mergeTriplets3() {
        var res = solution.mergeTriplets(new int[][]{{2, 5, 3}, {2, 3, 4}, {1, 2, 5}, {5, 2, 3}}, new int[]{5, 5, 5});

        assertTrue(res);
    }

    @Test
    void mergeTriplets4() {
        var res = solution.mergeTriplets(new int[][]{{6, 5, 3}, {5, 3, 4}, {1, 2, 5}}, new int[]{5, 5, 5});

        assertFalse(res);
    }
}
