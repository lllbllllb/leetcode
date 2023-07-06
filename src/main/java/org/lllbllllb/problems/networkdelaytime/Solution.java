package org.lllbllllb.problems.networkdelaytime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/network-delay-time/">743. Network Delay Time</a>
 */
class Solution {


    // Dijkstra's algorithm, min-heap
    // 12 ms, 44.7 MB
    public int networkDelayTime(int[][] times, int n, int k) {
        var sourceToPathsTimesMap = new HashMap<Integer, List<int[]>>();

        for (var time : times) {
            var source = time[0];
            var targets = sourceToPathsTimesMap.computeIfAbsent(source, t -> new ArrayList<>());
            targets.add(time);
        }

        var nodeToMinTime = new int[n + 1]; // 1-index
        Arrays.fill(nodeToMinTime, Integer.MAX_VALUE);
        nodeToMinTime[k] = 0;

        var visited = new boolean[n + 1];
        var queue = new PriorityQueue<int[]>(Comparator.comparingInt(toTime -> toTime[1]));
        queue.offer(new int[]{k, 0});

        while (!queue.isEmpty()) {
            var toTime = queue.poll();
            var pathFrom = toTime[0];
            var currentTime = toTime[1];

            if (!visited[pathFrom]) {
                var paths = sourceToPathsTimesMap.get(pathFrom);

                if (paths != null) {
                    for (var path : paths) {
                        var pathTo = path[1];
                        var pathTime = path[2];
                        var time = currentTime + pathTime;

                        if (!visited[pathTo] && time < nodeToMinTime[pathTo]) {
                            nodeToMinTime[pathTo] = time;

                            queue.offer(new int[]{pathTo, time});
                        }
                    }
                }

                visited[pathFrom] = true;
            }
        }

        var maxCost = 0;

        for (int i = 1; i < nodeToMinTime.length; i++) {
            var cost = nodeToMinTime[i];

            if (cost == Integer.MAX_VALUE) {
                return -1;
            }

            maxCost = Math.max(maxCost, cost);
        }

        return maxCost;
    }

    // 17 ms, 46.8 MB
    public int networkDelayTime1(int[][] times, int n, int k) {
        var nodeToMinTime = new int[n + 1]; // 1-index
        Arrays.fill(nodeToMinTime, Integer.MAX_VALUE);
        nodeToMinTime[k] = 0;

        for (int i = 0; i < n; i++) {
            for (int[] path : times) {
                var from = path[0];
                var to = path[1];
                var pathTime = path[2];
                var currentTime = nodeToMinTime[from];

                if (currentTime != Integer.MAX_VALUE) {
                    var time = currentTime + pathTime;

                    nodeToMinTime[to] = Math.min(nodeToMinTime[to], time);
                }
            }
        }

        var maxCost = 0;

        for (int i = 1; i < nodeToMinTime.length; i++) {
            var time = nodeToMinTime[i];

            if (time == Integer.MAX_VALUE) {
                return -1;
            }

            maxCost = Math.max(maxCost, time);
        }

        return maxCost;
    }
}
