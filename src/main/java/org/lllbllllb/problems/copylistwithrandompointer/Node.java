package org.lllbllllb.problems.copylistwithrandompointer;

import java.util.Objects;

class Node {

    int val;

    Node next;

    Node random;

    Node(int val) {
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return val == node.val && Objects.equals(next, node.next) && Objects.equals(random, node.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next, random);
    }

    @Override
    public String toString() {
        return "Node{" +
            "val=" + val +
            ", next=" + next +
            ", random=" + random +
            '}';
    }
}
