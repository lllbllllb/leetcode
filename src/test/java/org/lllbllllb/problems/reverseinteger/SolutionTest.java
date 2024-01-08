package org.lllbllllb.problems.reverseinteger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void reverse1() {
        var res = solution.reverse(123);

        assertEquals(321, res);
    }

    @Test
    void reverse2() {
        var res = solution.reverse(-123);

        assertEquals(-321, res);
    }

    @Test
    void reverse3() {
        var res = solution.reverse(120);

        assertEquals(21, res);
    }

    @Test
    void reverse4() {
        var res = solution.reverse(1999999999);

        assertEquals(0, res);
    }

    @Test
    void reverse5() {
        var res = solution.reverse(999_951_111);

        assertEquals(111_159_999, res);
    }

    @Test
    void reverse6() {
        var res = solution.reverse(1999951111);

        assertEquals(1111599991, res);
    }

    @Test
    void reverse7() {
        var res = solution.reverse(0);

        assertEquals(0, res);
    }

    @Test
    void reverse8() {
        var res = solution.reverse(-2147483648);

        assertEquals(0, res);
    }

    @Test
    void reverse9() { // 1043
        var res = solution.reverse(1563847412);

        assertEquals(0, res);
    }

    @Test
    void reverse10() { // 1045
        var res = solution.reverse(1463847412);

        assertEquals(2147483641, res);
    }
}