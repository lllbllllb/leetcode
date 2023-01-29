package org.lllbllllb.problems.groupanagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/group-anagrams/description/">49. Group Anagrams</a>
 */
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        var signToStrs = new HashMap<String, List<String>>();

        for (var str : strs) {
            var sign = new char[26];

            for (int i = 0; i < str.length(); i++) {
                var ch = str.charAt(i);
                var idx = ch - 'a';

                sign[idx]++;
            }

            var anagrams = signToStrs.computeIfAbsent(new String(sign), s -> new ArrayList<>());

            anagrams.add(str);
        }

        return List.copyOf(signToStrs.values());
    }
}
