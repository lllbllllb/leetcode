package org.lllbllllb.leetcode.problems.hindex;


import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/h-index/">274. H-Index</a>
 */
// 0 ms, 40.5 MB
class Solution {

    public int hIndex(int[] citations) {
        var papersCount = citations.length;
        var hIdxCounter = new int[papersCount + 1];

        for (var cit : citations) {
            hIdxCounter[Math.min(papersCount, cit)]++;
        }

        var sortedCitations = new int[papersCount];
        var idx = 0;

        for (int i = 0; i < hIdxCounter.length; i++) {
            for (int j = 0; j < hIdxCounter[i]; j++) {
                sortedCitations[idx] = i;
                idx++;
            }
        }

        var hIdx = 1;

        for (int i = sortedCitations.length - 1; i >= 0; i--) {
            var numCitations = sortedCitations[i];

            if (numCitations >= hIdx) {
                hIdx++;
            } else {
                return hIdx - 1;
            }
        }

        return papersCount;
    }
}

// 0 ms, 41 MB
class Solution1 {

    // 0 ms, 40.5 MB
    public int hIndex(int[] citations) {
        var citates = new int[1000];

        for (var cit : citations) {
            citates[cit]++;
        }

        var papersLeft = citations.length;
        var hIdx = 0;

        for (int citateCount = 0; citateCount < citates.length; citateCount++) {
            var papers = citates[citateCount];

            if (papers != 0) {
                hIdx = Math.min(papersLeft, citateCount);
                papersLeft -= papers;


                if (papersLeft < citateCount) {
                    break;
                }
            }

        }

        return hIdx;
    }
}

// 2 ms, 41.3 MB
class Solution2 {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        var n = citations.length;

        for (int i = 0; i < n; i++) {
            var papers = n - i;
            var cit = citations[i];
            var delta = cit - papers;

            if (delta >= 0) {
                return Math.min(cit, papers);
            }
        }

        return 0;
    }
}
