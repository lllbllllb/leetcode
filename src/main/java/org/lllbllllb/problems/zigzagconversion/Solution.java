package org.lllbllllb.problems.zigzagconversion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/zigzag-conversion/">6. Zigzag Conversion</a>
 */
class Solution {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        var rowNumToCharsMap = new HashMap<Integer, List<Character>>(numRows);
        var rowNum = 1;
        var asc = true;

        for (int i = 0; i < s.length(); i++) {
            var chars = rowNumToCharsMap.get(rowNum);

            if (chars == null) {
                rowNumToCharsMap.put(rowNum, new ArrayList<>());
                chars = rowNumToCharsMap.get(rowNum);
            }

            chars.add(s.charAt(i));

            if (rowNum == numRows) {
                asc = false;
            }

            if (rowNum == 1) {
                asc = true;
            }

            if (asc) {
                rowNum++;
            } else {
                rowNum--;
            }
        }

        var sb = new StringBuilder(s.length());

        for (int i = 1; i <= numRows; i++) {
            var chars = rowNumToCharsMap.get(i);

            if (chars == null) {
                break;
            }

            for (var ch : chars) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public String convert1(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        var x = 2 * (numRows - 1);
        var arr = new char[s.length()];
        var index = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < s.length(); j += x) {
                arr[index++] = s.charAt(j);
                if (i > 0 && i < numRows - 1 && j + x - 2 * i < s.length()) {
                    arr[index++] = s.charAt(j + x - 2 * i);
                }
            }
        }

        return new String(arr);
    }
}
