package org.lllbllllb.leetcode.problems.findtheduplicatenumber;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void findDuplicate1() {
        var res = solution.findDuplicate(new int[]{1, 3, 4, 2, 2}); // s=12|10 l=5 n=4     1 2 3 4

        assertEquals(2, res);
    }

    @Test
    void findDuplicate2() {
        var res = solution.findDuplicate(new int[]{3, 1, 3, 4, 2}); // s=13|10 l=5 n=4    1 2 3 4

        assertEquals(3, res);
    }

    @Test
    void findDuplicate3() {
        var res = solution.findDuplicate(new int[]{3, 1, 3, 4, 2, 3}); // s=16|15 l=6 n=5    1 2 3 4 5

        assertEquals(3, res);
    }

    @Test
    void findDuplicate4() {
        var res = solution.findDuplicate(new int[]{1, 1, 1, 1, 2, 3}); // s=9|15 l=6 n=5    1 2 3 4 5

        assertEquals(1, res);
    }

    @Test
    void findDuplicate5() {
        var res = solution.findDuplicate(new int[]{1, 1, 2}); // s=6|4 l=3 n=2    1 2 3

        assertEquals(1, res);
    }

    @Test
    void findDuplicate6() {
        var res = solution.findDuplicate(new int[]{1, 1, 1, 1}); // s=4|10 l=4 n=3    1 2 3 4

        assertEquals(1, res);
    }

    @Test
    void findDuplicate7() {
        var res = solution.findDuplicate(new int[]{1, 2, 3, 4, 4, 4}); // s=18|15 l=6 n=5    1 2 3 4 5

        assertEquals(4, res);
    }

    @Test
    void findDuplicate8() {
        var res = solution.findDuplicate(new int[]{1, 1, 2, 3, 4}); // s=11|10 l=6 n=4    1 2 3 4

        assertEquals(1, res);
    }

    @Test
    void findDuplicate9() {
        var res = solution.findDuplicate(new int[]{2, 2, 2, 4, 1}); // s=11|10 l=5 n=4    1 2 3 4

        assertEquals(2, res);
    }
}
