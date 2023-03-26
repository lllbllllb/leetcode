package org.lllbllllb.problems.decodeways;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void numDecodings1() {
        var res = solution.numDecodings("12");

        assertEquals(2, res);
    }

    @Test
    void numDecodings2() {
        var res = solution.numDecodings("226");

        assertEquals(3, res);
    }

    @Test
    void numDecodings3() {
        var res = solution.numDecodings("06");

        assertEquals(0, res);
    }

    @Test
    void numDecodings4() {
        var res = solution.numDecodings("11106"); // 1 1 10 6, 11 10 6,

        assertEquals(2, res);
    }

    @Test
    void numDecodings5() {
        var res = solution.numDecodings("11306");

        assertEquals(0, res);
    }

    @Test
    void numDecodings6() {
        var res = solution.numDecodings("13106"); // 1 3 10 6, 13 10 6,

        assertEquals(2, res);
    }

    @Test
    void numDecodings7() {
        var res = solution.numDecodings("1");

        assertEquals(1, res);
    }

    @Test
    void numDecodings8() {
        var res = solution.numDecodings("111111111111111111111111111111111111111111111");

        assertEquals(1836311903, res);
    }
}
