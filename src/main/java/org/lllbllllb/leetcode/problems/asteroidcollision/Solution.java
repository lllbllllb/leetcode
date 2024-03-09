package org.lllbllllb.leetcode.problems.asteroidcollision;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/asteroid-collision">735. Asteroid Collision</a>
 */
class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        var state = new LinkedList<Integer>();

        for (int asteroid : asteroids) {
            while (true) {
                if (asteroid > 0) {
                    state.offer(asteroid);
                    break;
                }

                var concurrent = state.pollLast();

                if (concurrent == null) {
                    state.offer(asteroid);
                    break;
                }

                if (concurrent < 0) {
                    state.offer(concurrent);
                    state.offer(asteroid);
                    break;
                }

                if (asteroid + concurrent > 0) {
                    state.offer(concurrent);
                    break;
                }

                if (asteroid + concurrent == 0) {
                    break;
                }
            }
        }

        var res = new int[state.size()];

        for (int i = 0; i < state.size(); i++) {
            res[i] = state.get(i);
        }

        return res;
    }
}
