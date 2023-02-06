package org.lllbllllb.problems.largestrectangleinhistogram;

/**
 * @see <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">84. Largest Rectangle in Histogram</a>
 */
class Solution {

    // TODO
    public int largestRectangleArea(int[] heights) {
        var len = heights.length;
        var maxArea = 0;

        for (int i = 0; i < len; i++) {
            var rightMin = heights[i];

            for (int j = i; j < len; j++) {
                var rightHeight = heights[j];

                rightMin = Math.min(rightHeight, rightMin);
                maxArea = Math.max(rightMin * (j - i + 1), maxArea);
            }

        }

        return maxArea;
    }

    // Time Limit Exceeded (brute force)
    public int largestRectangleArea1(int[] heights) {
        var len = heights.length;
        var maxArea = 0;

        for (int i = 0; i < len; i++) {
            var leftMin = heights[i];

            for (int j = i; j > -1; j--) {
                var leftHeight = heights[j];

                leftMin = Math.min(leftHeight, leftMin);
                maxArea = Math.max(leftMin * (i - j + 1), maxArea);
            }

//            var rightMin = heights[i];
//
//            for (int j = i; j < len; j++) {
//                var rightHeight = heights[j];
//
//                rightMin = Math.min(rightHeight, rightMin);
//                maxArea = Math.max(rightMin * (j - i + 1), maxArea);
//            }

        }

        return maxArea;
    }
}
