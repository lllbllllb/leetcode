package org.lllbllllb.problems.slidingwindowmaximum;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/sliding-window-maximum/">239. Sliding Window Maximum</a>
 */
class Solution {

    // 8 ms, 61.3 MB
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        var stack = new int[nums.length];
        var stackCursorEnd = 0;
        var stackCursorHead = 0; // max

        for (int i = 0; i < k; i++) {
            var num = nums[i];

            while (stackCursorEnd > 0 && stack[stackCursorEnd - 1] < num) {
                stackCursorEnd--;
            }

            stack[stackCursorEnd] = num;
            stackCursorEnd++;
        }

        var res = new int[nums.length - k + 1];
        var cursor = 0;
        res[cursor] = stack[stackCursorHead];
        cursor++;

        for (int i = k; i < nums.length; i++) {
            var in = nums[i];
            var out = nums[i - k];

            if (out == stack[stackCursorHead]) {
                stackCursorHead++;
            }

            while (stackCursorEnd - stackCursorHead > 0 && stack[stackCursorEnd - 1] < in) {
                stackCursorEnd--;
            }

            stack[stackCursorEnd] = in;
            stackCursorEnd++;
            res[cursor] = stack[stackCursorHead];
            cursor++;
        }

        return res;
    }

    // 28 ms, 59 MB
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[0];
        }

        var stack = new LinkedList<Integer>();

        for (int i = 0; i < k; i++) {
            var num = nums[i];

            while (!stack.isEmpty() && stack.peekFirst() < num) {
                stack.pop();
            }

            stack.push(num);
        }

        var res = new int[nums.length - k + 1];
        var cursor = 0;
        res[cursor] = stack.peekLast();
        cursor++;

        for (int i = k; i < nums.length; i++) {
            var in = nums[i];
            var out = nums[i - k];

            if (out == stack.peekLast()) {
                stack.pollLast();
            }

            while (!stack.isEmpty() && stack.peekFirst() < in) {
                stack.pop();
            }

            stack.push(in);
            res[cursor] = stack.peekLast();
            cursor++;
        }

        return res;
    }

    // Time Limit Exceeded
    public int[] maxSlidingWindow1(int[] nums, int k) {
        var heap = new PriorityQueue<Integer>(k, Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            var num = nums[i];
            heap.offer(num);
        }

        var res = new int[nums.length - k + 1];
        var cursor = 0;
        res[cursor] = heap.peek();
        cursor++;

        for (int i = k; i < nums.length; i++) {
            var in = nums[i];
            var out = nums[i - k];

            heap.remove(out);
            heap.offer(in);
            res[cursor] = heap.peek();

            cursor++;
        }

        return res;
    }
}
