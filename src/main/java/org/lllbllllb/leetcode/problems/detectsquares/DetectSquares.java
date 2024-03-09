package org.lllbllllb.leetcode.problems.detectsquares;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/detect-squares/">2013. Detect Squares</a>
 */

// 42ms, 47.90MB
class DetectSquares {

    private final Map<Integer, Map<Integer, Integer>> yToXToCountMap = new HashMap<>();

    public void add(int[] point) {
        var pX = point[0];
        var pY = point[1];

        yToXToCountMap
                .computeIfAbsent(pY, p -> new HashMap<>())
                .compute(pX, (p, count) -> count == null ? 1 : count + 1);
    }

    public int count(int[] point) {
        var pX_0 = point[0];
        var pY_0 = point[1];
        var count = 0;

        for (var xToCountEntry : yToXToCountMap.getOrDefault(pY_0, Map.of()).entrySet()) {
            var pX_1 = xToCountEntry.getKey();

            if (pX_1.equals(pX_0)) {
                continue;
            }

            var count1 = xToCountEntry.getValue();
            var len = pX_0 - pX_1;
            var count2 = yToXToCountMap
                    .getOrDefault(pY_0 - len, Map.of())
                    .getOrDefault(pX_0 - len, 0);
            var count3 = yToXToCountMap
                    .getOrDefault(pY_0 - len, Map.of())
                    .getOrDefault(pX_0, 0);

            count += (count1 * count2 * count3);

            var count4 = yToXToCountMap
                    .getOrDefault(pY_0 + len, Map.of())
                    .getOrDefault(pX_0 - len, 0);
            var count5 = yToXToCountMap
                    .getOrDefault(pY_0 + len, Map.of())
                    .getOrDefault(pX_0, 0);

            count += (count1 * count4 * count5);
        }

        return count;
    }
}

// 53ms, 58.13MB
class DetectSquares1 {

    private static final int SIZE = 1001;
    private final int[][] xy = new int[SIZE][SIZE];

    public void add(int[] point) {
        var pX = point[0];
        var pY = point[1];

        xy[pX][pY]++;
    }

    public int count(int[] point) {
        var pX_0 = point[0];
        var pY_0 = point[1];
        var count = 0;

        for (int pY_1 = 0; pY_1 < SIZE; pY_1++) {
            var count_1 = xy[pX_0][pY_1];

            if (pY_1 != pY_0 && count_1 != 0) {
                var len = pY_0 - pY_1;
                var pX_2 = pX_0 - len;
                var pY_2 = pY_0 - len;

                if (pX_2 >= 0 && pX_2 < SIZE && pY_2 < SIZE) {
                    var count_2 = xy[pX_2][pY_2];
                    var count_3 = xy[pX_2][pY_0];

                    count += (count_1 * count_2 * count_3);
                }

                var pX_3 = pX_0 + len;

                if (pX_3 >= 0 && pX_3 < SIZE && pY_2 < SIZE) {
                    var count_4 = xy[pX_3][pY_2];
                    var count_5 = xy[pX_3][pY_0];

                    count += (count_1 * count_4 * count_5);
                }
            }
        }

        return count;
    }
}
/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */