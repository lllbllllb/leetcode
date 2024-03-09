package org.lllbllllb.leetcode.problems.pacificatlanticwaterflow;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/pacific-atlantic-water-flow/">417. Pacific Atlantic Water Flow</a>
 */
class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        var rows = heights.length;
        var cols = heights[0].length;
        var directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        var toPacific = new boolean[rows][cols];
        var toAtlantic = new boolean[rows][cols];

        dfs(heights, 0, 0, 0, 0, 0, toPacific, directions);
        dfs(heights, rows - 1, cols - 1, 0, rows - 1, cols - 1, toAtlantic, directions);

        var res = new ArrayList<List<Integer>>();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (toPacific[r][c] && toAtlantic[r][c]) {
                    res.add(List.of(r, c));
                }
            }
        }

        return res;
    }

    private void dfs(int[][] heights, int r, int c, int prevHeight, int beachR, int beachC, boolean[][] flow, int[][] directions) {
        if (r == -1 || c == -1 || r == heights.length || c == heights[0].length
            || r != beachR && c != beachC && heights[r][c] < prevHeight
            || flow[r][c]) {
            return;
        }

        flow[r][c] = true;

        for (var direction : directions) {
            dfs(heights, r + direction[0], c + direction[1], heights[r][c], beachR, beachC, flow, directions);
        }
    }
}
