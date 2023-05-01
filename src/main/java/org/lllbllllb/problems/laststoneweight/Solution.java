package org.lllbllllb.problems.laststoneweight;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/last-stone-weight/">1046. Last Stone Weight</a>
 */
class Solution {
    public int lastStoneWeight(int[] stones) {
        var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());

        for (var stone : stones) {
            pq.offer(stone);
        }

        while (pq.size() > 1) {
            var s1 = pq.poll();
            var s2 = pq.poll();

            if (s1 != s2) {
                pq.offer(s1 - s2);
            }
        }

        if (pq.size() == 1) {
            return pq.poll();
        }

        return 0;
    }
}
