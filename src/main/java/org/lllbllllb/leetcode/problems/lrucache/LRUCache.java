package org.lllbllllb.leetcode.problems.lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/lru-cache">146. LRU Cache</a>
 */
class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>(capacity);
    }

    public int get(int key) {
        var node = cache.get(key);

        if (node == null) {
            return -1;
        }

        var val = node.val;

        if (node == head) {
            return val;
        }

        if (node == tail) {
            tail = node.prev;
        }

        node.unlink();
        node.add(head);
        head = node;

        return val;
    }

    public void put(int key, int value) {
        var existed = cache.get(key);

        if (existed != null) {
            get(key);
            existed.val = value;
        } else {
            var node = new Node(key, value);

            if (cache.size() == capacity) {
                var prev = tail.prev;

                cache.remove(tail.key);
                tail.unlink();
                tail = prev;
            }

            if (tail == null) {
                tail = node;
            } else {
                node.add(head);
            }

            head = node;
            cache.put(key, node);
        }
    }

    private static class Node {
        private final int key;
        private int val;
        private Node prev;
        private Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public void add(Node node) {
            node.prev = this;
            next = node;
        }

        public void unlink() {
            if (prev != null) {
                prev.next = next;
            }

            if (next != null) {
                next.prev = prev;
            }

            this.next = null;
            this.prev = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

