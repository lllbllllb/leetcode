package org.lllbllllb.leetcode.problems.expressionaddoperators;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void shouldAddOperatorsTest1() {
        var res = solution.addOperators("123", 6);

        assertThat(res).containsExactlyInAnyOrder("1*2*3", "1+2+3");
    }

    @Test
    void shouldAddOperatorsTest2() {
        var res = solution.addOperators("232", 8);

        assertThat(res).containsExactlyInAnyOrder("2*3+2", "2+3*2");
    }

    @Test
    void shouldAddOperatorsTest3() {
        var res = solution.addOperators("3456237490", 9191);

        assertThat(res).isEmpty();
    }

    @Test
    void shouldAddOperatorsTest4() {
        var res = solution.addOperators("233", 11);

        assertThat(res).containsExactlyInAnyOrder("2+3*3");
    }

    @Test
    void shouldAddOperatorsTest5() {
        var res = solution.addOperators("233", 9);

        assertThat(res).containsExactlyInAnyOrder("2*3+3");
    }

    @Test
    void shouldAddOperatorsTest6() {
        var res = solution.addOperators("1", 1);

        assertThat(res).containsExactlyInAnyOrder("1");
    }

    @Test
    void shouldAddOperatorsTest7() {
        var res = solution.addOperators("1", 2);

        assertThat(res).isEmpty();
    }

}
