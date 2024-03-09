package org.lllbllllb.leetcode.problems.validparenthesisstring;

/**
 * <a href="https://leetcode.com/problems/valid-parenthesis-string/">678. Valid Parenthesis String</a>
 */
class Solution {

    public boolean checkValidString(String s) {
        var min = 0;
        var max = 0;

        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);

            min += ch == '(' ? 1 : -1;
            min = Math.max(min, 0);
            max += ch == ')' ? -1 : 1;

            if (max < 0) {
                return false;
            }
        }

        return min == 0;
    }

    // 0 ms, 40.4 MB
    public boolean checkValidString1(String s) {
        var leftMin = 0;
        var leftMax = 0;

        for (int i = 0; i < s.length(); i++) {
            var parenthesis = s.charAt(i);

            if (parenthesis == '(') {
                leftMin++;
                leftMax++;
            } else if (parenthesis == ')') {
                leftMin--;
                leftMax--;
            } else {
                leftMin--;
                leftMax++;
            }

            if (leftMax < 0) {
                return false;
            }

            if (leftMin < 0) {
                leftMin = 0;
            }
        }

        return leftMin == 0;
    }

    // 0 ms, 40.4 MB
    public boolean checkValidString2(String s) {
        var forwardCount = 0;

        for (int i = 0; i < s.length(); i++) {
            var parenthesis = s.charAt(i);

            if (parenthesis == ')') {
                forwardCount--;

                if (forwardCount < 0) {
                    return false;
                }
            } else {
                forwardCount++;
            }
        }

        var backwardCount = 0;

        for (int i = s.length() - 1; i > -1; i--) {
            var parenthesis = s.charAt(i);

            if (parenthesis == '(') {
                backwardCount--;

                if (backwardCount < 0) {
                    return false;
                }
            } else {
                backwardCount++;
            }
        }

        return forwardCount >= 0 && backwardCount >= 0;
    }

    // 0 ms, 40.6 MB
    public boolean checkValidString3(String s) {
        var count = 0;
        var stars = 0;

        for (int i = 0; i < s.length(); i++) {
            var parenthesis = s.charAt(i);

            if ('(' == parenthesis) {
                count++;
            } else if (')' == parenthesis) {
                if (count > 0) {
                    count--;
                } else if (stars != 0) {
                    stars--;
                } else {
                    return false;
                }
            } else {
                stars++;
            }
        }

        var isForwardOk = stars >= count;

        count = 0;
        stars = 0;

        for (int i = s.length() - 1; i > -1; i--) {
            var parenthesis = s.charAt(i);

            if (')' == parenthesis) {
                count++;
            } else if ('(' == parenthesis) {
                if (count > 0) {
                    count--;
                } else if (stars != 0) {
                    stars--;
                } else {
                    return false;
                }
            } else {
                stars++;
            }
        }

        var isBackwardOk = stars >= count;

        return isForwardOk && isBackwardOk;
    }
}
