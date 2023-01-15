package org.lllbllllb.problems.allpathsfromsourcetotarget;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/all-paths-from-source-to-target">797. All Paths From Source to Target</a>
 */
class Solution {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        var paths = new ArrayList<List<Integer>>();
        var path = new ArrayList<Integer>();
        var cursor = 0;
        path.add(cursor);

        backTracking(graph, paths, path, cursor, graph.length - 1);

        return paths;
    }

    private void backTracking(int[][] graph, List<List<Integer>> paths, List<Integer> path, int cursor, int target) {
        if (cursor == target) {
            paths.add(List.copyOf(path));
        } else {
            for (int vertex : graph[cursor]) {
                path.add(vertex);
                backTracking(graph, paths, path, vertex, target);
                path.remove(path.size() - 1);
            }
        }
    }
}
