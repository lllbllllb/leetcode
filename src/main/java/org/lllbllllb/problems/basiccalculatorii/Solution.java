package org.lllbllllb.problems.basiccalculatorii;

import java.util.ArrayList;

/**
 * <a href="https://leetcode.com/problems/basic-calculator-ii/">227. Basic Calculator II</a>
 */
class Solution {

    // TODO
    public int calculate(String s) {
        s = s.trim();
        var tokens = new ArrayList<String>();
        var tmp = new StringBuilder();
        var digit = true;

        for (int i = 0; i < s.length(); i++) {
            var ch = s.charAt(i);

            if ((Character.isDigit(ch) && digit) || (!Character.isDigit(ch) && !digit)) {
                tmp.append(ch);
            } else if ((!Character.isDigit(ch) && digit) || (Character.isDigit(ch) && !digit)) {
                digit = !digit;
                tokens.add(tmp.toString().trim());
                tmp = new StringBuilder();
                tmp.append(ch);
            }
        }
        tokens.add(tmp.toString());

        var first = Integer.parseInt(tokens.get(0));
//        var second = Integer.parseInt()

        for (int i = 1; i < tokens.size(); i++) {
            if (i % 2 == 0) { // numbers

            } else { // operators

            }
        }


        return 0;
    }
}
