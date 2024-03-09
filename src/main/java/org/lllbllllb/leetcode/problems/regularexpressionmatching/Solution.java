package org.lllbllllb.leetcode.problems.regularexpressionmatching;

/**
 * <a href="https://leetcode.com/problems/regular-expression-matching">10. Regular Expression Matching</a>
 */
class Solution {

    private static final char ASTERISK = '*';

    private static final char DOT = '.';

    // 1ms, 41.46MB
    public boolean isMatch(String s, String p) {
        return dfs(s, s.length() - 1, p, p.length() - 1, false, new Boolean[s.length()][p.length()]);
    }

    private boolean dfs(String source, int sCursor, String pattern, int pCursor, boolean nextAsterisk, Boolean[][] mem) {
        if (pCursor == -1) {
            return sCursor == -1;
        }

        var p = pattern.charAt(pCursor);

        if (sCursor == -1) {
            return p == ASTERISK && dfs(source, sCursor, pattern, pCursor - 1, true, mem)
                    || nextAsterisk && dfs(source, sCursor, pattern, pCursor - 1, false, mem);
        }

        if (mem[sCursor][pCursor] != null) {
            return mem[sCursor][pCursor];
        }

        var s = source.charAt(sCursor);
        var match = (p == ASTERISK) && dfs(source, sCursor, pattern, pCursor - 1, true, mem)
                || nextAsterisk && dfs(source, sCursor, pattern, pCursor - 1, false, mem)
                || (p == s || p == DOT) && dfs(source, sCursor - 1, pattern, pCursor - 1, false, mem)
                || nextAsterisk && (p == s || p == DOT) && dfs(source, sCursor - 1, pattern, pCursor, true, mem);

        return mem[sCursor][pCursor] = match;
    }
}
