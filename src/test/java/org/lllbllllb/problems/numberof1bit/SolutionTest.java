package org.lllbllllb.problems.numberof1bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void hammingWeight1() {
        var res = solution.hammingWeight(0b00000000000000000000000000001011);

        assertEquals(3, res);
    }

    @Test
    void hammingWeight2() {
        var res = solution.hammingWeight(0b00000000000000000000000010000000);

        assertEquals(1, res);
    }

    @Test
    void hammingWeight3() {
        var res = solution.hammingWeight(0b11111111111111111111111111111101);

        assertEquals(31, res);
    }
}