package org.lllbllllb.problems.findmedianfromdatastream;

import java.util.Comparator;
import java.util.PriorityQueue;

class MedianFinder {

    private final PriorityQueue<Integer> max = new PriorityQueue<>();

    private final PriorityQueue<Integer> min = new PriorityQueue<>(Comparator.reverseOrder());

    public MedianFinder() {}

    public void addNum(int num) {
        if (min.isEmpty() || min.peek() >= num) {
            min.offer(num);
        } else if (min.peek() < num) {
            max.offer(num);
        }

        rebalance();
    }

    public double findMedian() {
//        rebalance();

        if (max.size() > min.size()) {
            return max.peek();
        }

        if (min.size() > max.size()) {
            return min.peek();
        }

        return (min.peek() + max.peek()) / 2.0;
    }

    private void rebalance() {
        while (min.size() - max.size() > 1) {
            max.offer(min.poll());
        }

        while (max.size() - min.size() > 1) {
            min.offer(max.poll());
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
