package org.lllbllllb.problems.networkdelaytime;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * <a href="https://leetcode.com/problems/network-delay-time/">743. Network Delay Time</a>
 */
class Solution {

    // min-heap
    // 75 ms, 49.1 MB
    public int networkDelayTime(int[][] times, int n, int k) {
        var sourceToPathsTimesMap = new HashMap<Integer, List<int[]>>();
        var nodeToMinTimeMap = new HashMap<Integer, Integer>();

        for (var time : times) {
            var source = time[0];
            var targets = sourceToPathsTimesMap.computeIfAbsent(source, t -> new ArrayList<>());
            targets.add(time);
            var dest = time[1];
            nodeToMinTimeMap.put(dest, Integer.MAX_VALUE);
        }

        nodeToMinTimeMap.put(k, 0);

        var visited = new HashSet<Integer>();
        var queue = new PriorityQueue<Integer>(Comparator.comparing(nodeToMinTimeMap::get));
        queue.offer(k);
        var maxCost = 0;

        while (!queue.isEmpty() && visited.size() < n) {
            var pathFrom = queue.poll();

            if (!visited.contains(pathFrom)) {
                var currentTime = nodeToMinTimeMap.get(pathFrom);
                maxCost = Math.max(maxCost, currentTime);
                var paths = sourceToPathsTimesMap.get(pathFrom);

                if (paths != null) {
                    for (var path : paths) {
                        var pathTo = path[1];
                        var pathTime = path[2];
                        var minTime = Math.min(nodeToMinTimeMap.get(pathTo), currentTime + pathTime);
                        nodeToMinTimeMap.put(pathTo, minTime);

                        queue.offer(pathTo);
                    }
                }

                visited.add(pathFrom);
            }
        }

        if (visited.size() != n) {
            return -1;
        }

        return maxCost;
    }

    // 1731 ms, 48.8 MB
    public int networkDelayTime3(int[][] times, int n, int k) {
        var sourceToTargetTimesMap = new HashMap<Integer, List<int[]>>();
        var nodeToMinTimeMap = new HashMap<Integer, Integer>();

        for (var time : times) {
            var source = time[0];
            var targets = sourceToTargetTimesMap.computeIfAbsent(source, t -> new ArrayList<>());
            targets.add(time);

            var dest = time[1];
            nodeToMinTimeMap.put(source, Integer.MAX_VALUE);
            nodeToMinTimeMap.put(dest, Integer.MAX_VALUE);
        }

        if (nodeToMinTimeMap.size() < n) {
            return -1;
        }

        dfs(sourceToTargetTimesMap, nodeToMinTimeMap, k, n, 0, new HashSet<>());

        var maxCost = 0;

        for (var cost : nodeToMinTimeMap.values()) {
            maxCost = Math.max(maxCost, cost);
        }

        return maxCost == Integer.MAX_VALUE ? -1 : maxCost;
    }

    private void dfs(Map<Integer, List<int[]>> sourceToTargetTimesMap, Map<Integer, Integer> nodeToMinTimeMap, int k, int n, int kTime, Set<Integer> visited) {
        var kMin = nodeToMinTimeMap.get(k);

        if (kTime < kMin) {
            nodeToMinTimeMap.put(k, kTime);
            visited.remove(k);
        }

        if (visited.contains(k) || !sourceToTargetTimesMap.containsKey(k) || visited.size() == n) {
            return;
        }

        visited.add(k);

        var nodes = sourceToTargetTimesMap.get(k);

        for (var node : nodes) {
            var dest = node[1];
            var time = node[2];

            dfs(sourceToTargetTimesMap, nodeToMinTimeMap, dest, n, kTime + time, visited);
        }
    }
}
