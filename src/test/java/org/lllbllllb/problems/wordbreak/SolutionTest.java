package org.lllbllllb.problems.wordbreak;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void wordBreak1() {
        var res = solution.wordBreak("leetcode", List.of("leet", "code"));

        assertTrue(res);
    }

    @Test
    void wordBreak2() {
        var res = solution.wordBreak("applepenapple", List.of("apple", "pen"));

        assertTrue(res);
    }

    @Test
    void wordBreak3() {
        var res = solution.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"));

        assertFalse(res);
    }

    @Test
    void wordBreak4() {
        var res = solution.wordBreak("aaaaaaa", List.of("aaaa", "aaa"));

        assertTrue(res);
    }

    @Test
    void wordBreak5() {
        var res = solution.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));

        assertFalse(res);
    }
}
