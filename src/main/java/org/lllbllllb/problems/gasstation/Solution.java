package org.lllbllllb.problems.gasstation;

/**
 * <a href="https://leetcode.com/problems/gas-station/">134. Gas Station</a>
 */
class Solution {

    // 1 ms
    public int canCompleteCircuit(int[] gas, int[] cost) {
        var n = gas.length;
        var tank = 0;
        var debt = Integer.MAX_VALUE;
        var maxDebtPos = 0;

        for (int i = 0; i < n; i++) {
            tank += (gas[i] - cost[i]);

            if (tank < debt) {
                debt = tank;
                maxDebtPos = i;
            }
        }

        if (tank > -1) {
            var start = maxDebtPos + 1;

            return start < n ? start : start - n;
        }

        return -1;
    }

    // 926 ms
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        var n = gas.length;

        for (int i = 0; i < n; i++) {
            if (gas[i] == 0 || cost [i] > gas[i]) {
                continue;
            }

            var tank = 0;
            var stationCount = 0;

            while (tank > -1) {
                if (stationCount == n) {
                    return i;
                }

                var station = i + stationCount;

                if (station > n - 1) {
                    station -= n;
                }

                tank += (gas[station] - cost[station]);

                stationCount++;
            }
        }

        return -1;
    }
}
