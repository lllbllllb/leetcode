package org.lllbllllb.leetcode.problems.evaluatereversepolishnotation;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/evaluate-reverse-polish-notation/">150. Evaluate Reverse Polish Notation</a>
 */
// 2 ms, 41.6 MB
class Solution {

    public int evalRPN(String[] tokens) {
        var stack = new int[10000];
        var cursor = 0;

        for (var token : tokens) {
            switch (token) {
                case "+" -> {
                    var sum1 = stack[--cursor];
                    var sum2 = stack[--cursor];

                    stack[cursor++] = sum1 + sum2;
                }
                case "-" -> {
                    var sub = stack[--cursor];
                    var red = stack[--cursor];

                    stack[cursor++] = red - sub;
                }
                case "*" -> {
                    var mult1 = stack[--cursor];
                    var mult2 = stack[--cursor];

                    stack[cursor++] = mult1 * mult2;
                }
                case "/" -> {
                    var divider = stack[--cursor];
                    var divisible = stack[--cursor];

                    stack[cursor++] = divisible / divider;
                }
                default -> stack[cursor++] = Integer.parseInt(token);
            }
        }

        return stack[0];
    }
}

// 3 ms, 41.8 MB
class Solution1 {

    public int evalRPN(String[] tokens) {
        var stack = new LinkedList<Integer>();

        for (var token : tokens) {
            switch (token) {
                case "+" -> {
                    var sum = stack.pop() + stack.pop();

                    stack.push(sum);
                }
                case "-" -> {
                    var sub = stack.pop();
                    var red = stack.pop();

                    stack.push(red - sub);
                }
                case "*" -> {
                    var prod = stack.pop() * stack.pop();

                    stack.push(prod);
                }
                case "/" -> {
                    var divider = stack.pop();
                    var divisible = stack.pop();

                    stack.push(divisible / divider);
                }
                default -> stack.push(Integer.valueOf(token));
            }
        }

        return stack.pop();
    }
}
