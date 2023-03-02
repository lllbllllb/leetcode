package org.lllbllllb.problems.largestrectangleinhistogram;

/**
 * <a href="https://leetcode.com/problems/largest-rectangle-in-histogram/">84. Largest Rectangle in Histogram</a>
 */
class Solution {

    // 9 ms, 60.2 MB
    public int largestRectangleArea(int[] heights) {
        var popCount = new int[heights.length];
        var poppedFrom = new int[heights.length];
        var stack = new int[heights.length];
        var stackCursor = 0;

        for (int i = 0; i < heights.length; i++) {
            var height = heights[i];

            while (stackCursor > 0 && heights[stack[stackCursor - 1]] > height) {
                var poppedBarIdx = stack[stackCursor - 1];
                popCount[i] = popCount[i] + 1 + popCount[poppedBarIdx];
                poppedFrom[poppedBarIdx] = i;
                stackCursor--;
            }

            stack[stackCursor] = i;
            stackCursor++;
        }

        var maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            var height = heights[i];
            var left = popCount[i];
            var right = poppedFrom[i] == 0 ? heights.length - i : poppedFrom[i] - i;
            var area = height * (left + right);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    // 5 ms, 52.9 MB
    public int largestRectangleArea2(int[] heights) {
        var num = new int[heights.length];
        var stack = new int[heights.length];
        var maxArea = Integer.MIN_VALUE;
        var stackCursor = 0;
        stackCursor = -1;

        var barIdx = 0;
        var area = 0;
        var barHeight = 0;

        for (int i = 0; i < heights.length; i++) {
            barIdx = i;

            while (stackCursor >= 0 && heights[i] <= num[stackCursor]) {
                barHeight = num[stackCursor];
                barIdx = stack[stackCursor];
                stackCursor--;
                area = (i - barIdx) * barHeight;

                if (maxArea < area) {
                    maxArea = area;
                }
            }

            stackCursor++;
            num[stackCursor] = heights[i];
            stack[stackCursor] = barIdx;
        }

        while (stackCursor >= 0) {
            barHeight = num[stackCursor];
            barIdx = stack[stackCursor--];
            area = (heights.length - barIdx) * barHeight;

            if (maxArea < area) {
                maxArea = area;
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
