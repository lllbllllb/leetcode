package org.lllbllllb.leetcode.problems.cheapestflightswithinkstops;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/cheapest-flights-within-k-stops/">787. Cheapest Flights Within K Stops</a>
 */
class Solution {

    // 3 ms, 42.81 MB
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        var cityCosts = new int[n];
        Arrays.fill(cityCosts, Integer.MAX_VALUE);
        cityCosts[src] = 0;
        var updated = true;

        for (int i = 0; i < k + 1; i++) {
            if (!updated) {
                break;
            }

            updated = false;
            var cityCostsLevelTmp = Arrays.copyOf(cityCosts, n);

            for (var flight : flights) {
                var from = flight[0];
                var to = flight[1];
                var cost = flight[2];
                var currentCost = cityCostsLevelTmp[to];
                var newCost = cityCosts[from] + cost;

                if (cityCosts[from] != Integer.MAX_VALUE && newCost < currentCost) {
                    cityCostsLevelTmp[to] = newCost;
                    updated = true;
                }
            }

            cityCosts = cityCostsLevelTmp;
        }

        return cityCosts[dst] != Integer.MAX_VALUE ? cityCosts[dst] : -1;
    }

}

// 6 ms, 42.66 MB
class Solution1 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        var cityCosts = new int[n];
        Arrays.fill(cityCosts, Integer.MAX_VALUE);
        cityCosts[src] = 0;

        for (int i = 0; i < k + 1; i++) {
            var nextLevelCityCosts = Arrays.copyOf(cityCosts, cityCosts.length);

            for (var flight : flights) {
                var currSrc = flight[0];
                var currDest = flight[1];
                var cost = flight[2];
                var cityCost = cityCosts[currSrc];

                if (cityCost == Integer.MAX_VALUE) {
                    continue;
                }

                var currDestCost = nextLevelCityCosts[currDest];
                var nextDestCost = cityCosts[currSrc] + cost;

                nextLevelCityCosts[currDest] = Math.min(currDestCost, nextDestCost);
            }

            cityCosts = nextLevelCityCosts;
        }

        return cityCosts[dst] != Integer.MAX_VALUE ? cityCosts[dst] : -1;
    }
}