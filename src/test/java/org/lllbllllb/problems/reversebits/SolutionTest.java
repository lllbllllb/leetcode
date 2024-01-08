package org.lllbllllb.problems.reversebits;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void reverseBits1() {
        var res = solution.reverseBits(0b00000010100101000001111010011100); // 43261596

        assertEquals(0b00111001011110000010100101000000, res); // 964176192
    }

    @Test
    void reverseBits2() {
        var res = solution.reverseBits(0b11111111111111111111111111111101);

        assertEquals(0b10111111111111111111111111111111, res);
    }
}