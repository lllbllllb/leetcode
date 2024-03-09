package org.lllbllllb.leetcode.problems.topkfrequentelements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/top-k-frequent-elements/">347. Top K Frequent Elements</a>
 */
class Solution {

    // 8 ms, O(n), O(n)
    public int[] topKFrequent(int[] nums, int k) {
        var numToCountMap = new HashMap<Integer, Integer>();

        for (var num : nums) {
            var count = numToCountMap.getOrDefault(num, 0);
            numToCountMap.put(num, count + 1);
        }

        var freqList = new ArrayList[nums.length + 1]; // skip 0

        for (var entry : numToCountMap.entrySet()) {
            var num = entry.getKey();
            var freq = entry.getValue();

            if (freqList[freq] == null) {
                freqList[freq] = new ArrayList<>();
            }

            freqList[freq].add(num);
        }

        var res = new int[k];
        var cursor = 0;

        for (int i = freqList.length - 1; i > -1; i--) {
            var freqNums = freqList[i];

            if (freqNums != null) {
                for (var num : freqNums) {
                    res[cursor] = (int) num;
                    cursor++;

                    if (cursor == k) {
                        return res;
                    }
                }
            }
        }

        return res;
    }

    // 12 ms (heap streaming), O(n log(k)), O(n)
    public int[] topKFrequent1(int[] nums, int k) {
        var numToCountMap = new HashMap<Integer, Integer>();

        for (var num : nums) {
            var count = numToCountMap.getOrDefault(num, 0);
            numToCountMap.put(num, count + 1);
        }

        var pq = new PriorityQueue<Map.Entry<Integer, Integer>>(Map.Entry.comparingByValue());

        for (var entry : numToCountMap.entrySet()) {
            pq.add(entry);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        var result = new int[k];
        var pqIter = pq.iterator();
        var idx = 0;

        while (pqIter.hasNext()) {
            var val = pqIter.next().getKey();
            result[idx] = val;
            idx++;
        }

        return result;
    }
}
