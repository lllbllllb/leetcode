package org.lllbllllb.problems.validparenthesisstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void checkValidString1() {
        var res = solution.checkValidString("()");

        assertTrue(res);
    }

    @Test
    void checkValidString2() {
        var res = solution.checkValidString("(*)");

        assertTrue(res);
    }

    @Test
    void checkValidString3() {
        var res = solution.checkValidString("(*))");

        assertTrue(res);
    }

    @Test
    void checkValidString4() {
        var res = solution.checkValidString("(*))(");

        assertFalse(res);
    }

    @Test
    void checkValidString5() {
        var res = solution.checkValidString("(*))(*");

        assertTrue(res);
    }

    @Test
    void checkValidString6() {
        var res = solution.checkValidString("(*))*(");

        assertFalse(res);
    }

    @Test
    void checkValidString7() {
        var res = solution.checkValidString("(*))*)");

        assertTrue(res);
    }

    @Test
    void checkValidString8() {
        var res = solution.checkValidString("(*())*)");

        assertTrue(res);
    }

    @Test
    void checkValidString9() {
        var res = solution.checkValidString("((*");

        assertFalse(res);
    }

    @Test
    void checkValidString10() {
        var res = solution.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())");
        solution.checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((");

        assertFalse(res);
    }

    @Test
    void checkValidString11() {
        var res = solution.checkValidString("(*)*)");

        assertTrue(res);
    }

}
