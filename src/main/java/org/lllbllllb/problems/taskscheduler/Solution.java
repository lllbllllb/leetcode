package org.lllbllllb.problems.taskscheduler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/task-scheduler/">621. Task Scheduler</a>
 */
class Solution {

    // 20 ms, 44.5 MB
    public int leastInterval(char[] tasks, int n) {
        var counter = new int['Z' - 'A' + 1];

        for (var task : tasks) {
            counter[task - 'A']++;
        }

        var queue = new LinkedList<Integer>();

        for (var count : counter) {
            if (count != 0) {
                queue.offer(count);
            }
        }

        var time = 0;

        while (!queue.isEmpty()) {
            queue.sort(Collections.reverseOrder());

            var threshold = n + 1;
            var size = queue.size();

            for (int i = 0; i < size; i++) {
                var count = queue.poll() - 1;

                if (count != 0) {
                    queue.offer(count);
                }

                time++;
                threshold--;

                if (threshold == 0) {
                    break;
                }
            }

            if (!queue.isEmpty()) {
                time += threshold;
            }
        }

        return time;
    }

    // 35 ms, 44.1 MB
    public int leastInterval1(char[] tasks, int n) {
        var counter = new int['Z' - 'A' + 1];

        for (var task : tasks) {
            counter[task - 'A']++;
        }

        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for (var count : counter) {
            if (count != 0) {
                pq.offer(count);
            }
        }

        var time = 0;

        while(!pq.isEmpty()) {
            var rootTask = pq.poll() - 1;
            var tmp = new ArrayList<Integer>();

            if (rootTask != 0) {
                tmp.add(rootTask);
            }

            time++;

            for (int i = 0; i < n; i++) {
                if (!pq.isEmpty()) {
                    var task = pq.poll() - 1;

                    if (task != 0) {
                        tmp.add(task);
                    }

                    time++;
                } else if (!pq.isEmpty() || !tmp.isEmpty()) {
                    time++;
                }
            }

            for (var count : tmp) {
                pq.offer(count);
            }
        }

        return time;
    }
}
