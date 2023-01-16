package org.lllbllllb.problems.generateparentheses;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;


class SolutionTest {

    Solution solution = new Solution();

    @Test
    void generateParenthesis1() {
        var res = solution.generateParenthesis(3);

        assertThat(res, containsInAnyOrder("((()))","(()())","(())()","()(())","()()()"));
    }

    @Test
    void generateParenthesis2() {
        var res = solution.generateParenthesis(1);

        assertThat(res, containsInAnyOrder("()"));
    }
}
