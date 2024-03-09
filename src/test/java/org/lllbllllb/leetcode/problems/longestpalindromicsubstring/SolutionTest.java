package org.lllbllllb.leetcode.problems.longestpalindromicsubstring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class SolutionTest {

    Solution solution = new Solution();

    @Test
    void longestPalindrome1() {
        var res = solution.longestPalindrome("babad");

        assertThat(res).isIn("bab", "aba");
    }

    @Test
    void longestPalindrome2() {
        var res = solution.longestPalindrome("cbbd");

        assertThat(res).isIn("bb");
    }

    @Test
    void longestPalindrome3() {
        var res = solution.longestPalindrome("ccc");

        assertThat(res).isIn("ccc");
    }
}
