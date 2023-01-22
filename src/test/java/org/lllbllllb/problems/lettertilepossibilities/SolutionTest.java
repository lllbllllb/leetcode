package org.lllbllllb.problems.lettertilepossibilities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void numTilePossibilities1() {
        var res = solution.numTilePossibilities("AAB");

        assertEquals(8, res);
    }

    @Test
    void numTilePossibilities2() {
        var res = solution.numTilePossibilities("AAABBC");

        assertEquals(188, res);
    }

    @Test
    void numTilePossibilities3() {
        var res = solution.numTilePossibilities("V");

        assertEquals(1, res);
    }

    @Test
    void numTilePossibilities4() {
        var res = solution.numTilePossibilities("AABC");

        assertEquals(34, res);
    }
}
