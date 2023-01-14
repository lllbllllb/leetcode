package org.lllbllllb.problems.zigzagconversion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final Solution solution = new Solution();

    /*
        P   A   H   N
        A P L S I I G
        Y   I   R

        0 4 8 12 | 1 3 5 7 9 11 | 2 6 10
    */
    @Test
    void convert1() {
        var res = solution.convert("PAYPALISHIRING", 3);

        assertEquals("PAHNAPLSIIGYIR", res);
    }

    /*
        P     I    N    (numRows - 1) * 2
        A   L S  I G
        Y A   H R
        P     I

        0 6 12 | 1 5 7 11 13 | 2 4 8 10 | 3 9

    */
    @Test
    void convert2() {
        var res = solution.convert("PAYPALISHIRING", 4);

        assertEquals("PINALSIGYAHRPI", res);
    }

    @Test
    void convert3() {
        var res = solution.convert("A", 2);

        assertEquals("A", res);
    }

    @Test
    void convert4() {
        var res = solution.convert("AB", 1);

        assertEquals("AB", res);
    }
}
