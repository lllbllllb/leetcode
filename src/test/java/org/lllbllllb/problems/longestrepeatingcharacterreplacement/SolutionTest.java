package org.lllbllllb.problems.longestrepeatingcharacterreplacement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void characterReplacement1() {
        var res = solution.characterReplacement("ABAB", 2);

        assertEquals(4, res);
    }

    @Test
    void characterReplacement2() {
        var res = solution.characterReplacement("AABABBA", 1);

        assertEquals(4, res);
    }

    @Test
    void characterReplacement3() {
        var res = solution.characterReplacement("CAACBCBBAABBCA", 3);

        assertEquals(8, res);
    }
}
