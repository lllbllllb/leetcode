package org.lllbllllb.problems.kthlargestelementinanarray;

import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">215. Kth Largest Element in an Array</a>
 */
class Solution {

    // 3 ms, 53.2 MB
    public int findKthLargest(int[] nums, int k) {
        var max = Integer.MIN_VALUE;
        var min = Integer.MAX_VALUE;

        for (var num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        var counter = new int[max + 1 - min];

        for (var num : nums) {
            counter[num - min]++;
        }

        for (int i = counter.length - 1; i >= 0; i--) {
            k -= counter[i];

            if (k <= 0) {
                return i + min;
            }
        }

        return -1;
    }

    // 49 ms, 51.3 MB
    // O(N) + O(Klogk) -> O(N) if K less than N
    public int findKthLargest2(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>(k);

        for (var num : nums) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num > pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        return pq.poll();
    }

    // 14 ms, 54.1 MB
    public int findKthLargest1(int[] nums, int k) {
        quickSelectTwoPointers(nums, 0, nums.length - 1, nums.length - k);

        return nums[nums.length - k];
    }

    private void quickSelectTwoPointers(int[] nums, int from, int to, int target) {
        if (from >= to) {
            return;
        }

        var pivot = partition(nums, from, to);

        if (pivot > target) {
            quickSelectTwoPointers(nums, from, pivot - 1, target);
        } else if (pivot < target) {
            quickSelectTwoPointers(nums, pivot + 1, to, target);
        }
    }

    private int partition(int[] nums, int from, int to) {
        var pivot = nums[to];
        var left = from;
        var right = to;

        while (left < right) {
            while (left < right && nums[left] < pivot) {
                left++;
            }

            while (left < right && nums[right] >= pivot) {
                right--;
            }

            swap(nums, left, right);
        }

        swap(nums, left, to);

        return left;
    }

    // 58 ms, 53.8 MB
    public int findKthLargest3(int[] nums, int k) {
        quickSelect(nums, 0, nums.length, nums.length - k);

        return nums[nums.length - k];
    }

    private void quickSelect(int[] nums, int from, int to, int target) {
        if (from >= to) {
            return;
        }

        var pivot = nums[to - 1];
        var k = from;

        for (int i = from; i < to; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, k);

                k++;
            }
        }

        if (k - 1 == target) {
            return;
        }

        quickSelect(nums, from, k - 1, target);
        quickSelect(nums, k, to, target);
    }

    private void swap(int[] nums, int i, int j) {
        var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
