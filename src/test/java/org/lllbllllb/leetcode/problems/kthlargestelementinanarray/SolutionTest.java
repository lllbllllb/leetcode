package org.lllbllllb.leetcode.problems.kthlargestelementinanarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void findKthLargest1() {
        var res = solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);

        assertEquals(5, res);
    }

    @Test
    void findKthLargest2() {
        var res = solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);

        assertEquals(4, res);
    }

    @Test
    void findKthLargest3() {
        var res = solution.findKthLargest(new int[]{3, 2, 3, 1, 4, 2, 5, 6, 6}, 1);

        assertEquals(6, res);
    }

    @Test
    void findKthLargest4() {
        var res = solution.findKthLargest(new int[]{2, 1}, 1);

        assertEquals(2, res);
    }

    @Test
    void findKthLargest5() {
        var res = solution.findKthLargest(new int[]{2, 6, 5, 3, 8, 7, 1, 0}, 1);

        assertEquals(8, res);
    }

    @Test
    void findKthLargest6() {
        var res = solution.findKthLargest(new int[]{5, 2, 4, 1, 3, 6, 0}, 4);

        assertEquals(3, res);
    }

    @Test
    void findKthLargest7() {
        var res = solution.findKthLargest(new int[]{-1, -1}, 2);

        assertEquals(-1, res);
    }
}
