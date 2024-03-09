package org.lllbllllb.leetcode.problems.singlethreadedcpu;

import java.util.Deque;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * <a href="https://leetcode.com/problems/single-threaded-cpu/">1834. Single-Threaded CPU</a>
 */
class Solution {

    public int[] getOrder(int[][] tasks) {
        var enqueueTimeToIdxsMap = new TreeMap<Integer, Deque<Integer>>();

        for (int i = 0; i < tasks.length; i++) {
            enqueueTimeToIdxsMap.computeIfAbsent(tasks[i][0], et -> new LinkedList<>()).add(i);
        }

        var order = new int[tasks.length];
        var cursor = 0;
        var processingTimeToIdxsMap = new TreeMap<Integer, TreeSet<Integer>>();
        var readyToNextTaskTime = enqueueTimeToIdxsMap.firstKey();

        while (cursor < tasks.length) {
            if (!enqueueTimeToIdxsMap.isEmpty() && enqueueTimeToIdxsMap.firstKey() <= readyToNextTaskTime) {
                var taskIdxs = enqueueTimeToIdxsMap.pollFirstEntry().getValue();

                for (int taskIdx : taskIdxs) {
                    processingTimeToIdxsMap.computeIfAbsent(tasks[taskIdx][1], pt -> new TreeSet<>()).add(taskIdx);
                }
            } else {
                var processingTimeToIdxs = processingTimeToIdxsMap.firstEntry();
                var idxs = processingTimeToIdxs.getValue();
                var idx = idxs.pollFirst();

                if (idxs.isEmpty()) {
                    processingTimeToIdxsMap.pollFirstEntry();
                }

                order[cursor] = idx;
                cursor++;
                readyToNextTaskTime += processingTimeToIdxs.getKey();

                if (processingTimeToIdxsMap.isEmpty() && !enqueueTimeToIdxsMap.isEmpty() && readyToNextTaskTime < enqueueTimeToIdxsMap.firstKey()) {
                    readyToNextTaskTime = enqueueTimeToIdxsMap.firstKey();
                }
            }
        }

        return order;
    }
}
