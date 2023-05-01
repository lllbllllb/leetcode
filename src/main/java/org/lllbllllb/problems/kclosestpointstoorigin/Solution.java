package org.lllbllllb.problems.kclosestpointstoorigin;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/k-closest-points-to-origin/">973. K Closest Points to Origin</a>
 */
class Solution {

    // 40 ms, 51 MB O(NlogK)
    public int[][] kClosest(int[][] points, int k) {
        var pq = new PriorityQueue<int[]>(k, ((p1, p2) -> (p2[0] * p2[0] + p2[1] * p2[1]) - (p1[0] * p1[0] + p1[1] * p1[1])));

        for (var point : points) {
            pq.offer(point);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        var res = new int[k][2];

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }

    // 31 ms, 50.9 MB O(NlogN)
    public int[][] kClosest1(int[][] points, int k) {
        var pq = new PriorityQueue<int[]>(points.length, Comparator.comparingInt(p -> p[0] * p[0] + p[1] * p[1]));

        for (var point : points) {
            pq.offer(point);
        }

        var res = new int[k][2];

        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}
