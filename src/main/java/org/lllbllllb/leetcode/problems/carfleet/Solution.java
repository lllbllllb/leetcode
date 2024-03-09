package org.lllbllllb.leetcode.problems.carfleet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/car-fleet/">853. Car Fleet</a>
 */
// 29 ms, 52.1 MB
class Solution {

    public int carFleet(int target, int[] position, int[] speed) {
        var cars = new int[target + 1];

        // sorting
        for (int i = 0; i < position.length; i++) {
            cars[position[i]] = speed[i];
        }

        var stack = new double[position.length];
        var stackCursor = 0;
        var count = position.length;

        // monotonic stack
        for (int i = 0; i < cars.length; i++) {
            var speedI = cars[i];

            if (speedI != 0) {
                var arrival = (target - i) / (double) speedI;

                while (stackCursor > 0 && stack[stackCursor - 1] <= arrival) {
                    stackCursor--;
                    count--;
                }

                stack[stackCursor] = arrival;
                stackCursor++;
            }
        }

        return count;
    }


}

// 108 ms, 58 MB
class Solution1 {

    public int carFleet(int target, int[] position, int[] speed) {
        var len = position.length;
        var cars = new Car[len];

        for (int i = 0; i < len; i++) {
            cars[i] = new Car(i, position[i], speed[i]);
        }

        Arrays.sort(cars, Comparator.comparingInt(Car::position));

        var stack = new LinkedList<Double>();

        // monotonic stack
        for (int i = 0; i < len; i++) {
            var arrival = cars[i].arrival(target);

            while (!stack.isEmpty() && stack.getFirst() <= arrival) {
                stack.pop();
            }

            stack.push(arrival);
        }

        return stack.size();
    }

    public record Car(
            int num,
            int position,
            int speed
    ) {

        public double arrival(int target) {
            return (target - position) / (double) speed;
        }
    }
}