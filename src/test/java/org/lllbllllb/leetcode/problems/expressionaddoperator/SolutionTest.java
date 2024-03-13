package org.lllbllllb.leetcode.problems.expressionaddoperator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void addOperators1() {
        var res = solution.addOperators("123", 6);

        assertThat(res).containsExactlyInAnyOrder("1*2*3","1+2+3");
    }

    @Test
    void addOperators2() {
        var res = solution.addOperators("232", 8);

        assertThat(res).containsExactlyInAnyOrder("2*3+2","2+3*2");
    }

    @Test
    void addOperators3() {
        var res = solution.addOperators("3456237490", 9191);

        assertThat(res).isEmpty();
    }

    @Test
    void addOperators4() {
        var res = solution.addOperators("105", 5);

        assertThat(res).containsExactlyInAnyOrder("1*0+5","10-5");
    }

    @Test
    void addOperators5() {
        var res = solution.addOperators("00", 0);

        assertThat(res).containsExactlyInAnyOrder("0*0","0+0","0-0");
    }

    @Test
    void addOperators6() {
        var res = solution.addOperators("123456789", 45);

        assertThat(res).containsExactlyInAnyOrder("0*0","0+0","0-0");
    }
}