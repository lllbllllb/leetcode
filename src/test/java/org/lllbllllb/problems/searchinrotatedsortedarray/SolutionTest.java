package org.lllbllllb.problems.searchinrotatedsortedarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void search1() {
        var res = solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0);

        assertEquals(4, res);
    }

    @Test
    void search2() {
        var res = solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3);

        assertEquals(-1, res);
    }

    @Test
    void search3() {
        var res = solution.search(new int[]{1}, 0);

        assertEquals(-1, res);
    }

    @Test
    void search4() {
        var res = solution.search(new int[]{5, 6, 7, 8, 1, 2, 3, 4}, 3);

        assertEquals(6, res);
    }

    @Test
    void search5() {
        var res = solution.search(new int[]{5, 6, 7, 8, 1, 2, 3, 4}, 2);

        assertEquals(5, res);
    }

    @Test
    void search6() {
        var res = solution.search(new int[]{5, 6, 7, 8, 9, 2, 3, 4}, 3);

        assertEquals(6, res);
    }

    @Test
    void search7() {
        var res = solution.search(new int[]{5, 6, 7, 8, 9, 2, 3, 4}, 9);

        assertEquals(4, res);
    }

    @Test
    void search8() {
        var res = solution.search(new int[]{1, 2, 3, 4, 5}, 4);

        assertEquals(3, res);
    }

    @Test
    void search9() {
        var res = solution.search(new int[]{8, 9, 1, 2, 3, 4}, 9);

        assertEquals(1, res);
    }

    @Test
    void search10() {
        var res = solution.search(new int[]{1, 2, 3, 4, 5}, 2);

        assertEquals(1, res);
    }

    @Test
    void search11() {
        var res = solution.search(new int[]{1}, 2);

        assertEquals(-1, res);
    }

    @Test
    void search12() {
        var res = solution.search(new int[]{5, 1, 2, 3, 4}, 1);

        assertEquals(1, res);
    }
}
