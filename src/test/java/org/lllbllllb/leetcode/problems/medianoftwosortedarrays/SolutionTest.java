package org.lllbllllb.leetcode.problems.medianoftwosortedarrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
class SolutionTest {

    Solution solution = new Solution();

    @Test
    void findMedianSortedArrays1() {
        var res = solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});

        assertEquals(2.00000, res);
    }

    @Test
    void findMedianSortedArrays2() {
        var res = solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});

        assertEquals(2.50000, res);
    }

    @Test
    void findMedianSortedArrays3() {
        var res = solution.findMedianSortedArrays(new int[]{}, new int[]{1});

        assertEquals(1, res);
    }

    @Test
    void findMedianSortedArrays4() {
        var res = solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7});

        assertEquals(2.500, res);
    }

    @Test
    void findMedianSortedArrays5() {
        var res = solution.findMedianSortedArrays(new int[]{1, 3, 5, 7, 9}, new int[]{8});

        assertEquals(6.000, res);
    }

    @Test
    void findMedianSortedArrays6() {
        var res = solution.findMedianSortedArrays(new int[]{1, 3, 5, 7}, new int[]{6});

        assertEquals(5.0000, res);
    }

    @Test
    void findMedianSortedArrays7() {
        var res = solution.findMedianSortedArrays(new int[]{1, 3, 5, 7, 9, 11}, new int[]{6});

        assertEquals(6.0000, res);
    }

    @Test
    void findMedianSortedArrays8() {
        var res = solution.findMedianSortedArrays(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{8, 9}); // 1 2 3 4  5  6 7 8 9

        assertEquals(5, res);
    }

    @Test
    void findMedianSortedArrays9() {
        var res = solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{1, 2, 3, 4, 5}); // 1 1 2  3  3 4 5

        assertEquals(3, res);
    }
}
