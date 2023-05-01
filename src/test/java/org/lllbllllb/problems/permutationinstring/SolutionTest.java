package org.lllbllllb.problems.permutationinstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void checkInclusion1() {
        var res = solution.checkInclusion("ab", "eidbaooo");

        assertTrue(res);
    }

    @Test
    void checkInclusion2() {
        var res = solution.checkInclusion("ab", "eidboaoo");

        assertFalse(res);
    }

    @Test
    void checkInclusion3() {
        var res = solution.checkInclusion("adc", "dcda");

        assertTrue(res);
    }

    @Test
    void checkInclusion4() {
        var res = solution.checkInclusion("adc", "cda");

        assertTrue(res);
    }

    @Test
    void checkInclusion5() {
        var res = solution.checkInclusion("adc", "aadc");

        assertTrue(res);
    }

    @Test
    void checkInclusion6() {
        var res = solution.checkInclusion("hello", "looleh");

        assertFalse(res);
    }

    @Test
    void checkInclusion7() {
        var res = solution.checkInclusion("ll", "olo");

        assertFalse(res);
    }
}
