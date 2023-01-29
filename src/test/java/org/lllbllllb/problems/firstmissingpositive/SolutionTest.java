package org.lllbllllb.problems.firstmissingpositive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void firstMissingPositive1() {
        var res = solution.firstMissingPositive(new int[]{1, 2, 0});

        assertEquals(3, res);
    }

    @Test
    void firstMissingPositive2() {
        var res = solution.firstMissingPositive(new int[]{3, 4, -1, 1});

        assertEquals(2, res);
    }

    @Test
    void firstMissingPositive3() {
        var res = solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12});

        assertEquals(1, res);
    }

    @Test
    void firstMissingPositive4() {
        var res = solution.firstMissingPositive(new int[]{1, Integer.MAX_VALUE - 1000});

        assertEquals(2, res);
    }

    @Test
    void firstMissingPositive5() {
        var res = solution.firstMissingPositive(new int[]{1});

        assertEquals(2, res);
    }

    @Test
    void firstMissingPositive6() {
        var res = solution.firstMissingPositive(new int[]{1, 2, 3, 10, 2147483647, 9});

        assertEquals(4, res);
    }
}
