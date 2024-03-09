package org.lllbllllb.leetcode.problems.minimumintervaltoincludeeachquery;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/minimum-interval-to-include-each-query/">1851. Minimum Interval to Include Each Query</a>
 */
class Solution {


    public int[] minInterval(int[][] intervals, int[] queries) {
        var intervalFromMinHeap = new PriorityQueue<>(Comparator.comparingInt((Interval i) -> i.from));

        for (var interval : intervals) {
            intervalFromMinHeap.offer(new Interval(interval));
        }

        var queriesMinHeap = new PriorityQueue<>(Comparator.comparingInt((Query q) -> q.val));

        for (int i = 0; i < queries.length; i++) {
            queriesMinHeap.offer(new Query(i, queries[i]));
        }

        var intervalSizeMinHeap = new PriorityQueue<>(Comparator.comparingInt((Interval i) -> i.size).thenComparingInt((Interval i) -> i.to));
        var res = new int[queries.length];

        while (!queriesMinHeap.isEmpty()) {
            var query = queriesMinHeap.poll();

            while (!intervalFromMinHeap.isEmpty() && intervalFromMinHeap.peek().from <= query.val) {
                intervalSizeMinHeap.offer(intervalFromMinHeap.poll());
            }

            while (!intervalSizeMinHeap.isEmpty() && intervalSizeMinHeap.peek().to < query.val) {
                intervalSizeMinHeap.poll();
            }

            res[query.idx] = intervalSizeMinHeap.isEmpty() ? -1 : intervalSizeMinHeap.peek().size;
        }

        return res;
    }

    private static class Interval {

        public final int from;

        public final int to;

        public final int size;

        public Interval(int[] interval) {
            from = interval[0];
            to = interval[1];
            size = to - from + 1;
        }
    }

    private record Query(int idx, int val) {}

    // Time Limit Exceeded
    public int[] minInterval1(int[][] intervals, int[] queries) {
        var res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            var query = queries[i];
            var min = Integer.MAX_VALUE;

            for (int[] interval : intervals) {
                if (query >= interval[0] && query <= interval[1]) {
                    var len = interval[1] - interval[0] + 1;

                    min = Math.min(min, len);
                }
            }

            res[i] = (min == Integer.MAX_VALUE) ? -1 : min;
        }

        return res;
    }
}
