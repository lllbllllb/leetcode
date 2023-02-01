package org.lllbllllb.problems.evaluatereversepolishnotation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void evalRPN1() {
        var res = solution.evalRPN(new String[]{"2", "1", "+", "3", "*"});

        assertEquals(9, res);
    }

    @Test
    void evalRPN2() {
        var res = solution.evalRPN(new String[]{"4","13","5","/","+"});

        assertEquals(6, res);
    }

    @Test
    void evalRPN3() {
        var res = solution.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"});

        assertEquals(22, res);
    }
}
