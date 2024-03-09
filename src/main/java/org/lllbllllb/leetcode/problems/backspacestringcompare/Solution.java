package org.lllbllllb.leetcode.problems.backspacestringcompare;

/**
 * <a href="https://leetcode.com/problems/backspace-string-compare/">844. Backspace String Compare</a>
 */
// 0 ms, 41 MB, mem: o(1)
class Solution {

    public boolean backspaceCompare(String s, String t) {
        var sCursor = s.length() - 1;
        var tCursor = t.length() - 1;
        var sBack = 0;
        var tBack = 0;

        while (sCursor > -1 || tCursor > -1) {
            while (sCursor > -1) {
                if (s.charAt(sCursor) == '#') {
                    sBack++;
                    sCursor--;
                } else if (sBack > 0) {
                    sBack--;
                    sCursor--;
                } else {
                    break;
                }
            }

            while (tCursor > -1) {
                if (t.charAt(tCursor) == '#') {
                    tBack++;
                    tCursor--;
                } else if (tBack > 0) {
                    tBack--;
                    tCursor--;
                } else {
                    break;
                }
            }

            if (sCursor > -1 && tCursor > -1 && s.charAt(sCursor) != t.charAt(tCursor)
                    || sCursor > -1 && tCursor < 0
                    || tCursor > -1 && sCursor < 0) {
                return false;
            }

            sCursor--;
            tCursor--;
        }

        return sCursor < 0 && tCursor < 0;
    }
}

// 0 ms, 40.8 MB, mem: O(N)
class Solution1 {
    public boolean backspaceCompare(String s, String t) {
        s = getResultString(s);
        t = getResultString(t);

        return s.equals(t);
    }

    private String getResultString(String str) {
        var sb = new StringBuilder();
        var backCount = 0;

        for (int i = str.length() - 1; i > -1; i--) {
            var ch = str.charAt(i);

            if (ch == '#') {
                backCount++;
            } else if (backCount > 0) {
                backCount--;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}