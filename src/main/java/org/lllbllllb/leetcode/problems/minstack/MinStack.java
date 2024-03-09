package org.lllbllllb.leetcode.problems.minstack;

/**
 * <a href="https://leetcode.com/problems/min-stack/">155. Min Stack</a>
 */
// 3 ms
class MinStack {

    private Node head;

    public MinStack() {

    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(val, head.minVal), head);
        }
    }

    public void pop() {
        head = head.prev;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.minVal;
    }

    private static class Node {

        private final int val;

        private final int minVal;

        private final Node prev;

        public Node(int val, int minVal, Node prev) {
            this.val = val;
            this.minVal = minVal;
            this.prev = prev;
        }
    }
}

// 4 ms
class MinStack1 {

    private final Integer[] stack;

    private int stackCursor = 0;

    private final Integer[] minStack;

    private int minStackCursor = 0;

    public MinStack1() {
        stack = new Integer[30001];
        minStack = new Integer[30001];
    }

    public void push(int val) {
        stack[stackCursor] = val;
        stackCursor++;

        if (minStackCursor == 0 || val <= minStack[minStackCursor - 1]) {
            minStack[minStackCursor] = val;
            minStackCursor++;
        }
    }

    public void pop() {
        var val = stack[stackCursor - 1];
        stack[stackCursor - 1] = null;
        stackCursor--;

        if (val.intValue() == minStack[minStackCursor - 1]) {
            minStack[minStackCursor - 1] = null;
            minStackCursor--;
        }
    }

    public int top() {
        return stack[stackCursor - 1];
    }

    public int getMin() {
        return minStack[minStackCursor - 1];
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
