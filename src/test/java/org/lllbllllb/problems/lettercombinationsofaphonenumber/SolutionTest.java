package org.lllbllllb.problems.lettercombinationsofaphonenumber;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void letterCombinations1() {
        var res = solution.letterCombinations("23");

        assertThat(res, containsInAnyOrder("ad","ae","af","bd","be","bf","cd","ce","cf"));
    }

    @Test
    void letterCombinations2() {
        var res = solution.letterCombinations("");

        assertThat(res, containsInAnyOrder());
    }

    @Test
    void letterCombinations3() {
        var res = solution.letterCombinations("2");

        assertThat(res, containsInAnyOrder("a","b","c"));
    }
}
