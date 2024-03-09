package org.lllbllllb.leetcode.problems.validpalindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void isPalindrome1() {
        var res = solution.isPalindrome("A man, a plan, a canal: Panama");

        assertTrue(res);
    }

    @Test
    void isPalindrome2() {
        var res = solution.isPalindrome("race a car");

        assertFalse(res);
    }

    @Test
    void isPalindrome3() {
        var res = solution.isPalindrome(" ");

        assertTrue(res);
    }

    @Test
    void isPalindrome4() {
        var res = solution.isPalindrome("0P");

        assertFalse(res);
    }

    @Test
    void isPalindrome5() {
        var res = solution.isPalindrome("8V8K;G;K;V;");

        assertFalse(res);
    }
}
